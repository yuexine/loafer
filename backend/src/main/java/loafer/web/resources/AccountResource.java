package loafer.web.resources;

import loafer.domain.User;
import loafer.repository.UserRepository;
import loafer.service.MailService;
import loafer.service.UserService;
import loafer.web.models.UserVM;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by wuyuexin on 2017/5/16.
 */
@RestController
public class AccountResource {

    private final Logger logger = LoggerFactory.getLogger(AccountResource.class);

    private final UserService userService;

    private final MailService mailService;

    private final UserRepository userRepository;

    public AccountResource(UserService userService, MailService mailService, UserRepository userRepository) {
        this.userService = userService;
        this.mailService = mailService;
        this.userRepository = userRepository;
    }

    @PostMapping(path = "register", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.TEXT_PLAIN_VALUE})
    public ResponseEntity register(@Valid @RequestBody UserVM userVM) {
        HttpHeaders textPlainHeaders = new HttpHeaders();
        textPlainHeaders.setContentType(MediaType.TEXT_PLAIN);

        return userRepository.findOneByLogin(userVM.getUsername().toLowerCase())
                .map(user -> new ResponseEntity("username already in use", textPlainHeaders, HttpStatus.BAD_REQUEST))
                .orElseGet(() -> {
                    User user = userService.createUser(userVM);

                    mailService.sendActivationEmail(user);
                    return new ResponseEntity(HttpStatus.CREATED);
                });
    }

    @GetMapping(path = "account", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity account(){
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ResponseEntity(obj, HttpStatus.OK);
    }
}
