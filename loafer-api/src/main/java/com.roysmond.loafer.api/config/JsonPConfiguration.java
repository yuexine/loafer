package com.roysmond.loafer.api.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * Created by w on 2017/4/27.
 */
@ControllerAdvice
public class JsonPConfiguration extends AbstractJsonpResponseBodyAdvice {

    private static final String JSON_P_CALLBACK = "callback";

    public JsonPConfiguration() {
        super(JSON_P_CALLBACK);
    }
}
