package com.cgling.tms.user.mapper;

import com.cgling.tms.user.model.UserOauthRelationModel;

public interface UserOauthRelationModelMapper {
    
    int deleteByPrimaryKey(Long relationId);

    int insert(UserOauthRelationModel record);

    int insertSelective(UserOauthRelationModel record);

    UserOauthRelationModel selectByPrimaryKey(Long relationId);

    int updateByPrimaryKeySelective(UserOauthRelationModel record);

    int updateByPrimaryKey(UserOauthRelationModel record);
}