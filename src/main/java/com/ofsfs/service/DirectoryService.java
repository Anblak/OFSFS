package com.ofsfs.service;

import com.ofsfs.domains.Directory;

public interface DirectoryService {

    void save(Directory directory);

//    void update(Directory directory);

    void delete(Long id);
}
