package com.ofsfs.domains;

import com.ofsfs.domains.enums.DirectoryType;

import javax.persistence.*;
import java.util.List;

@Entity
public class Directory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "directory_id")
    private Long id;

    private String name;

    private Double fileMaxSize;

    private Double directoryMaxSize;

    @Enumerated(EnumType.STRING)
    private DirectoryType directoryType;

    @OneToMany(mappedBy = "directory")
    private List<UsersFile> usersFiles;

    @OneToMany(mappedBy = "directory")
    private List<User> user;

    public Directory() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getFileMaxSize() {
        return fileMaxSize;
    }

    public void setFileMaxSize(Double fileMaxSize) {
        this.fileMaxSize = fileMaxSize;
    }

    public Double getDirectoryMaxSize() {
        return directoryMaxSize;
    }

    public void setDirectoryMaxSize(Double directoryMaxSize) {
        this.directoryMaxSize = directoryMaxSize;
    }

    public List<UsersFile> getUsersFiles() {
        return usersFiles;
    }

    public void setUsersFiles(List<UsersFile> usersFiles) {
        this.usersFiles = usersFiles;
    }

    public DirectoryType getDirectoryType() {
        return directoryType;
    }

    public void setDirectoryType(DirectoryType directoryType) {
        this.directoryType = directoryType;
    }

    public List<User> getUser() {
        return user;
    }

    public void setUser(List<User> user) {
        this.user = user;
    }
}
