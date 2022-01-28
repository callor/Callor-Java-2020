package com.callor.dbms.config;

import java.nio.ByteBuffer;
import java.security.AlgorithmParameters;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * java 1.8.161 이상에서 사용하는 AES256 암 복호화 코드
 * 
 * AES 256 으로 암호화
 * AES 256은 키가 256bit 즉 32바이트 문자열 이어야 한다.
 * 임의의 길이의 키 문자열을 받아서 랜덤 salt 를 첨가해서 해시하여 256bit 키를 생성한다,
 * 
 * 암호화 모드는 CBC를 사용하고, 길이를 일정하게 하는데 PKCS5 패딩을 사용한다.
 * salt를 사용하므로 동일한 값을 암호화 하더라도 암호된 값이 동일하지 않다.
 * 
 * 결과값에는 salt와 iv값을 추가하여 Base64로 엔코딩 하여 반환한다.
 * 
 * Java 8에는 java.util.Base64 기능이 포함되어 있지만, 
 * 그 이전 버전의 JDK를 사용한다면 
 * apache common codec 라이브러리 등을 사용하여 Base64 엔코딩 기능을 사용할 수 있다
 * 
 * @author callor
 *
 */
public class AES256 {
	public static String encryptAES256(String msg, String key) throws Exception {

	    SecureRandom random = new SecureRandom();

	    byte bytes[] = new byte[20];
	    random.nextBytes(bytes);
	    byte[] saltBytes = bytes;

	    // Password-Based Key Derivation function 2
	    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

	    // 70000번 해시하여 256 bit 길이의 키를 만든다.
	    PBEKeySpec spec = new PBEKeySpec(key.toCharArray(), saltBytes, 70000, 256);

	    SecretKey secretKey = factory.generateSecret(spec);
	    SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(), "AES");

	    // 알고리즘/모드/패딩
	    // CBC : Cipher Block Chaining Mode
	    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	    cipher.init(Cipher.ENCRYPT_MODE, secret);
	    AlgorithmParameters params = cipher.getParameters();

	    // Initial Vector(1단계 암호화 블록용)
	    byte[] ivBytes = params.getParameterSpec(IvParameterSpec.class).getIV();
	    byte[] encryptedTextBytes = cipher.doFinal(msg.getBytes("UTF-8"));
	    byte[] buffer = new byte[saltBytes.length + ivBytes.length + encryptedTextBytes.length];
	    System.arraycopy(saltBytes, 0, buffer, 0, saltBytes.length);
	    System.arraycopy(ivBytes, 0, buffer, saltBytes.length, ivBytes.length);
	    System.arraycopy(encryptedTextBytes, 0, buffer, saltBytes.length + ivBytes.length, encryptedTextBytes.length);

	    return Base64.getEncoder().encodeToString(buffer);

	}

	/*
	 * 암호화된 내용을 Base64 디코드 한다.
	 * 먼저 붙였던 salt, iv와 데이터를 분리한다.
	 * 
	 * 복호화를 수행하고 복호화된 바이트 배열을 문자열로 만들어 반환한다.
	 * 
	 */
	public static String decryptAES256(String msg, String key) throws Exception {

	    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
	    ByteBuffer buffer = ByteBuffer.wrap(Base64.getDecoder().decode(msg));

	    byte[] saltBytes = new byte[20];
	    buffer.get(saltBytes, 0, saltBytes.length);

	    byte[] ivBytes = new byte[cipher.getBlockSize()];
	    buffer.get(ivBytes, 0, ivBytes.length);

	    byte[] encryoptedTextBytes = new byte[buffer.capacity() - saltBytes.length - ivBytes.length];
	    buffer.get(encryoptedTextBytes);

	    SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	    PBEKeySpec spec = new PBEKeySpec(key.toCharArray(), saltBytes, 70000, 256);
	    SecretKey secretKey = factory.generateSecret(spec);
	    SecretKeySpec secret = new SecretKeySpec(secretKey.getEncoded(), "AES");
	    cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(ivBytes));

	    byte[] decryptedTextBytes = cipher.doFinal(encryoptedTextBytes);
	    return new String(decryptedTextBytes);

	}
	
	
	/*
	 * MD5 해시
	 */
	public static String md5(String msg) throws NoSuchAlgorithmException {

	    MessageDigest md = MessageDigest.getInstance("MD5");
	    md.update(msg.getBytes());
	    return byteToHexString(md.digest());

	}

	/*
	 * sha256으로 해시
	 */
	public static String sha256(String msg)  throws NoSuchAlgorithmException {

	    MessageDigest md = MessageDigest.getInstance("SHA-256");
	    md.update(msg.getBytes());
	    return byteToHexString(md.digest());

	}


	/*
	 * byte 배열을 Hex 문자열로 변환
	 */
	public static String byteToHexString(byte[] data) {

	    StringBuilder sb = new StringBuilder();

	    for(byte b : data) {
	        sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
	    }

	    return sb.toString();

	}

}
