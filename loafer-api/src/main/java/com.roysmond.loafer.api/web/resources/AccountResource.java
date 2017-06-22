package com.roysmond.loafer.api.web.resources;

import com.roysmond.loafer.api.domain.User;
import com.roysmond.loafer.api.repository.UserRepository;
import com.roysmond.loafer.api.service.MailService;
import com.roysmond.loafer.api.service.UserService;
import com.roysmond.loafer.api.web.models.ResultModel;
import com.roysmond.loafer.api.web.models.VMUser;
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
@RequestMapping("/api")
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

    @GetMapping(path = "account/info", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResultModel account() {
        Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (obj instanceof User){

        }
        return null;
    }
}
