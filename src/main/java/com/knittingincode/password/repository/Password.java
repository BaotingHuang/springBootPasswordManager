package com.knittingincode.password.repository;

import javax.persistence.*;

/**
 * Created by alisaarnold on 2/1/18.
 */

@Entity(name = "user_passwords")
@IdClass(value = UserPasswordId.class)
public class Password {

    @Id
    @Column
    private String username;

    @Column
    @Convert(converter = EncryptedPasswordConverter.class)
    private String password;

    @Id
    @Column
    private String siteName;

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

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

}
