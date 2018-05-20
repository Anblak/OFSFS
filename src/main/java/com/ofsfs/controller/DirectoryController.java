package com.ofsfs.controller;

import com.ofsfs.domains.Directory;
import com.ofsfs.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DirectoryController {

    @Autowired
    private DirectoryService directoryService;

    @PostMapping("/directory")
    @ResponseStatus(HttpStatus.CREATED)
    public void addDirectory(@RequestBody Directory directory){
        directoryService.save(directory);
    }

    @DeleteMapping("/directory")
    @ResponseStatus(HttpStatus.OK)
    public void deleteDirectory(@RequestParam Long id){
        directoryService.delete(id);
    }

    @GetMapping("/directory/main")
    @ResponseStatus(HttpStatus.OK)
    public List<Directory> loadMainDirectories(){
        return null; //TODO ))00))0)0))0
    }
}
