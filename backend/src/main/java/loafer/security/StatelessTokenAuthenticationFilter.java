package loafer.security;

import loafer.service.TokenAuthenticationService;
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
public class StatelessTokenAuthenticationFilter extends GenericFilterBean {

    private static final Logger log = LoggerFactory.getLogger(StatelessTokenAuthenticationFilter.class);

    private final TokenAuthenticationService tokenAuthenticationService;

    public StatelessTokenAuthenticationFilter(TokenAuthenticationService tokenAuthenticationService) {
        this.tokenAuthenticationService = tokenAuthenticationService;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("StatelessTokenAuthenticationFilter filter start. ");
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info(((HttpServletRequest) servletRequest).getMethod());
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("StatelessTokenAuthenticationFilter filter end. ");
    }
}
