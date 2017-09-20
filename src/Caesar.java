import java.util.Scanner;

public class Caesar {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Choose 1 to encrypt or 2 to decrypt --> ");
		int action = scan.nextInt();
		System.out.print("Enter an integer for the Caesar Cipher --> ");
		if (action == 1) {
			int shift = scan.nextInt() % 26;
			System.out.print("Enter a phrase to be encrypted --> ");
			scan.nextLine();
			String text = scan.nextLine();
			System.out.println("The secret phrase is -->           " + encrypt(text, shift));
		} else {
			int shift = -scan.nextInt() % 26;
			System.out.print("Enter a phrase to be decrypted --> ");
			scan.nextLine();
			String text = scan.nextLine();
			System.out.println("The message is -->                 " + decrypt(text, shift));
		}
		scan.close();
	}

	/**
	 * Method encrypts a message using the right Caesar shift with the designated
	 * offset.
	 * 
	 * @param phrase
	 *            The message to be encrypted.
	 * @param offset
	 *            The integer value designated how many spaces to shift.
	 * @return String containing the encrypted message.
	 */
	public static String encrypt(String phrase, int offset) {
		String encryptedText = "";
		for (int i = 0; i < phrase.length(); i++) {
			if (Character.isUpperCase(phrase.charAt(i)) && Character.isLetter(phrase.charAt(i))) {
				char ch = (char) (((int) phrase.charAt(i) + offset - 65) % 26 + 65);
				encryptedText += ch;
			} else if (Character.isLowerCase(phrase.charAt(i)) && Character.isLetter(phrase.charAt(i))) {
				char ch = (char) (((int) phrase.charAt(i) + offset - 97) % 26 + 97);
				encryptedText += ch;
			} else {
				encryptedText += phrase.charAt(i);
			}
		}
		return encryptedText;
	}

	/**
	 * Method deccrypts a message using the right Caesar shift with the designated
	 * offset.
	 * 
	 * @param phrase
	 *            The message to be decrypted.
	 * @param offset
	 *            The integer value designated how many spaces to shift.
	 * @return String containing the decrypted message.
	 */

	public static String decrypt(String phrase, int offset) {
		String decryptedMessage = "";
		for (int i = 0; i < phrase.length(); ++i) {
			char ch = phrase.charAt(i);

			if (ch >= 'a' && ch <= 'z') {
				ch = (char) (ch + offset);

				if (ch < 'a') {
					ch = (char) (ch + 'z' - 'a' + 1);
				}

				decryptedMessage += ch;
			} else if (ch >= 'A' && ch <= 'Z') {
				ch = (char) (ch + offset);

				if (ch < 'A') {
					ch = (char) (ch + 'Z' - 'A' + 1);
				}

				decryptedMessage += ch;
			} else {
				decryptedMessage += ch;
			}
		}
		return decryptedMessage;
	}
}