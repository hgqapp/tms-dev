package com.cgling.tms.menu.service;

import com.cgling.commons.utils.BizAssert;
import com.cgling.tms.menu.mapper.MenuInfoModelMapper;
import com.cgling.tms.menu.mapper.MenuPermissionRelationModelMapper;
import com.cgling.tms.menu.model.MenuInfoModel;
import com.cgling.tms.menu.model.MenuPermissionRelationModel;
import com.cgling.tms.permission.mapper.PermissionInfoModelMapper;
import com.cgling.tms.permission.model.PermissionInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class MenuPermissionService {

    @Autowired
    private MenuPermissionRelationModelMapper menuPermissionRelationModelMapper;
    @Autowired
    private MenuInfoModelMapper menuInfoModelMapper;
    @Autowired
    private PermissionInfoModelMapper permissionInfoModelMapper;

    public void create(Long menuId, Long permissionId){
        BizAssert.notNull(menuId, "菜单ID不能为空！");
        BizAssert.notNull(permissionId, "权限码ID不能为空！");
        MenuInfoModel menuInfoModel = menuInfoModelMapper.selectByPrimaryKey(menuId);
        BizAssert.notNull(menuInfoModel, "菜单ID【%s】不存在！", menuId);
        PermissionInfoModel permissionInfoModel = permissionInfoModelMapper.selectByPrimaryKey(permissionId);
        BizAssert.notNull(permissionInfoModel, "权限码ID【%s】不存在！", permissionId);
        MenuPermissionRelationModel relationModel = new MenuPermissionRelationModel(menuId, permissionId);
        menuPermissionRelationModelMapper.insert(relationModel);
    }

    public void deleteByPermissionId(Long permissionId){
        Objects.requireNonNull(permissionId);
        menuPermissionRelationModelMapper.deleteByPermissionId(permissionId);
    }

    public void deleteByPermissionIds(List<Long> permissionIds) {
        Objects.requireNonNull(permissionIds);
        if (permissionIds.isEmpty()) {
            return;
        }
        menuPermissionRelationModelMapper.deleteByPermissionIds(permissionIds);
    }

    public void deleteByMenuId(Long menuId) {
        Objects.requireNonNull(menuId);
        menuPermissionRelationModelMapper.deleteByMenuId(menuId);
    }

    public void deleteByMenuIds(List<Long> menuIds) {
        Objects.requireNonNull(menuIds);
        if (menuIds.isEmpty()) {
            return;
        }
        menuPermissionRelationModelMapper.deleteByMenuIds(menuIds);
    }
}
