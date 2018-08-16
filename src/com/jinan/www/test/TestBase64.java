package com.jinan.www.test;

import java.io.IOException;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class TestBase64 {
	public static void main(String[] args) throws IOException {
		// BASE64编码
		String s = "111111";
		BASE64Encoder encoder = new BASE64Encoder();
		s = encoder.encode(s.getBytes("UTF-8"));
		System.out.println(s);

		// BASE64解码
		BASE64Decoder decoder = new BASE64Decoder();
		byte[] bytes = decoder.decodeBuffer("MTExMTEx");
		System.out.println(new String(bytes, "UTF-8"));
		}
	
}
