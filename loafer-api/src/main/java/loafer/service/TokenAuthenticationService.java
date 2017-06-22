package loafer.service;

import org.springframework.security.core.Authentication;

/**
 * Created by wuyuexin on 2017/5/23.
 */
public interface TokenAuthenticationService {

    String createAuthToken(Authentication authentication);

    Authentication getAuthentication(String authToken);

    void removeAuthToken(String authToken);
}
