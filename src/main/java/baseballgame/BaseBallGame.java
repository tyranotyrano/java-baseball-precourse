package baseballgame;

import java.util.*;

public class BaseBallGame {
	private final int VALID_NUMBER_LENGTH = 3;
	private String[] problemNumbers;
	private String[] answerNumbers;

	public void createProblemNumbers() {
		Set<String> numberSet = createNumberSet();
		problemNumbers = String.join("", numberSet)
				.split("");

		if (!validateStringNumbers(problemNumbers)) {
			throw new IllegalStateException("문제 생성에 실패하였습니다. 문제 생성 로직을 확인해주세요.");
		}
	}

	private Set<String> createNumberSet() {
		Set<String> numbers = new LinkedHashSet<>();

		while (numbers.size() < 3) {
			int number = drawRandomNumberFrom1to9();
			numbers.add(String.valueOf(number));
		}

		return numbers;
	}

	int drawRandomNumberFrom1to9() {
		Random random = new Random();
		return random.nextInt(9) + 1;
	}

	boolean validateStringNumbers(String[] stringNumbers) {
		if (stringNumbers == null || stringNumbers.length != 3) {
			return false;
		}

		String NUMBER_FROM_1_to_9_REG_EXP = "^[1-9]+$";
		String join = String.join("", stringNumbers);
		Set<String> set = new HashSet<>(Arrays.asList(stringNumbers));

		return join.matches(NUMBER_FROM_1_to_9_REG_EXP) && set.size() == VALID_NUMBER_LENGTH;
	}

	public void receiveAnswerNumbers() {
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.print("숫자를 입력해주세요(1~9 중 서로 다른 3자리수) : ");
			answerNumbers = scanner.next().split("");
		} while (!validateStringNumbers(answerNumbers));
	}
}
