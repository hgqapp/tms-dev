package com.cgling.tms.role.controller;

import com.cgling.commons.beans.response.ResultModel;
import com.cgling.tms.ApplicationTests;
import org.junit.Test;


public class RoleControllerTest extends ApplicationTests {

    @Test
    public void getRoleInfo() throws Exception {
        ResultModel resultModel = template.getForObject(url("/role/getRoleInfo", 1, "roleId"), ResultModel.class);
        handleResult(resultModel);
    }

    @Test
    public void getRoleList() throws Exception {
//        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/role/getRoleList?getRoleList1}", 1)).andReturn();
//        System.out.println(mvcResult.getResponse());
    }


    @Test
    public void getRolePage() {

    }

    @Test
    public void create() {
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