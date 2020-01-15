package com.helenemcasanova;

public class Main {
	
	public static void main (String[] args) {
		
		Encrypt_ADFGVX test = new Encrypt_ADFGVX("attackat1500am", "Bro The Quick Brown Whale at 14", "privacy");
		System.out.print(test.getResult());
		/*
		squareKeyword = squareKeywordManipulation(squareKeyword);
		System.out.println(squareKeyword);
		
		letterArray = populateLetterArray(letterArray, squareKeyword);
		
		for(int i = 0; i < letterArray.length; i++) {
			for(int j = 0; j < letterArray[i].length; j++) {
				System.out.print(letterArray[i][j] + " ");
			}
			System.out.println();
		}
		
		firstPass = plaintextToCoor(plaintextMessage, letterArray);
		System.out.println(firstPass);
		
		secondPassArray = secondPassEncrypt(firstPass, secondStepKeyword, secondPassArray);
		
		for(int i = 0; i < secondPassArray.length; i++) {
			for(int j = 0; j < secondPassArray[i].length; j++) {
				System.out.print(secondPassArray[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		secondPass = (finalEncrypted(secondPassArray)).toUpperCase();
		
		System.out.println(secondPass);*/
	}
	

}
