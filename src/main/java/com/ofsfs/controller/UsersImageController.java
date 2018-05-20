package com.ofsfs.controller;

import com.ofsfs.domains.UsersFile;
import com.ofsfs.service.UsersFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UsersImageController {
    @Autowired
    private UsersFileService usersFileService;

    @PostMapping("/usersFile")
    @ResponseStatus(HttpStatus.CREATED)
    public void addUsersFile(@RequestBody MultipartFile multipartFile) {
        //TODO add
    }

    @DeleteMapping("/usersFile")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUsersFile(@PathVariable Long id){
        //TODO delete
    }
}
