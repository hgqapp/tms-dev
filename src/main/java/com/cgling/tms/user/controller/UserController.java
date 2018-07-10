package com.cgling.tms.user.controller;

import com.cgling.tms.user.model.UserInfoModel;
import com.cgling.tms.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author houguangqiang
 * @date 2017-11-27
 * @since 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    @ResponseBody

    public UserInfoModel info(){
        UserInfoModel userInfoModel = new UserInfoModel();
        userInfoModel.setUserId(1L);
        return userInfoModel;
    }
}
