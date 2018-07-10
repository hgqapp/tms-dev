package com.cgling.tms.permission.service;

import com.cgling.commons.beans.paging.PageData;
import com.cgling.commons.beans.paging.PageRequest;
import com.cgling.commons.utils.BizAssert;
import com.cgling.tms.common.consts.Constants;
import com.cgling.tms.menu.mapper.MenuPermissionRelationModelMapper;
import com.cgling.tms.menu.service.MenuPermissionService;
import com.cgling.tms.permission.bean.condition.PermissionCondition;
import com.cgling.tms.permission.mapper.PermissionInfoModelMapper;
import com.cgling.tms.permission.model.PermissionInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 权限码业务类
 * @author houguangqiang
 * @date 2017-12-03
 * @since 1.0
 */
@Service
public class PermissionService {

    @Autowired
    private PermissionInfoModelMapper permissionInfoModelMapper;
    @Autowired
    private MenuPermissionService menuPermissionService;

    /**
     * 权限码分页查询
     * @param condition 查询条件
     * @param pageRequest 分页请求
     * @return 分页数据
     */
    public PageData getPermissionPage(PermissionCondition condition, PageRequest pageRequest) {
        int totalCount = permissionInfoModelMapper.getTotalCountByCondition(condition);
        List<PermissionInfoModel> records = permissionInfoModelMapper.getPageByCondition(condition, pageRequest);
        return new PageData(totalCount, records, pageRequest);
    }

    /**
     * 获取权限码
     * @param permissionId 权限ID
     * @return
     */
    public PermissionInfoModel getPermissionInfo(Long permissionId){
        BizAssert.notNull(permissionId, "权限码ID不能为空");
        return permissionInfoModelMapper.selectByPrimaryKey(permissionId);
    }

    /**
     * 根据ID获取权限码Model
     * @param permissionId 权限ID
     * @return
     */
    public PermissionInfoModel getByPermissionId(Long permissionId){
        return permissionInfoModelMapper.selectByPrimaryKey(permissionId);
    }

    /**
     * 新增权限码
     * @param permissionInfoModel 权限码Model
     * @param menuId 权限码所属菜单ID
     * @return 返回新增的权限码ID
     */
    public Long create(PermissionInfoModel permissionInfoModel, Long menuId){
        checkInput(permissionInfoModel, false);
        BizAssert.notNull(menuId, "权限码【%s】必须所属于某个菜单！", permissionInfoModel.getName());
        permissionInfoModelMapper.insertSelective(permissionInfoModel);
        menuPermissionService.create(menuId, permissionInfoModel.getPermissionId());
        return permissionInfoModel.getPermissionId();
    }

    /**
     * 更新权限码
     * @param permissionInfoModel 权限码Model
     * @return 更新成功返回true，否则false
     */
    public Boolean update(PermissionInfoModel permissionInfoModel){
        checkInput(permissionInfoModel, true);
        return permissionInfoModelMapper.updateByPrimaryKeySelective(permissionInfoModel) > 0;
    }

    /**
     * 删除权限码
     * @param permissionId 权限码ID
     * @return 删除成功返回true，否色返回false
     */
    public Boolean delete(Long permissionId){
        BizAssert.notNull(permissionId, "权限码ID不能为空");
        boolean result = permissionInfoModelMapper.deleteByPrimaryKey(permissionId) > 0;
        if (result) {
            menuPermissionService.deleteByPermissionId(permissionId);
        }
        return result;
    }

    /**
     * 批量删除权限码
     * @param permissionIds 角色ID列表
     * @return 删除成功返回true，否色返回false
     */
    public Boolean delete(List<Long> permissionIds){
        BizAssert.notEmpty(permissionIds, "权限码ID不能为空");
        boolean result = permissionInfoModelMapper.deleteByPermissionIds(permissionIds) > 0;
        if (result) {
            menuPermissionService.deleteByPermissionIds(permissionIds);
        }
        return result;
    }

    private void checkInput(PermissionInfoModel permissionInfoModel, boolean update) {
        String name = permissionInfoModel.getName();
        if (update) {
            Long permissionId = permissionInfoModel.getPermissionId();
            BizAssert.notNull(permissionId, "权限码ID不能为空！");
            PermissionInfoModel dbPermissionInfoModel = permissionInfoModelMapper.selectByPrimaryKey(permissionId);
            BizAssert.notNull(dbPermissionInfoModel, "权限码ID【%s】不存在！", permissionId);
            if (name == null) {
                name = dbPermissionInfoModel.getName();
            } else {
                BizAssert.hasText(name, "权限码名称不能为空！");
            }
            if (permissionInfoModel.getCode() != null) {
                BizAssert.hasText(permissionInfoModel.getCode(), "权限码【%s】的编码不能为空！", name);
            }
            permissionInfoModel.setUpdateTime(System.currentTimeMillis());
        } else {
            BizAssert.hasText(name, "权限码名称不能为空！");
            BizAssert.notNull(permissionInfoModel.getCode(), "权限码【%s】的编码不能为空！", name);
            Byte type = permissionInfoModel.getType();
            if (type == null) {
                permissionInfoModel.setType(Constants.PermissionCodeType.OPERATION.getValue());
            }
            permissionInfoModel.setCreateTime(System.currentTimeMillis());
            permissionInfoModel.setUpdateTime(permissionInfoModel.getCreateTime());
        }
        String code = permissionInfoModel.getCode();
        if (code != null) {
            PermissionInfoModel checkCode = permissionInfoModelMapper.getByCode(code);
            BizAssert.isTrue(checkCode == null || checkCode.getPermissionId().equals(permissionInfoModel.getPermissionId()), "权限码【%s】的CODE【%s】已经存在！", name, code);
        }
        Byte type = permissionInfoModel.getType();
        if (type != null) {
            BizAssert.notNull(Constants.PermissionCodeType.of(type), "权限码【%s】的类型【%s】不支持！", name);
        }
    }
}
