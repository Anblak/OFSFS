package com.ofsfs.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ofsfs.domains.enums.UserRole;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

@Entity
public class Account implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "account_id")
    private Long id;

    @NotNull
    private String username;

    @JsonIgnore
    @NotNull
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

    private String uuid;

    private boolean enabled;

    public Account() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return new ArrayList<>(Collections.singletonList(new SimpleGrantedAuthority(userRole.name())));
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public Account setEnabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Account account = (Account) o;

        if (enabled != account.enabled) return false;
        if (!id.equals(account.id)) return false;
        if (!username.equals(account.username)) return false;
        return password.equals(account.password);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + username.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + (enabled ? 1 : 0);
        return result;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}
