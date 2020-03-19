package com.codejava.todoapp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BcryptEncoderTest {
	public static void main(String [] arg) {
		BCryptPasswordEncoder encoder=     new	BCryptPasswordEncoder() ;
	String encodedString=	encoder.encode("nadeem");
	System.out.println(encodedString);
	
		
	}
}
