package com.cgling.tms;

import com.cgling.commons.beans.response.ResultModel;
import com.cgling.commons.beans.response.ResultStatus;
import com.cgling.commons.utils.JsonUtil;
import com.fasterxml.jackson.databind.JsonNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.LocalHostUriTemplateHandler;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.UriTemplateHandler;

import java.util.Iterator;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class ApplicationTests {

    @Autowired
    protected TestRestTemplate template;
    @Autowired
    protected MockMvc mockMvc;

    protected void handleResult(ResultModel result){
        if (result.getCode() == ResultStatus.OK.getCode()) {
            if (result.getData() != null) {
                System.err.println(JsonUtil.toJson(result.getData()));
                return;
            }
        }
        System.err.println(JsonUtil.toJson(result));

    }

    protected static String toFormParam(Object obj, String paramName){
        return toFormParam(JsonUtil.parseJson(JsonUtil.toJson(obj)), paramName);
    }

    protected static String toFormParam(Object obj){
        return toFormParam(obj, null);
    }

    private static String toFormParam(JsonNode jsonNode, String paramName){
        StringBuilder params = new StringBuilder();
        _toFormParam(jsonNode, paramName, params);
        if (params.length() > 0) {
            params.deleteCharAt(params.length() - 1);
        }
        return params.toString();
    }

    private static void _toFormParam(JsonNode jsonNode, String paramName, StringBuilder params){
        String name = "";
        if (paramName != null && paramName.trim().length() > 0) {
            name = paramName;
        }
        if (jsonNode.isNull()) {
        } else if (jsonNode.isObject()) {
            Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
            while (fields.hasNext()) {
                Map.Entry<String, JsonNode> next = fields.next();
                String key = next.getKey();
                JsonNode value = next.getValue();
                _toFormParam(value,name.length() > 0 ? name + "." + key : key, params);
            }
        } else if (jsonNode.isArray()) {
            for (int i = 0; i < jsonNode.size(); i++) {
                JsonNode node = jsonNode.get(i);

                _toFormParam(node, name.endsWith("[]") ? name : name + "[]", params);
            }
        } else {
            params.append(name).append("=").append(jsonNode.asText("")).append("&");
        }
    }

    protected String url(String url, Object param){
        return url + "?" + toFormParam(param);
    }

    protected String url(String url, Object param, String rootName){
        return url + "?" + toFormParam(param, rootName);
    }

    @Test
    public void  testRequest() throws Exception {
        HttpHeaders headers = template.getForEntity("/example", String.class).getHeaders();
    }

    @TestConfiguration
    static class Config {

        @Bean
        public TestRestTemplate testRestTemplate(RestTemplateBuilder restTemplateBuilder) {
            return new TestRestTemplate(restTemplateBuilder);
        }

        @Bean
        public UriTemplateHandler uriTemplateHandler(ApplicationContext applicationContext) {
            return new LocalHostUriTemplateHandler(applicationContext.getEnvironment());
        }

        @Bean
        public RestTemplateBuilder restTemplateBuilder(UriTemplateHandler uriTemplateHandler) {
            return new RestTemplateBuilder().uriTemplateHandler(uriTemplateHandler);
        }

    }
}
