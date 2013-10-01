package org.funngames.quiz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Print numbers of a given range without repeating digits.
 * 
 * @author parthabh
 * 
 */
public class NonRepeatingNumbers {
	private final static Logger logger = LoggerFactory
			.getLogger(NonRepeatingNumbers.class);

	public static void main(String[] args) {

		int fromNumber = 45;
		int toNumber = 4578;

		for (int counter = fromNumber; counter <= toNumber; counter++) {
			int number = counter;
			int rightmostDigit = 0;
			int prevRightmostDigit = -1;
			boolean isValid = true;
			do {
				rightmostDigit = number % 10;
				if (rightmostDigit == prevRightmostDigit) {
					isValid = false;
					break; 
				}
				prevRightmostDigit = rightmostDigit;
				number /= 10;
			} while (number != 0);
			if (isValid) {
				logger.debug("This is a valid number {}", counter);
			} else {
				logger.debug("Skipping {}", counter);
			}

		}
	}
}
