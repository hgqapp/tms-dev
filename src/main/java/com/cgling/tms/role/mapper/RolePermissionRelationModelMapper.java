package com.cgling.tms.role.mapper;

import com.cgling.tms.role.model.RolePermissionRelationModel;

public interface RolePermissionRelationModelMapper {
    
    int deleteByPrimaryKey(Long relationId);

    int insert(RolePermissionRelationModel record);

    int insertSelective(RolePermissionRelationModel record);

    RolePermissionRelationModel selectByPrimaryKey(Long relationId);

    int updateByPrimaryKeySelective(RolePermissionRelationModel record);

    int updateByPrimaryKey(RolePermissionRelationModel record);
}