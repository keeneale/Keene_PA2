
public class Decrypter {
	
	public static int decrypt(int fourDigitInput) {
		int firstDigit, secondDigit, thirdDigit, fourthDigit, decryptedData;
		
		// Separates input data into four separate integers by place
		firstDigit = fourDigitInput / 1000;
		fourDigitInput = fourDigitInput % 1000;
		secondDigit = fourDigitInput / 100;
		fourDigitInput = fourDigitInput % 100;
		thirdDigit = fourDigitInput / 10;
		fourDigitInput = fourDigitInput % 10;
		fourthDigit = fourDigitInput;
				
		// Decrypt each int by adding 3 (+10 - 7) then mod 10
		firstDigit = (firstDigit + 3) % 10;
		secondDigit = (secondDigit + 3) % 10;
		thirdDigit = (thirdDigit + 3) % 10;
		fourthDigit = (fourthDigit + 3) % 10;
				
		// Swap first and third digits, second and fourth digits
		// While combining seperate ints back into one four-digit
		decryptedData = thirdDigit * 1000; 		// third is now new first digit
		decryptedData += (fourthDigit * 100); 	// fourth is now new second digit
		decryptedData += (firstDigit * 10); 	// first is now new third digit
		decryptedData += secondDigit; 			// second is now new fourth digit		
				
		// Returns new four-digit int
		return decryptedData;
	}
}