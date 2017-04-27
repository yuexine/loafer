package loafer.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.AbstractJsonpResponseBodyAdvice;

/**
 * Created by w on 2017/4/27.
 */
@ControllerAdvice
public class JsonPAdvice extends AbstractJsonpResponseBodyAdvice {

    public JsonPAdvice() {
        super("callback");
    }
}
