package loafer.security;

import loafer.constant.SecurityConstant;
import loafer.service.TokenAuthenticationService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by wuyuexin on 2017/5/23.
 */
@Component
public class TokenAuthenticationFilter extends GenericFilterBean {

    private static final Logger log = LoggerFactory.getLogger(TokenAuthenticationFilter.class);

    private final TokenAuthenticationService tokenAuthenticationService;

    public TokenAuthenticationFilter(TokenAuthenticationService tokenAuthenticationService) {
        this.tokenAuthenticationService = tokenAuthenticationService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("StatelessAuthenticationFilter filter start. ");
        log.info(((HttpServletRequest) servletRequest).getMethod());

        String authToken = ((HttpServletRequest) servletRequest).getHeader(SecurityConstant.HEADER_SECURITY_TOKEN);

        if (StringUtils.isNotEmpty(authToken)) {
            Authentication authentication = tokenAuthenticationService.getAuthentication(authToken);
            if (authentication == null){
                ((HttpServletResponse) servletResponse).sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied");
            }else {
                ((HttpServletResponse) servletResponse).setHeader(SecurityConstant.HEADER_SECURITY_TOKEN, authToken);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        log.info("StatelessAuthenticationFilter filter end. ");
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
