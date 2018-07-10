package com.cgling.tms.menu.service;

import com.cgling.commons.beans.paging.PageData;
import com.cgling.commons.beans.paging.PageRequest;
import com.cgling.commons.exceptions.BusinessException;
import com.cgling.commons.utils.BizAssert;
import com.cgling.tms.common.consts.Constants;
import com.cgling.tms.menu.bean.condition.MenuCondition;
import com.cgling.tms.menu.mapper.MenuInfoModelMapper;
import com.cgling.tms.menu.mapper.MenuPermissionRelationModelMapper;
import com.cgling.tms.menu.model.MenuInfoModel;
import com.cgling.tms.permission.model.PermissionInfoModel;
import com.cgling.tms.permission.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    private MenuInfoModelMapper menuInfoModelMapper;
    @Autowired
    private MenuPermissionRelationModelMapper menuPermissionRelationModelMapper;
    @Autowired
    private PermissionService permissionService;

    /**
     * 菜单分页查询
     * @param condition 查询条件
     * @param pageRequest 分页请求
     * @return 分页数据
     */
    public PageData getMenuPage(MenuCondition condition, PageRequest pageRequest) {
        int totalCount = menuInfoModelMapper.getTotalCountByCondition(condition);
        List<MenuInfoModel> records = menuInfoModelMapper.getPageByCondition(condition, pageRequest);
        return new PageData(totalCount, records, pageRequest);
    }

    /**
     * 获取菜单信息
     * @param menuId 菜单ID
     * @return 返回菜单Model
     */
    public MenuInfoModel getMenuInfo(Long menuId) {
        BizAssert.notNull(menuId, "菜单ID不能为空！");
        return menuInfoModelMapper.getByMenuId(menuId);
    }

    /**
     * 获取菜单列表
     * @param condition 查询条件
     * @return 返回菜单列表
     */
    public List<MenuInfoModel> getMenuList(MenuCondition condition) {
        return menuInfoModelMapper.getListByCondition(condition);
    }

    /**
     * 新增菜单
     * @param menuInfoModel 菜单Model
     * @return 返回新增的菜单ID
     */
    public Long create(MenuInfoModel menuInfoModel) {
        checkInput(menuInfoModel, false);
        menuInfoModelMapper.insertSelective(menuInfoModel);
        Long menuId = menuInfoModel.getMenuId();
        PermissionInfoModel permissionInfoModel = preparePermissionInfo(menuInfoModel, false);
        permissionService.create(permissionInfoModel, menuId);

        return menuId;
    }

    /**
     * 更新菜单
     * @param menuInfoModel 菜单Model
     * @return 更新成功返回true，否则false
     */
    public boolean update(MenuInfoModel menuInfoModel) {
        checkInput(menuInfoModel, true);
        boolean result = menuInfoModelMapper.updateByPrimaryKeySelective(menuInfoModel) > 0;
        PermissionInfoModel permissionInfoModel = preparePermissionInfo(menuInfoModel, true);
        permissionService.update(permissionInfoModel);
        return result;
    }

    /**
     * 删除菜单，有子菜单将不能删除
     * @param menuId 菜单ID
     * @return 删除成功返回true，否色返回false
     */
    public boolean delete(Long menuId) {
        BizAssert.notNull(menuId, "菜单ID不能为空");
        checkDeletable(Collections.singletonList(menuId));
        menuInfoModelMapper.deleteByPrimaryKey(menuId);
        return true;
    }

    /**
     * 批量删除菜单，有子菜单将不能删除
     * @param menuIds 菜单ID列表
     * @return 删除成功返回true，否色返回false
     */
    public boolean delete(List<Long> menuIds) {
        BizAssert.notEmpty(menuIds, "角色ID不能为空");
        checkDeletable(menuIds);
        menuInfoModelMapper.deleteByMenuIds(menuIds);
        return true;
    }

    private void checkDeletable(List<Long> menuIds) {
        MenuInfoModel childMenuInfoModel = menuInfoModelMapper.selectOneByParentIds(menuIds);
        if (childMenuInfoModel != null) {
            MenuInfoModel dbMenuInfo = menuInfoModelMapper.selectByPrimaryKey(childMenuInfoModel.getParentId());
            BizAssert.notNull(dbMenuInfo, "菜单ID【%s】不存在！", childMenuInfoModel.getParentId());
            throw new BusinessException("菜单【%s】不能被删除，因为它已经被子菜单【%s】引用！", dbMenuInfo.getName(), childMenuInfoModel.getName());
        }
    }

    private PermissionInfoModel preparePermissionInfo(MenuInfoModel menuInfoModel, boolean update) {
        PermissionInfoModel permissionInfoModel = new PermissionInfoModel();
        permissionInfoModel.setName(menuInfoModel.getName());
        permissionInfoModel.setCode(menuInfoModel.getCode());
        if (update) {
            Long permissionId = menuPermissionRelationModelMapper.getPermissionIdByMenuId(menuInfoModel.getMenuId());
            permissionInfoModel.setPermissionId(permissionId);
        } else {
            permissionInfoModel.setType(Constants.PermissionCodeType.MENU.getValue());
        }
        return permissionInfoModel;
    }

    private void checkInput(MenuInfoModel menuInfoModel, boolean update) {
        String name = menuInfoModel.getName();
        if (update) {
            Long menuId = menuInfoModel.getMenuId();
            BizAssert.notNull(menuId, "菜单ID不能为空！");
            MenuInfoModel dbMenuInfoModel = menuInfoModelMapper.getByMenuId(menuId);
            BizAssert.notNull(dbMenuInfoModel, "菜单ID【%s】不存在！", menuId);
            if (name == null) {
                name = dbMenuInfoModel.getName();
            } else {
                BizAssert.hasText(name, "菜单名称不能为空！");
            }
            menuInfoModel.setUpdateTime(System.currentTimeMillis());
        } else {
            BizAssert.hasText(name, "菜单名称不能为空！");
            BizAssert.notNull(menuInfoModel.getType(), "菜单【%s】的类型不能为空！", name);
            if (menuInfoModel.getParentId() == null) {
                menuInfoModel.setParentId(Constants.DEFAULT_LOING_VALUE);
            }
            if (menuInfoModel.getStatus() == null) {
                menuInfoModel.setStatus(Constants.Status.ENABLE.getValue());
            }
            if (menuInfoModel.getOrders() == null) {
                Integer dbOrders = menuInfoModelMapper.getMaxOrders();
                if (dbOrders == null) {
                    dbOrders = Constants.DEFAULT_INTEGER_VALUE;
                }
                menuInfoModel.setOrders(dbOrders + 1);
            }
            menuInfoModel.setCreateTime(System.currentTimeMillis());
            menuInfoModel.setUpdateTime(menuInfoModel.getCreateTime());
        }
        String menuName = menuInfoModel.getName();
        if (menuName != null) {
            MenuInfoModel checkName = menuInfoModelMapper.getByName(menuName);
            BizAssert.isTrue(checkName == null || checkName.getMenuId().equals(menuInfoModel.getMenuId()), "菜单名称【%s】已存在！", name);
        }
        Long parentId = menuInfoModel.getParentId();
        if (parentId != null && parentId > Constants.DEFAULT_LOING_VALUE) {
            BizAssert.notNull(menuInfoModelMapper.getByMenuIdAndStatus(parentId, Constants.Status.ENABLE.getValue()), "菜单【%s】引用的父菜单ID【】不存在或已被禁用！", name, parentId);
        }
        Byte type = menuInfoModel.getType();
        if (type != null) {
            BizAssert.notNull(Constants.MenuType.of(type), "菜单【%s】的类型【%s】不支持！", name, type);
        }
        Byte status = menuInfoModel.getStatus();
        if (status != null) {
            BizAssert.notNull(Constants.Status.of(status), "菜单【%s】的状态值【%s】不支持！", name, status);
        }
    }
}
