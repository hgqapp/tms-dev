package com.cgling.tms.role.documentation;

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
public class RoleDocumentation extends DocumentationTests {

    @Test
    public void role() throws Exception {
        this.mvc.perform(get("/"))
                .andDo(this.document.document(
                        objectFields(
                                fieldWithPath("roleId").type("Long").description("【只读】角色ID，自增主键"),
                                fieldWithPath("name").type("String").description("角色名称，必填"),
                                fieldWithPath("description").type("String").description("角色描述，可选").optional(),
                                fieldWithPath("createTime").type("Long").description("【只读】创建时间，单位毫秒"),
                                fieldWithPath("updateTime").type("Long").description("【只读】更新时间，单位毫秒")
                        )));
    }

    @Test
    public void roleGet() throws Exception {
        MvcResult mvcResult = this.mvc.perform(get("/role/get")
                .param("roleId", "1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(ResultStatus.OK.getCode()))
                .andDo(this.document.document(
                        requestParameters(
                                parameterWithName("roleId").description("角色ID，必填")
                        ),
                        relaxedResponseFields(
                                fieldWithPath("data").type("<<resources-role-object,Role>>").description("角色对象Role")
                        )))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void roleList() throws Exception {
        MvcResult mvcResult = this.mvc.perform(get("/role/getList")
                //.param("name","质检员")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(ResultStatus.OK.getCode()))
                .andDo(this.document.document(
                        requestParameters(
                                parameterWithName("name").description("角色名称，可选，支持模糊查询").optional()
                        ),
                        relaxedResponseFields(
                                fieldWithPath("data").type("List<<<resources-role-object,Role>>>").description("角色对象Role列表")
                        )))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }


    @Test
    public void rolePage() throws Exception {
        MvcResult mvcResult = this.mvc.perform(get("/role/getPage")
                //.param("name","质检员")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(ResultStatus.OK.getCode()))
                .andDo(this.document.document(
                        requestParameters(
                                parameterWithName("name").description("角色名称，可选，支持模糊查询").optional()
                        ),
                        relaxedResponseFields(
                                fieldWithPath("data.records").type("List<<<resources-role-object,Role>>>").description("角色对象Role列表")
                        )))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void roleCreate() throws Exception {
        MvcResult mvcResult = this.mvc.perform(post("/role/create")
                .param("name","测试人员")
                .param("description","我是测试人员")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(ResultStatus.OK.getCode()))
                .andExpect(jsonPath("data").isNumber())
                .andDo(this.document.document(
                        requestParameters(
                                parameterWithName("name").description("角色名称，必填"),
                                parameterWithName("description").description("角色描述，可选").optional()
                        ),
                        relaxedResponseFields(
                                fieldWithPath("data").type("Long").description("返回创建的角色ID")
                        )))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void roleUpdate() throws Exception {
        String content = this.mvc.perform(post("/role/create")
                .param("name", "测试人员")
                .param("description", "我是测试人员")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("code").value(ResultStatus.OK.getCode()))
                .andExpect(jsonPath("data").isNumber())
                .andReturn().getResponse().getContentAsString();
        Number roleId = JsonPath.read(content, "$.data");
        MvcResult mvcResult = this.mvc.perform(post("/role/update")
                .param("roleId",roleId.toString())
                .param("name","测试员")
                .param("description","我是测试")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(ResultStatus.OK.getCode()))
                .andDo(this.document.document(
                        requestParameters(
                                parameterWithName("roleId").description("角色ID，必填"),
                                parameterWithName("name").description("角色名称，必填"),
                                parameterWithName("description").description("角色描述，可选").optional()
                        )))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void roleDelete() throws Exception {
        String content = this.mvc.perform(post("/role/create")
                .param("name", "测试人员")
                .param("description", "我是测试人员")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("code").value(ResultStatus.OK.getCode()))
                .andExpect(jsonPath("data").isNumber())
                .andReturn().getResponse().getContentAsString();
        Number roleId = JsonPath.read(content, "$.data");
        MvcResult mvcResult = this.mvc.perform(post("/role/delete")
                .param("roleId",roleId.toString())
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("code").value(ResultStatus.OK.getCode()))
                .andDo(this.document.document(
                        requestParameters(
                                parameterWithName("roleId").description("角色ID，必填")
                        )))
                .andReturn();
        System.out.println(mvcResult.getResponse().getContentAsString());
    }

    @Test
    public void roleBatchDelete() {
    }
}
