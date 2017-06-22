package loafer.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wuyuexin on 2017/5/24.
 */
public class AuthenticationFailureHandlerImpl implements AuthenticationFailureHandler {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationFailureHandlerImpl.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        log.info("AuthenticationFailureHandlerImpl onAuthenticationFailure start.");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        log.info("AuthenticationFailureHandlerImpl onAuthenticationFailure end.");
    }
}
