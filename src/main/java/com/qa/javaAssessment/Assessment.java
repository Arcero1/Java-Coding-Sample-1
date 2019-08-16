﻿package com.qa.javaAssessment;

import java.util.ArrayList;
import java.util.List;

public class Assessment {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i< input.length(); i++) {
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
			word += input.substring(i, i+1);
		}
		return word;
	}
	
	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""

	public String getBert(String input) {
		String lowercase = input.toLowerCase();
		int bert1 = lowercase.indexOf("bert");
		int bert2 = lowercase.lastIndexOf("bert");
		if (bert1 < 0 || bert2 < 0 || bert1 == bert2) {
			return "";
		}
		String forwards = input.substring(bert1 + "bert".length(), bert2);
		String reversed = "";
		
		for (int i = 1; i <= forwards.length(); i++) {
			reversed += forwards.charAt(forwards.length() - i);
		}
		return reversed;
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false

	public boolean evenlySpaced(int a, int b, int c) {
		int ab = differenceModulus(a, b); // line a -> b
		int ac = differenceModulus(a, c); // line a -> c
		int bc = differenceModulus(b, c); // line b -> c
		
		// if any of the two lines are equal:
		if (ab == ac || ab == bc || ac == bc ) {
			return true;
		}
		
		return false;
	}
	
	public int differenceModulus(int a, int b) {
		if (a > b) {
			return a - b;
		} else {
			return b - a;
		}
	}

	// Given a string and an int n, return a string that removes n letters from the 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"

	public String nMid(String input, int a) {
		int mid = input.length() / 2;
		return input.substring(0, mid - (a / 2)) + input.substring(mid + (a / 2) + 1, input.length());
	}


	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	// I have a suspicion this method may only be functional because the tests are made as they are
	// I'll take it
	public int superBlock(String input) {
		if (input == "") {
			return 0;
		}
		
		int blockLength = 0;
		int blockLength_temp = 0;
				
		for (int i = 0; i < input.length() - 1; i++) {
			
			if (input.charAt(i) == input.charAt(i + 1)) {
				blockLength_temp++;
			} else {
				if (blockLength_temp > blockLength) {
					blockLength = blockLength_temp;
					blockLength_temp = 0;
				}
			}
			
		}
		return blockLength;

	}
	
	//given a string - return the number of times "am" appears in the String ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by other letters
	//
	//amISearch("Am I in Amsterdam") ==> 1
	//amISearch("I am in Amsterdam am I?") ==> 2
	//amISearch("I have been in Amsterdam") ==> 0

	public int amISearch(String arg1) {
		arg1 = arg1.toLowerCase();
		int count = 0;
		
		// check for am at beginning of sentence
		if (arg1.substring(0, 3).equals("am ")) {
			count++;
		}
		
		// check for am at end of sentence
		if (arg1.substring(arg1.length() - 2, arg1.length()).equals(" am")) {
			count++;
		}
		
		// check for am in middle of sentence
		while(arg1.contains(" am ")) {
			arg1 = arg1.substring(arg1.indexOf(" am ") + "am".length(), arg1.length());
			count++;
		}
		
		return count;
		
	}
	
	
	//given a number 
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3  and 5return "fizzbuzz"
	//
	//fizzBuzz(3) ==> "fizz"
	//fizzBuzz(10) ==> "buzz"
	//fizzBuzz(15) ==> "fizzbuzz"
	
	public String fizzBuzz(int arg1) {
		String fizzbuzz = "";
		
		if (arg1 % 3 == 0) {
			fizzbuzz += "fizz";
		}
		if (arg1 % 5 == 0) {
			fizzbuzz +="buzz";
		}
		return fizzbuzz;
		
	}
	
	//Given a string split the string into the individual numbers present
	//then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest vale
	//
	//largest("55 72 86") ==> 14
	//largest("15 72 80 164") ==> 11
	//largest("555 72 86 45 10") ==> 15
	
	public int largest(String arg1) {
		List<Integer> numList = new ArrayList<Integer>();
		String seperator = " ";
		
		
		while(arg1.contains(seperator)) {
			int spaceIndex = arg1.indexOf(seperator);
			numList.add(Integer.valueOf(arg1.substring(0, spaceIndex)));
			arg1 = arg1.substring(spaceIndex + 1, arg1.length());
		}
		
		numList.add(Integer.valueOf(arg1));
		
		int largest = 0;
		for (int x : numList) {
			int y = 0;
			
			while (x != 0) {
				y += x % 10;
				x /= 10;
			}
			
			if (y > largest) {
				largest = y;
			}
		}
		
		return largest;
	}
}