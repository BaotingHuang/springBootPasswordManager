package com.knittingincode.password.repository;


import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by alisaarnold on 1/18/18.
 */
@Entity(name="users") //Pulling from users table.
public class User {
    @Id
    @Column
    private String username;
    @Column
    private String password;
    @OneToMany(mappedBy = "username")
    private List<Password> passwords;
    @OneToMany
    @JoinColumn(name = "username")
    private Set<Authority> authorities;

    public List<Password> getPasswords() {
        return passwords;
    }

    public void setPasswords(List<Password> passwords) {
        this.passwords = passwords;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

}
