package com.ofsfs.domains;

import javax.persistence.*;
import java.util.List;

@Entity(name = "user_group")
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_group_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "group")
    private List<User> users;

    @OneToMany(mappedBy = "group")
    private List<Directory> directories;

    public Group() {
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

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public List<Directory> getDirectories() {
        return directories;
    }

    public void setDirectories(List<Directory> directories) {
        this.directories = directories;
    }
}
