package baseball.view;

import static baseball.constant.ErrorMessage.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.constant.BallNumberConstant;
import nextstep.utils.Console;

public class BallNumberInputView {
	private static final String NUMBER_INPUT_GUIDE_MESSAGE = "숫자를 입력해주세요 : ";
	private static final String NUMBER_FROM_1_to_9_REG_EXP = "^[1-9]+$";

	public List<Integer> inputBallNumbers() {
		System.out.print(NUMBER_INPUT_GUIDE_MESSAGE);
		String number = Console.readLine();

		if (isValidInputNumbers(number)) {
			return convertToIntegers(number);
		}

		System.out.println(INVALID_INPUT_NUMBER);
		return inputBallNumbers();
	}

	private boolean isValidInputNumbers(String numbers) {
		if (numbers == null || numbers.length() != BallNumberConstant.VALID_SIZE) {
			return false;
		}

		Set<String> distinctNumbers = new HashSet<>(Arrays.asList(numbers.trim().split("")));
		return numbers.matches(NUMBER_FROM_1_to_9_REG_EXP) && distinctNumbers.size() == BallNumberConstant.VALID_SIZE;
	}

	private List<Integer> convertToIntegers(String number) {
		List<Integer> numbers = new ArrayList<>();
		String[] splitNumbers = number.split("");
		for (String splitNumber : splitNumbers) {
			numbers.add(Integer.valueOf(splitNumber));
		}

		return numbers;
	}
}
