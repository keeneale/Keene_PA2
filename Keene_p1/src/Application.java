import java.util.Scanner;

public class Application {

	public static void main(String[] args) {
		// Prompt user to enter valid integer
		System.out.println("Enter a four-digit integer:");
		
		// Scan and save data
		Scanner input = new Scanner(System.in);
		int fourDigitInput = input.nextInt();
//		input.close();
		// Print user four-digit input
		System.out.printf("You entered: %04d%n", fourDigitInput);
		
		// Ask user to select Encrypter or Decrypter
		System.out.println("Select an option:");
		System.out.println("1 - Encrypt Data");
		System.out.println("2 - Decrypt Data");
		
//		Scanner input1 = new Scanner(System.in);
		int userSelection = input.nextInt();
		input.close();
		
		// Encrypt Data Selection
		if (userSelection == 1)
		{
			// Send user data to Encrypter which returns new four digit int
			int encryptedData = Encrypter.encrypt(fourDigitInput);
		
			// Print encrypted four-digit int
			System.out.printf("Encrypted data: %04d%n", encryptedData);
		}
		// Decrypt Data Selection
		else if (userSelection == 2)
		{
			// Send user data to Decrypter which returns new four digit int
			int decryptedData = Decrypter.decrypt(fourDigitInput);
		
			// Print decrypted four-digit int
			System.out.printf("Decrypted data: %04d%n", decryptedData);
		}
		else
		{
			System.out.println("Error: Please try again.");
		}
	}

}