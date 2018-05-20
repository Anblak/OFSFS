package com.ofsfs.service.impl;

import com.ofsfs.domains.Directory;
import com.ofsfs.repository.DirectoryRepository;
import com.ofsfs.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DirectoryServiceImpl implements DirectoryService {
    @Autowired
    private DirectoryRepository directoryRepository;

    @Override
    public void save(Directory directory) {
        directoryRepository.save(directory);
    }

//    @Override
//    public void update(Directory directory) {
//        directoryRepository.save(directory);
//    }

    @Override
    public void delete(Long id) {
        directoryRepository.delete(id);
    }
}
