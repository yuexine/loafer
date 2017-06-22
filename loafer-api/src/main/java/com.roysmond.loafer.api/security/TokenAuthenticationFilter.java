package com.roysmond.loafer.api.security;

import com.roysmond.loafer.api.constant.SecurityConstant;
import com.roysmond.loafer.api.service.TokenAuthenticationService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;
import org.springframework.web.filter.OncePerRequestFilter;

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
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(TokenAuthenticationFilter.class);

    private final TokenAuthenticationService tokenAuthenticationService;

    public TokenAuthenticationFilter(TokenAuthenticationService tokenAuthenticationService) {
        this.tokenAuthenticationService = tokenAuthenticationService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        log.info("doFilterInternal() start.");

        String authToken = request.getHeader(SecurityConstant.HEADER_SECURITY_TOKEN);

        if (StringUtils.isNotEmpty(authToken)) {
            Authentication authentication = tokenAuthenticationService.getAuthentication(authToken);
            if (authentication == null){
                response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Access Denied");
            }else {
                response.setHeader(SecurityConstant.HEADER_SECURITY_TOKEN, authToken);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        log.info("doFilterInternal() end.");
        filterChain.doFilter(request,response);
    }
}
