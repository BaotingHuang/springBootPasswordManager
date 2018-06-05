package com.knittingincode.password;

/**
 * Created by alisaarnold on 3/8/18.
 */
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

public class CipherInitializer {

    private static final String CIPHER_INSTANCE_NAME = "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384";
    private static final String SECRET_KEY_ALGORITHM = "AES"; // This is the encryption standard. AES stands for Advanced Encryption Standard.
                                                              // Bas

    public static Cipher prepareAndInitCipher(int encryptionMode, String key) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException {
        Cipher cipher = Cipher.getInstance(CIPHER_INSTANCE_NAME);
        Key secretKey = new SecretKeySpec(key.getBytes(), SECRET_KEY_ALGORITHM);
        AlgorithmParameterSpec algorithmParameters = getAlgorithmParameterSpec(cipher);

        callCipherInit(cipher, encryptionMode, secretKey, algorithmParameters);
        return cipher;
    }

    static void callCipherInit(Cipher cipher, int encryptionMode, Key secretKey, AlgorithmParameterSpec algorithmParameters) throws InvalidKeyException, InvalidAlgorithmParameterException {
        cipher.init(encryptionMode, secretKey, algorithmParameters);
    }

    static int getCipherBlockSize(Cipher cipher) {
        return cipher.getBlockSize();
    }

    private static AlgorithmParameterSpec getAlgorithmParameterSpec(Cipher cipher) {
        byte[] iv = new byte[getCipherBlockSize(cipher)];
        return new IvParameterSpec(iv);
    }

}
