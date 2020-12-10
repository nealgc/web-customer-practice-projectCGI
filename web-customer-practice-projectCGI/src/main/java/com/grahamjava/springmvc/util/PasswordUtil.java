package com.grahamjava.springmvc.util;

public class PasswordUtil {
	
	/** p    * Just for nice printing.
    *
    * @param bytes
    * @return A nicely formatted byte string
    */
   public static String bytesToHex(byte[] bytes) {
       StringBuilder sb = new StringBuilder();
       for (byte b : bytes) {
           sb.append(String.format("%02X ", b));
       }
       return sb.toString();
   }

}
