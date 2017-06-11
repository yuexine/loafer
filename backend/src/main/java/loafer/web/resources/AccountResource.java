package loafer.web.resources;

import loafer.domain.User;
import loafer.repository.UserRepository;
import loafer.service.MailService;
import loafer.service.UserService;
import loafer.web.models.ResultModel;
import loafer.web.models.VMUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by wuyuexin on 2017/5/16.
 */
@RestController
@RequestMapping("/api/account")
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
    public ResponseEntity register(@Valid @RequestBody VMUser vmUser) {

        return userRepository.findOneByLogin(vmUser.getEmail().toLowerCase())
                .map(user -> new ResponseEntity(new ResultModel("username already in use"), HttpStatus.BAD_REQUEST))
                .orElseGet(() -> {
                    User user = userService.createUser(vmUser);

                    mailService.sendActivationEmail(user);
                    return new ResponseEntity(new ResultModel(), HttpStatus.CREATED);
                });
    }

    @GetMapping(path = "account", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity account() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return new ResponseEntity(obj, HttpStatus.OK);
    }
}
