package com.cgling.tms.user.mapper;

import com.cgling.tms.user.model.UserAccountModel;

public interface UserAccountModelMapper {
    
    int deleteByPrimaryKey(Long accountId);

    int insert(UserAccountModel record);

    int insertSelective(UserAccountModel record);

    UserAccountModel selectByPrimaryKey(Long accountId);

    int updateByPrimaryKeySelective(UserAccountModel record);

    int updateByPrimaryKey(UserAccountModel record);
}