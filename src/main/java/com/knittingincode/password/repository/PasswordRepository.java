package com.knittingincode.password.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by alisaarnold on 2/1/18.
 */

@Repository
public interface PasswordRepository extends CrudRepository <Password, UserPasswordId>{
    Password findBySiteNameOrderByUsernameDesc(String siteName);
}



