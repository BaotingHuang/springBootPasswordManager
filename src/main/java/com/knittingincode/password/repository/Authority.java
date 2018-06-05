package com.knittingincode.password.repository;

import javax.persistence.*;

/**
 * Created by alisaarnold on 4/30/18.
 */

@Entity
@Table(name = "authorities")
public class Authority {

    @Id
    @Column
    private String username;

    @Column
    private String authority;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
