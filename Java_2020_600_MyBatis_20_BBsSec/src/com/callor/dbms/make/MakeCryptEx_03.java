package com.callor.dbms.make;

import java.security.Security;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;

public class MakeCryptEx_03 {

	public static void main(String[] args) {

		System.out.println("PBEWITHSHA256AND128BITAES-CBC-BC 암호화");
		
		Security.addProvider(new BouncyCastleProvider());
        StandardPBEStringEncryptor pbeEnc = new StandardPBEStringEncryptor();
        
        pbeEnc.setProviderName("BC"); // jce provider name
        pbeEnc.setAlgorithm("PBEWITHSHA256AND128BITAES-CBC-BC"); // AES 256bit도 가능
        pbeEnc.setPassword("com.korail");
         
        String url = pbeEnc.encrypt("jdbc:oracle:thin:@127.0.0.1:1521:XE");
        String username = pbeEnc.encrypt("user4");
        
        System.out.println(url);
        System.out.println(username);
        
        System.out.println(pbeEnc.decrypt(url));
        System.out.println(pbeEnc.decrypt(username));
        
        System.out.println(pbeEnc.decrypt("2iOnc1A4VlTLHq01iaQLzxDGnCeF1gi/a0YcuZWZsr/97vmcEXH+Ziylq6GCZbiWSySzUdBJoKvBAu+7d5ND0g=="));
        System.out.println(pbeEnc.decrypt("WmAFQNWpOYHpkZV7BrArP9YDrTO4vVxKBexlYgudCCB7gFQXW3n7VEKhhdexuHfN8xcW4uM2UekaIAdjy2vMeg=="));
    }
	
	
}
