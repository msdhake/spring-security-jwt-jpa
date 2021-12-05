package com.love2code.springsecurityjwt.utils;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;
import org.apache.commons.codec.binary.Base64;

public class EncryptDecryptUtils {

    public static String encrypt(String unencryptedString) {
    	
    	String encryptedString = null;
        try {
        	
            String myEncryptionKey = "LoveTwoCodeDotComBeFamous";
            String myEncryptionScheme = Constants.DESEDE_ENCRYPTION_SCHEME;
            SecretKeyFactory skf = SecretKeyFactory.getInstance(myEncryptionScheme);
            SecretKey key = skf.generateSecret(new DESedeKeySpec(myEncryptionKey.getBytes(Constants.UNICODE_FORMAT)));
            Cipher  cipher = Cipher.getInstance(myEncryptionScheme);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] plainText = unencryptedString.getBytes(Constants.UNICODE_FORMAT);
            byte[] encryptedText = cipher.doFinal(plainText);
            encryptedString = new String(Base64.encodeBase64(encryptedText));
            return encryptedString;
        } catch (Exception ex) {
            System.out.println("Failed to Encrypt the string: "+ex);
        }
        return encryptedString;
    }


    public static String decrypt(String encryptedString) {
        String decryptedText=null;
        try {
        	String myEncryptionKey = "LoveTwoCodeDotComBeFamous";
            String myEncryptionScheme = Constants.DESEDE_ENCRYPTION_SCHEME;
            SecretKeyFactory skf = SecretKeyFactory.getInstance(myEncryptionScheme);
            SecretKey key = skf.generateSecret(new DESedeKeySpec(myEncryptionKey.getBytes(Constants.UNICODE_FORMAT)));
            Cipher  cipher = Cipher.getInstance(myEncryptionScheme);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] encryptedText = Base64.decodeBase64(encryptedString);
            byte[] plainText = cipher.doFinal(encryptedText);
            return new String(plainText);
        } catch (Exception ex) {
        	System.out.println("Failed to Decrypt the string: "+ex);
        }
        return decryptedText;
    }
}