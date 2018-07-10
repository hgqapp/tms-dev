package com.cgling.tms.role.service;

import com.cgling.commons.beans.paging.PageData;
import com.cgling.commons.beans.paging.PageRequest;
import com.cgling.commons.utils.BizAssert;
import com.cgling.tms.common.consts.Constants;
import com.cgling.tms.role.bean.condition.RoleCondition;
import com.cgling.tms.role.mapper.RoleInfoModelMapper;
import com.cgling.tms.role.model.RoleInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * 角色业务类
 * @author houguangqiang
 * @date 2017-12-03
 * @since 1.0
 */
@Service
public class RoleService {

    @Autowired
    private RoleInfoModelMapper roleInfoModelMapper;

    /**
     * 角色分页查询
     * @param condition 查询条件
     * @param pageRequest 分页请求
     * @return 分页数据
     */
    public PageData getRolePage(RoleCondition condition, PageRequest pageRequest) {
        int totalCount = roleInfoModelMapper.getTotalCountByCondition(condition);
        List<RoleInfoModel> records = roleInfoModelMapper.getPageByCondition(condition, pageRequest);
        return new PageData(totalCount, records, pageRequest);
    }

    /**
     * 获取角色
     * @param roleId 角色ID
     * @return 角色Model
     */
    public RoleInfoModel getRoleInfo(Long roleId){
        BizAssert.notNull(roleId, "角色ID不能为空！");
        return roleInfoModelMapper.selectByPrimaryKey(roleId);
    }

    /**
     * 获取角色列表
     * @param condition 角色ID
     * @return 角色Model
     */
    public List<RoleInfoModel> getRoleList(RoleCondition condition){
        return roleInfoModelMapper.getListByCondition(condition);
    }

    /**
     * 根据ID获取角色Model
     * @param roleId 角色ID
     * @return 角色Model
     */
    public RoleInfoModel getByRoleId(Long roleId){
        return roleInfoModelMapper.selectByPrimaryKey(roleId);
    }

    /**
     * 根据多个ID获取角色Model
     * @param roleIds 角色ID的集合
     * @return 角色Model
     */
    public List<RoleInfoModel> getByRoleIds(List<Long> roleIds){
        if (roleIds == null || roleIds.isEmpty()) {
            return Collections.emptyList();
        }
        return roleInfoModelMapper.getByRoleIds(roleIds);
    }


    /**
     * 创建角色
     * @param roleInfoModel 角色Model
     * @return 返回新增的角色ID
     */
    public Long create(RoleInfoModel roleInfoModel){
        checkInput(roleInfoModel, false);
        roleInfoModelMapper.insertSelective(roleInfoModel);
        return roleInfoModel.getRoleId();
    }

    /**
     * 更新角色
     * @param roleInfoModel 角色Model
     * @return 更新成功返回true，否则false
     */
    public Boolean update(RoleInfoModel roleInfoModel){
        checkInput(roleInfoModel, true);
        return roleInfoModelMapper.updateByPrimaryKeySelective(roleInfoModel) > 0;
    }

    /**
     * 删除角色
     * @param roleId 角色ID
     * @return 删除成功返回true，否色返回false
     */
    public Boolean delete(Long roleId){
        BizAssert.notNull(roleId, "角色ID不能为空");
        return roleInfoModelMapper.deleteByPrimaryKey(roleId) > 0;
    }

    /**
     * 批量删除角色
     * @param roleIds 角色ID列表
     * @return 删除成功返回true，否色返回false
     */
    public Boolean delete(List<Long> roleIds){
        BizAssert.notEmpty(roleIds, "角色ID不能为空");
        return roleInfoModelMapper.deleteByRoleIds(roleIds) > 0;
    }

    private void checkInput(RoleInfoModel roleInfoModel, boolean update) {
        String name = roleInfoModel.getName();
        if (update) {
            Long roleId = roleInfoModel.getRoleId();
            BizAssert.notNull(roleId, "角色【%s】的ID不能为空！", name);
            RoleInfoModel dbRoleInfoModel = roleInfoModelMapper.selectByPrimaryKey(roleId);
            BizAssert.notNull(dbRoleInfoModel, "角色ID【%s】不存在！", roleId);
            if (roleInfoModel.getName() == null) {
                name = dbRoleInfoModel.getName();
            } else {
                BizAssert.hasText(name, "角色名称不能为空！");
            }
            roleInfoModel.setUpdateTime(System.currentTimeMillis());
        } else {
            BizAssert.hasText(name, "角色名称不能为空！");
            Integer orders = roleInfoModel.getOrders();
            if (orders == null) {
                Integer dbOrders = roleInfoModelMapper.getMaxOrders();
                if (dbOrders == null) {
                    dbOrders = Constants.DEFAULT_INTEGER_VALUE;
                }
                roleInfoModel.setOrders(dbOrders + 1);
            }
            String description = roleInfoModel.getDescription();
            if (description == null) {
                roleInfoModel.setDescription(Constants.DEFAULT_STRING_VALUE);
            }
            roleInfoModel.setCreateTime(System.currentTimeMillis());
            roleInfoModel.setUpdateTime(roleInfoModel.getCreateTime());
        }
        String rolelName = roleInfoModel.getName();
        if (rolelName != null) {
            RoleInfoModel checkName = roleInfoModelMapper.getByName(rolelName);
            BizAssert.isTrue(checkName == null || checkName.getRoleId().equals(roleInfoModel.getRoleId()), "角色名称【%s】已经存在！", name);
        }
    }
}
