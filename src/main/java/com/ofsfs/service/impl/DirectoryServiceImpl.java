package com.ofsfs.service.impl;

import com.ofsfs.domains.Directory;
import com.ofsfs.domains.enums.DirectoryType;
import com.ofsfs.repository.DirectoryRepository;
import com.ofsfs.service.DirectoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

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

    @Override
    public List<Directory> loadMainDirectories() {
        return directoryRepository.findAll()
                .stream()
                .filter(directory -> directory.getDirectoryType().equals(DirectoryType.MAIN))
                .collect(toList());
    }

    @Override
    public List<Directory> loadGroupDirectories(Long id) {
        return directoryRepository.findAll()
                .stream()
                .filter(directory -> directory.getGroup().getId().equals(id))
                .collect(toList());
    }
}
