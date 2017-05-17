package loafer.service;

import loafer.domain.Authority;
import loafer.domain.User;
import loafer.repository.AuthorityRepository;
import loafer.repository.UserRepository;
import loafer.security.AuthoritiesConstants;
import loafer.utils.RandomUtil;
import loafer.web.models.UserVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wuyuexin on 2017/5/17.
 */
@Service
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final PasswordEncoder passwordEncoder;

    private final AuthorityRepository authorityRepository;

    private final UserRepository userRepository;

    public UserServiceImpl(PasswordEncoder passwordEncoder, AuthorityRepository authorityRepository, UserRepository userRepository) {
        this.passwordEncoder = passwordEncoder;
        this.authorityRepository = authorityRepository;
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(UserVM userVM) {
        User newUser = new User();
        Authority authority = authorityRepository.findOne(AuthoritiesConstants.USER);
        Set<Authority> authorities = new HashSet<>();
        authorities.add(authority);

        String encryptedPassword = passwordEncoder.encode(userVM.getPassword());
        newUser.setActivated(false);
        newUser.setActivationKey(RandomUtil.generateActivationKey());
        newUser.setUsername(userVM.getUsername());
        newUser.setPassword(encryptedPassword);
        newUser.setAuthorities(authorities);

        userRepository.save(newUser);
        log.debug("Created Information for User: {}", newUser);
        return newUser;
    }
}
