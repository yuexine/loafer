package loafer.security;

import loafer.constant.SecurityConstant;
import loafer.service.TokenAuthenticationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wuyuexin on 2017/5/24.
 */
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationSuccessHandlerImpl.class);

    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        log.info("AuthenticationSuccessHandlerImpl onAuthenticationSuccess start.");

        //create token for authentication success
        final String authToken = tokenAuthenticationService.createAuthToken(authentication);
        response.setHeader(SecurityConstant.HEADER_SECURITY_TOKEN, authToken);

        log.info("AuthenticationSuccessHandlerImpl onAuthenticationSuccess end.");
    }
}
