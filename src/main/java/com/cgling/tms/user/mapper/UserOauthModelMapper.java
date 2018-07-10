package com.cgling.tms.user.mapper;

import com.cgling.tms.user.model.UserOauthModel;

public interface UserOauthModelMapper {
    
    int deleteByPrimaryKey(Long oauthId);

    int insert(UserOauthModel record);

    int insertSelective(UserOauthModel record);

    UserOauthModel selectByPrimaryKey(Long oauthId);

    int updateByPrimaryKeySelective(UserOauthModel record);

    int updateByPrimaryKey(UserOauthModel record);
}