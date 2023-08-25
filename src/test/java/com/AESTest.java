package com;

public class AESTest {

	public static void main(String[] args) {
		final String secretkey = "3sc3RLrpd17";
		String OriginalString = "2hw6xoNYM4CXdwtMC9BY9w==";
		//String abc ="";
		String encString1 = EncyptDecypt.encrypt(OriginalString, secretkey);
		//String encString1 = "2hw6xoNYM4CXdwtMC9BY9w==";
		String decString = EncyptDecypt.decrypt(encString1, secretkey);
		System.out.println(encString1);
		System.out.println(decString);

	}

}
