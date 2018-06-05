package com.knittingincode.password;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by alisaarnold on 3/1/18.
 */
@Component
public class PrivateKeyRepository {
    public static String KEY;
    @Value("${encryption.key}")
    public void setDatabaseKey(String key){
        KEY = key;
    }
}
