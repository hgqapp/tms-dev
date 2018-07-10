package com.cgling.tms.menu.documentation;

import com.cgling.commons.beans.response.ResultStatus;
import com.cgling.tms.DocumentationTests;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import static com.cgling.commons.restdocs.object.SimpleDocumentation.objectFields;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.relaxedResponseFields;
import static org.springframework.restdocs.request.RequestDocumentation.parameterWithName;
import static org.springframework.restdocs.request.RequestDocumentation.requestParameters;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author houguangqiang
 * @date 2017-12-22
 * @since 1.0
 */
public class MenuDocumentation extends DocumentationTests {

    @Test
    public void menu() throws Exception {
        this.mvc.perform(get("/"))
                .andDo(this.document.document(
                        objectFields(
                                fieldWithPath("menuId").type("Long").description("【只读】菜单ID，自增主键"),
                                fieldWithPath("name").type("String").description("菜单名称；唯一，必填"),
                                fieldWithPath("code").type("String").description("菜单编码；唯一，必填"),
                                fieldWithPath("parentId").type("Long").description("上级菜单ID，0表示顶级菜单，默认为0"),
                                fieldWithPath("type").type("Integer").description("菜单类型，1：目录；2：菜单；3：按钮；必填"),
                                fieldWithPath("uri").type("String").description("菜单路径；可选"),
                                fieldWithPath("icon").type("String").description("菜单图标；可选"),
                                fieldWithPath("status").type("Integer").description("状态，0：禁用；1：启用（默认）"),
                                fieldWithPath("createTime").type("Long").description("【只读】创建时间，单位毫秒"),
                                fieldWithPath("updateTime").type("Long").description("【只读】更新时间，单位毫秒")
                        )));
    }

    @Test
    public void menuGet() throws Exception {
        MvcResult mvcResult = this.mvc.perform(get("/menu/get")
                .param("menuId", getMenuId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(ResultStatus.OK.getCode()))
                .andDo(this.document.document(
                        requestParameters(
                                parameterWithName("menuId").description("菜单ID，必填")
                        ),
                        relaxedResponseFields(
                                fieldWithPath("data").type("<<resources-menu-object,Menu>>").description("菜单对象Menu")
                        )))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void menuList() throws Exception {
        MvcResult mvcResult = this.mvc.perform(get("/menu/getList")
                //.param("name","系统管理")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(ResultStatus.OK.getCode()))
                .andDo(this.document.document(
                        requestParameters(
                                parameterWithName("name").description("菜单名称，可选，支持模糊查询").optional(),
                                parameterWithName("parentId").description("所属上级菜单ID，可选，默认查询所有").optional(),
                                parameterWithName("type").description("菜单类型，可选，1：目录；2：菜单；3：按钮").optional(),
                                parameterWithName("uri").description("菜单路径，可选，支持模糊查询").optional(),
                                parameterWithName("status").description("菜单状态，可选，0：禁用；1：启用").optional(),
                                parameterWithName("code").description("菜单编码，可选，支持模糊查询").optional()
                        ),
                        relaxedResponseFields(
                                fieldWithPath("data").type("List<<<resources-menu-object,Menu>>>").description("菜单对象Menu列表")
                        )))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void menuPage() throws Exception {
        MvcResult mvcResult = this.mvc.perform(get("/menu/getPage")
                //.param("name","系统管理")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(ResultStatus.OK.getCode()))
                .andDo(this.document.document(
                        requestParameters(
                                parameterWithName("name").description("菜单名称，可选，支持模糊查询").optional(),
                                parameterWithName("uri").description("菜单路径，可选，支持模糊查询").optional(),
                                parameterWithName("status").description("菜单状态，可选，0：禁用；1：启用").optional(),
                                parameterWithName("code").description("菜单编码，可选，支持模糊查询").optional()
                        ),
                        relaxedResponseFields(
                                fieldWithPath("data.records").type("List<<<resources-menu-object,Menu>>>").description("菜单对象Menu列表")
                        )))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void menuCreate() throws Exception {
        MvcResult mvcResult = this.mvc.perform(post("/menu/create")
                .param("name","管理首页")
                .param("code","system:manage:index")
                .param("parentId",getParentId())
                .param("type","2")
                .param("uri","#/system/manage/index")
                .param("icon","")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(ResultStatus.OK.getCode()))
                .andExpect(jsonPath("data").isNumber())
                .andDo(this.document.document(
                        requestParameters(
                                parameterWithName("name").description("菜单名称；唯一，必填"),
                                parameterWithName("code").description("菜单编码；唯一，必填"),
                                parameterWithName("parentId").description("上级菜单ID，0表示顶级菜单，默认为0").optional(),
                                parameterWithName("type").description("菜单类型，1：目录；2：菜单；3：按钮；必填"),
                                parameterWithName("uri").description("菜单路径；可选").optional(),
                                parameterWithName("icon").description("菜单图标；可选").optional(),
                                parameterWithName("status").description("状态，0：禁用；1：启用（默认）").optional()
                        ),
                        relaxedResponseFields(
                                fieldWithPath("data").type("Long").description("返回创建的菜单ID")
                        )))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void menuUpdate() throws Exception {
        MvcResult mvcResult = this.mvc.perform(post("/menu/update")
                .param("menuId", getMenuId())
                .param("name","菜单")
                .param("code","menu-code")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(ResultStatus.OK.getCode()))
                .andDo(this.document.document(
                        requestParameters(
                                parameterWithName("menuId").description("菜单ID；必填"),
                                parameterWithName("name").description("菜单名称；唯一").optional(),
                                parameterWithName("code").description("菜单编码；唯一").optional(),
                                parameterWithName("parentId").description("上级菜单ID，0表示顶级菜单").optional(),
                                parameterWithName("type").description("菜单类型，1：目录；2：菜单；3：按钮").optional(),
                                parameterWithName("uri").description("菜单路径").optional(),
                                parameterWithName("icon").description("菜单图标").optional(),
                                parameterWithName("status").description("状态，0：禁用；1：启用").optional()
                        )))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void menuDelete() throws Exception {
        MvcResult mvcResult = this.mvc.perform(post("/menu/delete")
                .param("menuId", getMenuId())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(ResultStatus.OK.getCode()))
                .andDo(this.document.document(
                        requestParameters(
                                parameterWithName("menuId").description("菜单ID，必填")
                        )))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void menuBatchDelete() {
    }

    private String getMenuId() throws Exception {
        String content = this.mvc.perform(post("/menu/create")
                .param("name","管理首页")
                .param("code","system:manage:index")
                .param("parentId",getParentId())
                .param("type","2")
                .param("uri","#/system/manage/index")
                .param("icon","")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(ResultStatus.OK.getCode()))
                .andExpect(jsonPath("data").isNumber())
                .andReturn().getResponse().getContentAsString();
        Number menuId = JsonPath.read(content, "$.data");
        return menuId.toString();
    }

    private String getParentId() throws Exception {
        String content = this.mvc.perform(post("/menu/create")
                .param("name","管理首页菜单")
                .param("code","system:manage:data")
                .param("type","1")
                .param("uri","#/system/manage/data")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(ResultStatus.OK.getCode()))
                .andExpect(jsonPath("data").isNumber())
                .andReturn().getResponse().getContentAsString();
        Number menuId = JsonPath.read(content, "$.data");
        return menuId.toString();
    }
}
