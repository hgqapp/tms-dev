package com.cgling.tms.menu.controller;

import com.cgling.commons.beans.response.ResultModel;
import com.cgling.tms.ApplicationTests;
import com.cgling.tms.menu.bean.condition.MenuCondition;
import com.cgling.tms.menu.service.MenuService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * @author houguangqiang
 * @date 2017-12-18
 * @since 1.0
 */
public class MenuControllerTest extends ApplicationTests {

    @Test
    public void getMenuInfo() {
        ResultModel resultModel = template.getForObject(url("/menu/getMenuInfo", 1, "menuId"), ResultModel.class);
        handleResult(resultModel);
    }

    @Autowired
    MenuService menuService;

    @Test
    public void getMenuList() {
        MenuCondition condition = new MenuCondition();
        condition.setType((byte) 0);
        menuService.getMenuList(condition);
    }

    @Test
    public void getMenuPage() {
    }

    @Test
    public void create() {
        Map<String,Object> param = new HashMap<>();
        param.put("name", "系统管理");
        param.put("type", 1);
        param.put("uri", "");
        param.put("code", "foundation");
        param.put("icon", "icon");
        ResultModel resultModel = template.getForObject("/menu/create?name={name}&type={type}&uri={uri}&icon={icon}", ResultModel.class, param);
        handleResult(resultModel);
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void batchDelete() {
    }
}