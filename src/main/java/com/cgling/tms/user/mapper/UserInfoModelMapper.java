package com.cgling.tms.user.mapper;

import com.cgling.tms.user.model.UserInfoModel;

public interface UserInfoModelMapper {
    
    int deleteByPrimaryKey(Long userId);

    int insert(UserInfoModel record);

    int insertSelective(UserInfoModel record);

    UserInfoModel selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserInfoModel record);

    int updateByPrimaryKey(UserInfoModel record);

}