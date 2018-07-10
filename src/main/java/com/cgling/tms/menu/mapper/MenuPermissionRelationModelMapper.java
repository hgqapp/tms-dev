package com.cgling.tms.menu.mapper;

import com.cgling.tms.menu.model.MenuPermissionRelationModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuPermissionRelationModelMapper {
    
    int deleteByPrimaryKey(Long relationId);

    int insert(MenuPermissionRelationModel record);

    int insertSelective(MenuPermissionRelationModel record);

    MenuPermissionRelationModel selectByPrimaryKey(Long relationId);

    int updateByPrimaryKeySelective(MenuPermissionRelationModel record);

    int updateByPrimaryKey(MenuPermissionRelationModel record);

    int deleteByPermissionId(Long permissionId);

    int deleteByPermissionIds(@Param("permissionIds") List<Long> permissionIds);

    int deleteByMenuId(Long menuId);

    int deleteByMenuIds(@Param("menuIds") List<Long> menuIds);

    Long getPermissionIdByMenuId(Long menuId);
}