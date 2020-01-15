package com.helenemcasanova;

import java.util.Arrays;

public class Encrypt_ADFGVX {
	
	//Strings to get from the user
	private static String squareKeyword;
	private static String secondStepKeyword;
	private static String plaintextMessage;
	
	private static String firstPass = "";
	private static String secondPass = "";
	
	private static char [][] letterArray = new char [6][6];
	private static char [][] secondPassArray;
	//ADFGVX
	
	
	public Encrypt_ADFGVX(String ptm, String sk, String ssk) {
		setPlaintextMessage(ptm);
		setSquareKeyword(sk);
		setSecondStepKeyword(ssk);
	}
	
	
	public void setPlaintextMessage(String ptm) {
		plaintextMessage = ptm;
	}
	
	public static String getPlaintextMessage() {
		return plaintextMessage;
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
	
	
	private static String squareKeywordManipulation(String sk) {
		sk = (sk.toLowerCase()).replaceAll("\\s+","");
		String newSK = "";
		
		for(int i = 0; i < sk.length(); i++) {
			char currentChar = sk.charAt(i);
			boolean sameLetter = false;
			
			for(int j = newSK.length() - 1; j > -1; j--) {
				if((currentChar == newSK.charAt(j)) && newSK.length() > 1) {
					sameLetter = !sameLetter;
					break;
				}
			}
			
			if(sameLetter == false) {
				newSK += currentChar;
			}
		}
		
		for(int i = (int)'a'; i <= (int)'z'; i++) {
			
			boolean isInString = false;
			
			for(int j = 0; j < newSK.length(); j++) {
				int currentChar = (int)newSK.charAt(j);
				
				if(i == currentChar) {
					isInString = !isInString;
					break;
				}
				
			}
			
			if(isInString == false) {
				newSK += (char)i;
			}
			
		}
		
		for(int i = 0; i < 10; i++) {
			boolean isInString = false;
			
			for(int j = 0; j < newSK.length(); j++) {
				
				if(((int)newSK.charAt(j) - 48) == i) {
					isInString = !isInString;
					break;
				}
			}
			
			if(isInString == false) {
				newSK += i;
			}
		}
		
		return newSK;
	}
	
	private static char[][] populateLetterArray(char[][] la, String sk) {
		int skLength = 0;
		
		for(int i = 0; i < la.length; i++) {
			for(int j = 0; j < la[i].length; j++) {
				la[i][j] = sk.charAt(skLength);
				skLength++;
			}
		}
		
		return la;
	}
	
	private static String plaintextToCoor(String pt, char[][] la) {
		String headers = "adfgvx";
		String coors = "";
		
		for(int k = 0; k < pt.length(); k++) {
			char currentChar = pt.charAt(k);
			
			for(int i = 0; i < la.length; i++) {
				for(int j = 0; j < la[i].length; j++) {
					if(la[i][j] == currentChar) {
						coors  = coors + headers.charAt(i) + headers.charAt(j);
						
						break;
					}
				}
				
			}
		}
		
		return coors;
	}
	
	private static char[][] secondPassEncrypt(String fp, String spk, char[][] spa) {
		spa = new char[(fp.length()/spk.length()) + 1][spk.length()];
		
		int spka[] = new int[spk.length()];
		
		for(int i = 0; i < spka.length; i++) {
			spka[i] = (int)spk.charAt(i);
		}
		
		Arrays.sort(spka);
		
		String spkHolder = "";
		
		for(int i = 0; i < spka.length; i++) {
			spkHolder += (char)spka[i];
		}
		
		
		for(int i = 0; i < spk.length(); i++) {
			
			int place = spkHolder.indexOf(spk.charAt(i));
			
			spa[0][i] = (char)(49 + place);
		}
		
		int counter = 0;
		
		for(int i = 1; i < spa.length; i++) {
			for(int j = 0; j < spa[i].length; j++) {
				spa[i][j] = fp.charAt(counter);
				counter++;
			}
		}
		
		return spa;
	}
	
	private static String finalEncrypted(char[][] spa) {
		char finalKeywordArray[][] = new char[spa.length-1][spa[0].length];
		String sp = "";
		
		for(int i = 0; i < spa[0].length; i++) {
			int columnNumber = (spa[0][i] - 49);
			
			for(int j = 0; j < finalKeywordArray.length; j++) {
				finalKeywordArray[j][columnNumber] = spa[(j+1)][i];
			}
		}
		
		for(int i = 0; i < finalKeywordArray[0].length; i++) {
			for(int j = 0; j < finalKeywordArray.length; j++) {
				sp += finalKeywordArray[j][i];
			}
		}
		
		return sp;
		
	}
	
	public String getResult() {
		String manipulated = squareKeywordManipulation(squareKeyword);
		letterArray = populateLetterArray(letterArray, manipulated);
		firstPass = plaintextToCoor(getPlaintextMessage(), letterArray);
		secondPassArray = secondPassEncrypt(firstPass, getSecondStepKeyword(), secondPassArray);
		secondPass = (finalEncrypted(secondPassArray)).toUpperCase();
		
		return secondPass;
	}
}
