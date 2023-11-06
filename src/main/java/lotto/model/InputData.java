package lotto.model;

import camp.nextstep.edu.missionutils.Console;
import lotto.validate.Validate;
import java.util.*;

public class InputData {
	public static String playerFinance() {
		String inputData ="";
		boolean isValidInput = false;
		while(!isValidInput) {
			try {
				inputData = Console.readLine();
				Validate.numericInput(inputData);
				Validate.minimumAmount(Integer.parseInt(inputData));//최소금액검사
				Validate.thousandMultiple(Integer.parseInt(inputData));//1000단위인지
				isValidInput = true;
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
		return inputData;
	}
	private static List<Integer> parseIntegers(String str){
		List<Integer> numberList = new ArrayList<>();
		for(String num : str.split(",")) numberList.add(Integer.parseInt(num));
		return numberList;
	}
	
	public static List<Integer> winningNumber(){
		List<Integer> winningNumber = new ArrayList<>();
		boolean isValidInput = false;
		while(!isValidInput) {
			try {
				String inputData = Console.readLine();
				Validate.validateFormat(inputData);
				Validate.numberInRange(inputData);
				Validate.validSixNumberInput(inputData);
				winningNumber = parseIntegers(inputData);
				isValidInput = true;
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
		return winningNumber;
	}
	
	public static int bonusNumber(List<Integer> winningNumbers) {
		int bonusNumber = 0;
		boolean isValidInput = false;
		while(!isValidInput){
			try {
				String inputData = Console.readLine();
				Validate.numericInput(inputData);
				bonusNumber = Integer.parseInt(inputData);
				Validate.numberInRange(bonusNumber);
				Validate.bonusNumberUniqueness(winningNumbers, bonusNumber);
				isValidInput = true;
			} catch (IllegalArgumentException error) {
				System.out.println(error.getMessage());
			}
		}
		return bonusNumber;
	}
	
}
