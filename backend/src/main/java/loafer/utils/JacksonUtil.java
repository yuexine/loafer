package loafer.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by wuyuexin on 2017/5/24.
 */
public class JacksonUtil {

    private static final Logger log = LoggerFactory.getLogger(JacksonUtil.class);

    private static ObjectMapper objectMapper;
    private static volatile JacksonUtil jacksonUtil;

    public JacksonUtil() {
        objectMapper = new ObjectMapper();
    }

    public static JacksonUtil genInstance() {
        if (jacksonUtil == null) {
            synchronized (JacksonUtil.class) {
                if (jacksonUtil == null) {
                    jacksonUtil = new JacksonUtil();
                }
            }
        }
        return jacksonUtil;
    }

    public <T> T getJacksonBean(String jsonStr, Class<T> cls) {
        T t = null;

        if (objectMapper != null) {
            try {
                t = objectMapper.readValue(jsonStr, cls);
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        }
        return t;
    }

    public static String toJacksonString(Object obj) {
        String res = "";
        try {

            if (objectMapper != null) {
                res = objectMapper.writeValueAsString(obj);
            }
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
        }
        log.debug("Jackson to string------->" + res);
        return res;
    }
}
