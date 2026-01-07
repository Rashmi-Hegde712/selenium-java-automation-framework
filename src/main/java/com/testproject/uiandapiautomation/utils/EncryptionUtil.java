package com.testproject.uiandapiautomation.utils;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionUtil {

	private static final String SECRET_KEY = System.getenv("AES_SECRET_KEY");

    public static String encrypt(String value) throws Exception {
    	
    	if (SECRET_KEY == null) {
    	    throw new RuntimeException("AES_SECRET_KEY not set");
    	}
    	
        SecretKeySpec key = new SecretKeySpec(
            SECRET_KEY.getBytes(), "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);

        return Base64.getEncoder()
                     .encodeToString(cipher.doFinal(value.getBytes()));
    }
    
    public static String decrypt(String encrypted) throws Exception {
        SecretKeySpec key = new SecretKeySpec(
            SECRET_KEY.getBytes(), "AES");

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);

        return new String(cipher.doFinal(
            Base64.getDecoder().decode(encrypted)));
    }
	
}
