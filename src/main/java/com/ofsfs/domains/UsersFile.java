package com.ofsfs.domains;

import javax.persistence.*;

@Entity(name = "file")
public class UsersFile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "file_id")
    private Long id;

    private String path;

    private String name;

    private String type;

    private String fileSize;

    @ManyToOne(cascade = CascadeType.ALL)
    private Directory directory;

    public UsersFile() {
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public Directory getDirectory() {
        return directory;
    }

    public void setDirectory(Directory directory) {
        this.directory = directory;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
