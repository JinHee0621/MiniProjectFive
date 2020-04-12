package com.kh.mini.model.vo;
import java.util.Random;

//인증번호 생성 클래스
public class Code {

	private int codeLength = 8;
	private final char[] carr = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 
			'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 
			'Y', 'Z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };

	public String generate() {
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < codeLength; i++) {
			sb.append(carr[new Random().nextInt(36)]);
		}
		return sb.toString();
	}
	
	public int getCodeLength() {
		return codeLength;
	}
	
}