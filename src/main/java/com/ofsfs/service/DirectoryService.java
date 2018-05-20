package com.ofsfs.service;

import com.ofsfs.domains.Directory;

import java.util.List;

public interface DirectoryService {

    void save(Directory directory);

//    void update(Directory directory);

    void delete(Long id);

    List<Directory> loadMainDirectories();

    List<Directory> loadGroupDirectories(Long id);
}
