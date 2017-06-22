package loafer.config;

import loafer.domain.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * http://docs.spring.io/spring-data/jpa/docs/1.10.2.RELEASE/reference/html/#auditing
 * <p>
 * Created by wuyuexin on 2017/6/3.
 */
@Configuration
@EnableJpaAuditing
public class JPAAuditorConfiguration {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return new AuditorAware<String>() {
            @Override
            public String getCurrentAuditor() {
                Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

                if (authentication == null || !authentication.isAuthenticated()) {
                    return null;
                }

                return authentication.getPrincipal() instanceof User ?
                        ((User) authentication.getPrincipal()).getLogin() : authentication.getPrincipal().toString();
            }
        };
    }
}
