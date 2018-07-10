package com.cgling.tms.user.mapper;

import com.cgling.tms.user.model.UserRoleRelationModel;

public interface UserRoleRelationModelMapper {
    
    int deleteByPrimaryKey(Long relationId);

    int insert(UserRoleRelationModel record);

    int insertSelective(UserRoleRelationModel record);

    UserRoleRelationModel selectByPrimaryKey(Long relationId);

    int updateByPrimaryKeySelective(UserRoleRelationModel record);

    int updateByPrimaryKey(UserRoleRelationModel record);
}