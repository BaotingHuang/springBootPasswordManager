package com.knittingincode.password.repository;

import java.io.Serializable;

/**
 * Created by alisaarnold on 3/22/18.
 */


public class UserPasswordId implements Serializable {

    private String siteName;

    private String username;

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserPasswordId that = (UserPasswordId) o;

        if (!siteName.equals(that.siteName)) return false;
        return username.equals(that.username);
    }

    @Override
    public int hashCode() {
        int result = siteName.hashCode();
        result = 31 * result + username.hashCode();
        return result;
    }
}
