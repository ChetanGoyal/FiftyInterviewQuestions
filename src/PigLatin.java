import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

public class PigLatin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		part_1_using_pig();
		//part_2_using_piglatenizeFile();
	}

	public static void part_1_using_pig() {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.print("\nWhat word? ");
			String s = sc.next();
			if (s.equals("-1"))
				System.exit(0);
			String p = pig(s);
			System.out.println(p);
		}
	}

	public static String pig(String word)
	   {
		   String punct = ".,-:;'!?/<>[]{}\\\"";
		   String pFront = "";
		   int posPunct = 0;
		   while(punct.indexOf(word.charAt(posPunct))!=-1)
		   {	
			   pFront= "" + word.charAt(posPunct)+pFront;
			   posPunct++;

			   word=word.substring(posPunct);
			   posPunct = 0;
		   }
		   String pAfter = "";
		   posPunct = word.length()-1;
		   while(punct.indexOf(word.charAt(posPunct))!=-1)
		   {
		   pAfter = "" + word.charAt(posPunct)+pAfter;
		   word=word.substring(0, posPunct);
		   posPunct--;
		   }
		   boolean isFirstCharCapital = false;
			String pigLatinResult = "";
			String reversePigLatinWord = "";
			if (Character.isUpperCase(word.charAt(0))) {
				word = word.substring(0, 1).toLowerCase() + word.substring(1);
				isFirstCharCapital = true;
			}
			int pos = -1;
			int posY = -1;
			for (int i = 0; i < word.length(); i++) {
				if (word.charAt(i) == 'y' && word.charAt(0) != 'y') {
					posY = i;
				}
			}
			for (int i = 0; i < word.length(); i++) {
				char ch = word.charAt(i);
				if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'y') {
					pos = i;
					break;
				}
			}

			if (pos != -1) {

				if (pos == 0) {
					pigLatinResult =word + "way";

					for (int i = pigLatinResult.length() - 1; i >= 0; i--) {
						reversePigLatinWord = reversePigLatinWord + pigLatinResult.charAt(i);
					}
					if (isFirstCharCapital) {
						String output = reversePigLatinWord.substring(0, 1).toUpperCase()
								+ reversePigLatinWord.substring(1);
						return pFront+output+pAfter;
					}
					return pFront+reversePigLatinWord+pAfter;
				}

				if (word.charAt(pos) == 'u') {
					String firstPart = word.substring(0, pos + 1);
					String secondPart = word.substring(pos + 1, word.length());
					pigLatinResult = secondPart + firstPart + "ay";
					for (int i = pigLatinResult.length() - 1; i >= 0; i--) {
						reversePigLatinWord = reversePigLatinWord + pigLatinResult.charAt(i);
					}
					if (isFirstCharCapital) {
						String output = reversePigLatinWord.substring(0, 1).toUpperCase()
								+ reversePigLatinWord.substring(1);
						return pFront+output+pAfter;
					}
					return pFront+reversePigLatinWord+pAfter;
				}
				if (posY != -1 && posY < pos) {
					String firstPart = word.substring(0, posY);
					String secondPart = word.substring(posY, word.length());
					pigLatinResult = secondPart + firstPart + "ay";
					for (int i = pigLatinResult.length() - 1; i >= 0; i--) {
						reversePigLatinWord = reversePigLatinWord + pigLatinResult.charAt(i);
					}
					if (isFirstCharCapital) {
						String output = reversePigLatinWord.substring(0, 1).toUpperCase()
								+ reversePigLatinWord.substring(1);
						return pFront+output+pAfter;
					}
					return pFront+reversePigLatinWord+pAfter;

				}
				String firstPart = word.substring(0, pos);
				String secondPart = word.substring(pos, word.length());
				pigLatinResult = secondPart + firstPart + "ay";
				for (int i = pigLatinResult.length() - 1; i >= 0; i--) {
					reversePigLatinWord = reversePigLatinWord + pigLatinResult.charAt(i);
				}
				if (isFirstCharCapital) {
					String output = reversePigLatinWord.substring(0, 1).toUpperCase() + reversePigLatinWord.substring(1);
					return pFront+output+pAfter;
				}
				return pFront+reversePigLatinWord+pAfter;
			} else {
				return "INVALID";
			}
	   }

	public static void part_2_using_piglatenizeFile() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Input Filename (Including .txt)? Example: PigLatin.txt:");
		String filename = sc.next();
		Scanner infile = null;
		try {
			infile = new Scanner(new File(filename)); // PigLatin.txt
		} catch (IOException e) {
			System.out.println("oops");
		}
		System.out.println("Output Filename (Including .txt)? Example: PigLatinOut.txt:");
		String filenameOut = pig(filename.split("\\.")[0]);
		// String filenameOut = sc.next();
		piglatenizeFile(infile, filenameOut);
		System.out.println("Piglatin done!");
		sc.close();
	}

	/******************************
	 * precondition: filename has .txt postcondition: output a piglatinized .txt
	 * file .
	 ******************************/
	public static void piglatenizeFile(Scanner infile, String filename) {
		/***************************
		 *
		 * enter your code here: Scanner, try-catch, nested loops, file output
		 *
		 ****************************/
		StringBuilder sb = new StringBuilder();
		try {
			while (infile.hasNext()) {
				String line = infile.next();
				String[] stringArray = line.split(" ");
				for (int i = 0; i < stringArray.length; i++) {
					String transalatedPigLatin = pig(stringArray[i]);
					sb.append(transalatedPigLatin).append(" ");
				}
			}
			try {
				PrintStream outFile = new PrintStream(new FileOutputStream(filename + ".txt"));
				outFile.print(sb);
				outFile.close();
			} catch (FileNotFoundException ex) {
				System.out.println("Unable to open file'" + filename + "'");
			}
			infile.close();
		} catch (Exception e) {
			System.out.println("Sorry!");
		}
	}
}
