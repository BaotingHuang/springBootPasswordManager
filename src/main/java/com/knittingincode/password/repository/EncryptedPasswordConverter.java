package com.knittingincode.password.repository;

import com.knittingincode.password.CipherInitializer;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.AttributeConverter;
import java.util.Base64;
import java.util.Objects;
import javax.crypto.Cipher;

/**
 * Created by alisaarnold on 3/1/18.
 */
public class EncryptedPasswordConverter implements AttributeConverter<String, String> {

    private static Cipher cipher;

    private final int LOG_ROUNDS = 12;

    @Override
    public String convertToDatabaseColumn(String s) {
        Objects.requireNonNull(s);
        return BCrypt.hashpw(s, BCrypt.gensalt(LOG_ROUNDS));
    }

    @Override
    public String convertToEntityAttribute(String s) {
        Objects.requireNonNull(s);
        return s;
    }

    public static String encrypt(String strToEncrypt) throws Exception{
        //String key = strToEncrypt.substring(0, 16);
        String key = "ssshhhhhhhhhhh!!";
        Cipher cipher = CipherInitializer.prepareAndInitCipher(Cipher.ENCRYPT_MODE, key);
        String encryptedString = strToEncrypt;
        //byte[] bytesToEncrypt = strToEncrypt.getBytes();
        byte[] encryptedBytes = cipher.doFinal(encryptedString.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);


    }

    public static String decrypt(String strToDecrypt) throws Exception{
        //String key = strToDecrypt.substring(0, 16);
        String key = "ssshhhhhhhhhhh!!";
        Cipher cipher = CipherInitializer.prepareAndInitCipher(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
    	/*byte[] encryptedBytes = Base64.getDecoder().decode(strToDecrypt);
        byte[] decryptedBytes = callCipherDoFinal(cipher, encryptedBytes);
        return String(decryptedBytes);*/

    }
}
