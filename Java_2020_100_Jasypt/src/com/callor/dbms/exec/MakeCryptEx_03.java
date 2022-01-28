package com.callor.dbms.exec;

import com.callor.dbms.config.AES256;

public class MakeCryptEx_03 {

	public static void main(String[] args) throws Exception {

		String plainText = "Hello, World!";
        String key = "secret key";

        System.out.println("MD5 : " + plainText + " - " + AES256.md5(plainText));
        System.out.println("SHA-256 : " + plainText + " - " + AES256.sha256(plainText));

        for(int i = 0 ; i < 10 ; i++) {
            String encrypted = AES256.encryptAES256("Hello, World!", key);
            System.out.println("\u001b[41m AES-256 : enc - \u001b[0m" + encrypted);
            System.out.println("\u001b[45m AES-256 : dec - \u001b[0m" + AES256.decryptAES256(encrypted, key));
            System.out.println();
        }

    }
	
}
