package com.cgling.tms.user.mapper;

import com.cgling.tms.user.model.UserDetailsModel;

public interface UserDetailsModelMapper {
    
    int deleteByPrimaryKey(Long userId);

    int insert(UserDetailsModel record);

    int insertSelective(UserDetailsModel record);

    UserDetailsModel selectByPrimaryKey(Long userId);

    int updateByPrimaryKeySelective(UserDetailsModel record);

    int updateByPrimaryKey(UserDetailsModel record);
}