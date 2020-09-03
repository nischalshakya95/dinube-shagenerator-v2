package com.dinube.shagenerator;

import java.security.NoSuchAlgorithmException;

public class ShaGeneratorMain {
    public static void main(String[] args) {
        try {
            String passwordHash = ShaGenerator.getSHA2SecurePassword("no-pass", "SHA-256");
            System.out.println(passwordHash);
            String plainPassword = "no-pass";
            System.out.println(ShaGenerator.verifySHA(plainPassword, "SHA-256", passwordHash));
        } catch (NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
    }
}
