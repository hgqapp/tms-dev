package com.cgling.tms.user.service;

import com.cgling.commons.utils.BizAssert;
import com.cgling.tms.user.mapper.UserDetailsModelMapper;
import com.cgling.tms.user.mapper.UserInfoModelMapper;
import com.cgling.tms.user.model.UserDetailsModel;
import com.cgling.tms.user.model.UserInfoModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author houguangqiang
 * @date 2017-11-27
 * @since 1.0
 */
@Service
public class UserService {

    @Autowired
    private UserInfoModelMapper userInfoModelMapper;
    @Autowired
    private UserDetailsModelMapper userDetailsModelMapper;

    public Long create(UserInfoModel userInfoModel, UserDetailsModel userDetailsModel){
        checkInput(userInfoModel, userDetailsModel, false);
        userInfoModelMapper.insertSelective(userInfoModel);
        return userInfoModel.getUserId();
    }

    private void checkInput(UserInfoModel userInfoModel, UserDetailsModel userDetailsModel, boolean update) {
        String username = userInfoModel.getUsername();
        BizAssert.hasText(username, "用户名不能为空！");
        if (update) {
            BizAssert.notNull(userInfoModel.getUserId(), "用户【%s】的ID不能为空！", username);
        } else {
            userInfoModel.setCreateTime(System.currentTimeMillis());
            userInfoModel.setUpdateTime(userInfoModel.getCreateTime());
        }
    }
}
