package baseballgame;

import java.util.*;

public class BaseBallGame {
	private final int VALID_NUMBER_LENGTH = 3;
	private String[] problemNumbers;
	private String[] answerNumbers;
	private int strikeCount = 0;
	private int ballCount = 0;

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

	public void countStrikesAndBalls() {
		initCount();
		countStrikes();
		countBalls();

		if (!validateStrikeAndBallCounts()) {
			throw new IllegalStateException("스트라이크, 볼 판정에 오류가 발생했습니다. 로직을 확인해주세요.");
		}
	}

	private void initCount() {
		strikeCount = 0;
		ballCount = 0;
	}

	private void countStrikes() {
		for (int i = 0; i < VALID_NUMBER_LENGTH; i++) {
			increaseCountWhenStrike(problemNumbers[i], answerNumbers[i]);
		}
	}

	void increaseCountWhenStrike(String problemNumber, String answerNumber) {
		if (problemNumber.equals(answerNumber)) {
			strikeCount++;
		}
	}

	private void countBalls() {
		for (int i = 0; i < VALID_NUMBER_LENGTH; i++) {
			boolean isStrike = problemNumbers[i].equals(answerNumbers[i]);
			increaseCountWhenBall(Arrays.asList(problemNumbers), answerNumbers[i], isStrike);
		}
	}

	void increaseCountWhenBall(List<String> problemNumbers, String answerNumber, boolean isStrike) {
		if (!isStrike && problemNumbers.contains(answerNumber)) {
			ballCount++;
		}
	}

	boolean validateStrikeAndBallCounts() {
		if ((strikeCount + ballCount) > 3 ||
			(strikeCount == 2 && ballCount == 1) ||
			(strikeCount == 3 && ballCount != 0)) {
			return false;
		}

		return true;
	}

	public void printCountResults() {
		if (strikeCount != 0) {
			System.out.print(strikeCount + "스트라이크 ");
		}

		if (ballCount != 0) {
			System.out.print(ballCount + "볼");
		}

		System.out.println(strikeCount + ballCount == 0 ? "낫싱" : "");
	}

	public int getStrikeCount() {
		return strikeCount;
	}

	public int getBallCount() {
		return ballCount;
	}
}
