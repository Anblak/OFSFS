package com.ofsfs.service.impl;

import com.ofsfs.domains.User;
import com.ofsfs.repository.AccountRepository;
import com.ofsfs.repository.UserRepository;
import com.ofsfs.service.MailSenderService;
import com.ofsfs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailSenderService mailSenderService;

    @Autowired
    private AccountRepository accountRepository;


    @Autowired
    private BCryptPasswordEncoder encoder;


    @Override
    public void addUser(User user) {
        String uuid = UUID.randomUUID().toString();
        user.getAccount().setPassword(encoder.encode(user.getAccount().getPassword()));
        user.getAccount().setUuid(uuid);
        userRepository.save(user);
        mailSenderService.sendMail("theme","link"+ uuid, user.getAccount().getUsername());
    }

    @Override
    public void confirm(String uuid) {
        accountRepository.save(accountRepository.findByUuid(uuid).setEnabled(true));
    }

    @Override
    public void update(User user) {
        //TODO if need it
    }

    @Override
    public void delete(Long id) {
        userRepository.delete(id);
    }
}
