package com.cgling.tms.config.mvc;

import com.cgling.commons.web.advice.NullReturnValueResponseBodyAdvice;
import com.cgling.commons.web.converter.ResponseBodyWrapConverter;
import com.cgling.commons.web.exception.GlobalExceptionHandler;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * @author houguangqiang
 * @date 2017-11-27
 * @since 1.0
 */
@Configuration
@Import({GlobalExceptionHandler.class, NullReturnValueResponseBodyAdvice.class})
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    private ObjectMapper objectMapper;

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new ResponseBodyWrapConverter(objectMapper));
    }
}
