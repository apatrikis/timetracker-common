/*
 * PRODYNA PAC 2015 - Time Tracker
 * Anastasios Patrikis
 */
package com.prodyna.pac.timetracker;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Security related methods.
 *
 * @author apatrikis
 */
public final class Security {

    /**
     * This method uses the same algorythm as the GlassFish application server
     * to hash a password.
     *
     * @param passwordToHash The password to hash.
     * @return The hashed password.
     * @throws java.security.NoSuchAlgorithmException if the provided password
     * cannot be hashed.
     */
    public static String passwordHashSHA256(String passwordToHash) throws NoSuchAlgorithmException {
        // get hash
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(passwordToHash.getBytes());
        byte byteData[] = md.digest();

        // hash to string
        StringBuilder hexString = new StringBuilder();
        for (int i = 0; i < byteData.length; i++) {
            int positiveByteValue = (0xff & byteData[i]);
            String hex = Integer.toHexString(positiveByteValue);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
