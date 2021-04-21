import java.io.*;
import java.util.*;

public class CryptoMain {

	
	static char[] firstch;
	static char[] secondch;
	static char[] resultch;
	static String puzzleChars = "";
	static Scanner scanner = new Scanner(System.in);
	
	public static void readUserInput() {
		System.out.println("Please insert the first addant of the cryptarithmetic puzzle:");
		
		String first = scanner.nextLine();
		firstch = first.toCharArray(); 
		System.out.println("Please insert the second addant of the cryptarithmetic puzzle:");
		
		String second = scanner.nextLine();
		secondch = second.toCharArray();
		System.out.println("Please insert the result of the cryptarithmetic puzzle:");
		
		String result = scanner.nextLine();
		resultch = result.toCharArray();
	}

	public static int numberSystem() {
		System.out.println("in what system shall the cryptarithm be solved? (6 for senary and 10 for tens)");
		int numberSys = Integer.parseInt(scanner.nextLine());
		if(numberSys == 6) {
			System.out.println("You chose senary");
		}else if(numberSys == 10) {
			System.out.println("You chose decimal");
		}else {
			System.out.println("You gave invalid answer");
		}
		scanner.close();
		
		return numberSys;
	}

	public static HashMap<Character, Integer> lettersOfCrypt(HashMap<Character, Integer> letters) {
		
		for(char c1 : firstch) {
			if(!letters.containsKey(c1)) {
				puzzleChars += c1;
				letters.put(c1, -1);
			}
		}
		
		for(char c2 : secondch) {
			if(!letters.containsKey(c2)) {
				puzzleChars += c2;
				letters.put(c2, -1);
			}
		}
		
		for(char cr : resultch) {
			if(!letters.containsKey(cr)) {
				puzzleChars += cr;
				letters.put(cr, -1);
			}
		}
		//System.out.println(letters);
		return letters;
	}

	public static void solver(boolean[] used, int indicator, int numerical, HashMap<Character, Integer> letters) {
		
		if (indicator == puzzleChars.length()) {
			//we have seen all the characters and assigned them with a value
			checker(numerical,letters);	
			return;
		}
		
		char c = puzzleChars.charAt(indicator);	
		//System.out.println(c);
		for(int n = 0; n < numerical; n++) {
			if(used[n] == false) {
				used[n] = true;
				letters.put(c,n);
				solver(used,indicator+1,numerical,letters);
				letters.put(c, -1);
				used[n] = false;
			}
		}

	}
	

	public static String numToString(int numerical, char[] puzzlepiece, HashMap<Character, Integer> letters) {
		
		String num = "";

	     for(int i = 0; i < puzzlepiece.length; i++){
		  char ch = puzzlepiece[i];
		  num = num + letters.get(ch);
	     }
	     
	     num = Integer.toString(Integer.parseInt(num, numerical),10);
	   	 return num;
	}
	
	
	public static void checker(int numerical, HashMap<Character, Integer> letters) {
		//Here we check that the values we have assigned to the puzzle chars 
		String s1 = numToString(numerical,firstch,letters);
		String s2 = numToString(numerical,secondch,letters);
		String sr = numToString(numerical,resultch,letters);
		int sum1 = Integer.parseInt(s1); 
		int sum2 = Integer.parseInt(s2);
		int sumres = Integer.parseInt(sr);
		int left = sum1 + sum2;
		
		if(left == sumres && (!letters.get(resultch[0]).equals(0)) && (!letters.get(firstch[0]).equals(0)) && (!letters.get(secondch[0]).equals(0))) {
			System.out.println("Solution found!");
			String first = "";
			String second = "";
			String result = "";
			//we recostruct the character arrays as strings in order to print them
			for(char c : firstch) {
				first += c;
			}
			for(char c : secondch) {
				second += c;
			}
			for(char c : resultch) {
				result += c;
			}
			System.out.println(first+ " + " +second+ " = " +result);
			System.out.println(letters);
			return;
		}
		return;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readUserInput();
		int numerical = numberSystem();
		HashMap<Character, Integer> letters = new HashMap<>();
		letters = lettersOfCrypt(letters);
		if(letters.size() > numerical) { // check if the unique letters are more than the available numbers in the chosen metric
			System.out.println("You gave invalid puzzles for this numerical system :(");
			return;
		}
		int index = 0;
		boolean[] used = new boolean[numerical];
		solver(used,index, numerical, letters);
		
	    
	}

}