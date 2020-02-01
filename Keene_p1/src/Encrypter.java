
public class Encrypter {

	public static int encrypt(int fourDigitInput) {
		int firstDigit, secondDigit, thirdDigit, fourthDigit, encryptedData;
		
		// Separates input data into four separate integers by place
		firstDigit = fourDigitInput / 1000;
		fourDigitInput = fourDigitInput % 1000;
		secondDigit = fourDigitInput / 100;
		fourDigitInput = fourDigitInput % 100;
		thirdDigit = fourDigitInput / 10;
		fourDigitInput = fourDigitInput % 10;
		fourthDigit = fourDigitInput;
		
		// Encrypt each int by adding 7 then mod 10
		firstDigit = (firstDigit + 7) % 10;
		secondDigit = (secondDigit + 7) % 10;
		thirdDigit = (thirdDigit + 7) % 10;
		fourthDigit = (fourthDigit + 7) % 10;
		
		// Swap first and third digits, second and fourth digits
		// While combining seperate ints back into one four-digit
		encryptedData = thirdDigit * 1000; 		// third is now new first digit
		encryptedData += (fourthDigit * 100); 	// fourth is now new second digit
		encryptedData += (firstDigit * 10); 	// first is now new third digit
		encryptedData += secondDigit; 			// second is now new fourth digit
		
		// Returns new four-digit int
		return encryptedData;
	}
}