package com.undo.task2;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA256Util {
    private MessageDigest messageDigest;

    public SHA256Util() {
        //create SHA256 instance
        try {
            messageDigest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     *   calculate SHA256 for the input byte array
     */
    public byte[] sha256(byte[] bytes) {
        messageDigest.update(bytes);
        return messageDigest.digest();
    }

    //convert byte array to hex string
    public static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString().toUpperCase();
    }

    /**
     * check if all the leading bytes of the array are zero
     *
     * @param bytes
     * @param length
     * @return
     */
    public static boolean isLeadBytesZero(byte[] bytes, int length) {
        int sum = 0;
        for (int i = 0; i < length; i++) {
            sum |= bytes[i];
        }
        return (sum == 0);
    }
}
