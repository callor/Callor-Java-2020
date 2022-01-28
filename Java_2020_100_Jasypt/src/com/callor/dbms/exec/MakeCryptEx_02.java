package com.callor.dbms.exec;

import java.security.Security;
import java.util.ArrayList;
import java.util.List;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class MakeCryptEx_02 {

	public static void main(String[] args) {

		/*
		 * PBE 알고리즘
		 * 
		 * PBEWithMD5AndDES
		 * PBEWithSHAAndBlowfish
		 * PBEWithSHAAnd128BitRC4
		 * PBEWithSHAAndDEA-CBC
		 * PBEWithSHAAnd3-KeyTripleDES-CBC
		 * 
		 * PBE 확장 알고리즘 JCE 정책때문에 오류가 날수 있다.
		 * 1.8.161 이상에서는 정상 작동
		 * 
		 * PBEwithMD5and128bitAES-CBC-OPENSSL |    16
		 * PBEwithMD5and192bitAES-CBC-OPENSSL |    16
		 * PBEwithMD5and256bitAES-CBC-OPENSSL |    16
		 * PBEwithMD5andDES                   |    16
		 * PBEwithMD5andRC2                   |    16
		 * PBEwithSHA1andRC2                  |    16
		 * PBEwithSHA1andDES                  |    16
		 * PBEwithSHAand128bitAES-CBC-BC      |     7
		 * PBEwithSHAand192bitAES-CBC-BC      |     7
		 * PBEwithSHAand256bitAES-CBC-BC      |     7
		 * PBEwithSHAand40bitRC2-CBC          |     7
		 * PBEwithSHAand128bitRC2-CBC         |     7
		 * PBEwithSHAand40bitRC4              |     7
		 * PBEwithSHAand128BITRC4             |     7
		 * PBEwithSHAandAND128BITAES-CBC-BC   |     7
		 * PBEwithSHAandAND192BITAES-CBC-BC   |     7
		 * PBEwithSHAandAND256BITAES-CBC-BC   |     7
		 * PBEwithSHAand2-KEYTRIPLEDES-CBC    |     7
		 * PBEwithSHAand3-KEYTRIPLEDES-CBC    |     7
		 * PBEwithSHAandTWOFISH-CBC           |     7
		 */
		System.out.println("PBEWITHSHA256AND256BITAES-CBC-BC 암호화");
		
		Security.addProvider(new BouncyCastleProvider());
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        
        /*
         * Oracle JDK의 JCE(Java Cryptography Extension) 정책상 AES128까지만 지원한다.
         * AES256을 사용하기 위해서 BouncyCastleProvider를 사용하고
         * JCE provider name에 명시를 해 주어야 한다.
         */
        pbeEnc.setProviderName("BC"); 
        pbeEnc.setAlgorithm("PBEwithSHA256and256bitAES-CBC-BC"); // SHA 256bit and AES 256bit
        pbeEnc.setPassword("com.callor");
         
        
        List<String> encryptList = new ArrayList<String>();
        
        String url = null;
        for(int i = 0 ; i < 10 ; i++) {
        	url = pbeEnc.encrypt("jdbc:oracle:thin:@127.0.0.1:1521:xe");
        	encryptList.add(url);
        }
        String username = pbeEnc.encrypt("system");
        
        System.out.println("URL crypt Text : " +url);
        System.out.println("UserName crypt Text : " + username);
        
        System.out.println("URL Plane Text : " + pbeEnc.decrypt(url));
        System.out.println("UserName Plan Text :"+pbeEnc.decrypt(username));

        System.out.println(String.format("%0105d",0).replace("0", "="));
        System.out.println("Encrypt to Decrypt Test");
        System.out.println(String.format("%0105d",0).replace("0", "-"));
        for(String enc : encryptList) {
        	
        	System.out.println("\u001b[41mEncrypt Text : \u001b[0m" + enc);
        	System.out.println("\u001b[44mDecrypt Text : \u001b[0m" + pbeEnc.decrypt(enc));
        	System.out.println();
        	
        }
        System.out.println(String.format("%0105d",0).replace("0", "="));
        
//        System.out.println("Decrypt Test :" + pbeEnc.decrypt("99J8rXjKcqxF4h3a6C3www9/XEGcdzsGjpBz4j2CxP3xjqlQv8HMgZqALp9kAOZN2HzFqDk5U7PXhScLYYwsYA=="));
//        System.out.println("Decrypt Test :" + pbeEnc.decrypt("udLVzq81t7b840cK4F9MkXZ5x1rgUY6dywye/qTg9eIN+aioVN8OpQiqbf60XiCpcmHcrlbkuGdkei2Oqq/U7g=="));
//        System.out.println("Decrypt Test :" + pbeEnc.decrypt("qB6eXoXVZTppV2y3nPLBMzD+BSFf+9ihSAv9zmKbI5V0dJuDVBYpUB132q04FIR4QeixriKqT/aqqFy3lAygsQ=="));
//        System.out.println("Decrypt Test :" + pbeEnc.decrypt("XA1wFUPz+ZWj4H/s5zyCxCF2849VufCZPE70TcIDvMjaP3LrlJrPjYPjyKlXFfmUnsoYJJHwgeEqGGzILPWSzQ=="));
//        System.out.println("Decrypt Test :" + pbeEnc.decrypt("7Q+iIGu2RcIYkrv2M+2kzi6fS2GURMOHgYhdNImwQI9ALO9pMDQMORpK9XpV+j71ACLUqLTORj5HCak9fD8kpw=="));
    }
	
}
