package com.dinube.shagenerator;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class ShaGenerator {

    /**
     * Converts the plain text password to SHA Hash
     *
     * @param passwordToHash plain text password which is to be converted into hash
     * @param shaType        SHA Hash type possible values are (SHA-256, SHA-384, SHA-512)
     * @return String hash value of the password
     */
    public static String getSHA2SecurePassword(String passwordToHash, String shaType) throws NoSuchAlgorithmException {
        String generatedPassword = null;
        if (shaType.equals("SHA-256") || shaType.equals("SHA-384") || shaType.equals("SHA-512")) {

            MessageDigest md = MessageDigest.getInstance(shaType);
            byte[] bytes = md.digest(passwordToHash.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } else {
            throw new NoSuchAlgorithmException("SHA Algorithm not found. Supported SHA algorithm are SHA-256, SHA-384, SHA-512");
        }
        return generatedPassword;
    }

    /**
     * Verify that plain text password is equals to hash value or not
     *
     * @param plainPassword plain text password to verify
     * @param shaType       SHA Hash type possible values are (SHA-256, SHA-384, SHA-512)
     * @return true if plainPassword is match with the passwordToHash else false
     */
    public static boolean verifySHA(String plainPassword, String shaType, String passwordToHash) throws NoSuchAlgorithmException {
        return getSHA2SecurePassword(plainPassword, shaType).equals(passwordToHash);
    }
}
