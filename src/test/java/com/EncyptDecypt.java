package com;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncyptDecypt{
	private static SecretKeySpec secretkey;
	private static byte[] key;
	
	public static void setKey(String myKey) {
		try {
			key = myKey.getBytes("UTF-8");
			MessageDigest sha = MessageDigest.getInstance("SHA-1");
			key = sha.digest(key);
			key = Arrays.copyOf(key, 16);
			secretkey = new SecretKeySpec(key, "AES");
		} catch (NoSuchAlgorithmException e) {
		}
		catch (UnsupportedEncodingException e) {
		}
		}
		
	public static String encrypt(String strtoEnc, String sec) {
		try {
			System.out.println("Secret key   "+secretkey);

			setKey(sec);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretkey);
			return Base64.getEncoder().encodeToString(cipher.doFinal(strtoEnc.getBytes("UTF-8")));

		} catch (Exception e) {
		}
		return null;
	}
	public static String decrypt(String strtoDec, String sec) {
		try {
			setKey(sec);
			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, secretkey );
			return new String(cipher.doFinal(Base64.getDecoder().decode(strtoDec)));

		} catch (Exception e) {
		}
		return null;
	}
	
}