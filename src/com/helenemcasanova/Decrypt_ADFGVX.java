package com.helenemcasanova;

import java.util.Arrays;

public class Decrypt_ADFGVX {
	
	private static String encryptedMessage = "AVXDGFDGAGFVFDAVDDGVGDGFFDVG";
	private static String squareKeyword = "Bro The Quick Brown Whale at 14";
	private static String secondStepKeyword = "privacy";
	
	private static char[][] encryptedInColumns;
	
	public static void main(String[] args) {
		
		encryptedInColumns = new char[(encryptedMessage.length()/secondStepKeyword.length())][secondStepKeyword.length()];
		
		int sort[] = new int[secondStepKeyword.length()];
		
		for(int i = 0; i < sort.length; i++) {
			sort[i] = (int)secondStepKeyword.charAt(i);
		}
		
		Arrays.sort(sort);
		
		int counter= 0;
		
		for(int i = 0; i < encryptedInColumns[0].length; i++) {
			
			int currentColumn = sort[i];
			
			for(int j = 0; j < encryptedInColumns.length; j++) {
				//encryptedColumns[j][currentColumn] = 
				
			}
		}
	}
	
	public void setEncryptedMessage(String em) {
		encryptedMessage = em;
	}
	
	public static String getEncryptedMessage() {
		return encryptedMessage;
	}
	
	public void setSquareKeyword(String sk) {
		squareKeyword = sk;
	}
	
	public String getSquareKeyword() {
		return squareKeyword;
	}
	
	public void setSecondStepKeyword(String ssk) {
		secondStepKeyword = ssk;
	}
	
	public String getSecondStepKeyword() {
		return secondStepKeyword;
	}
}
