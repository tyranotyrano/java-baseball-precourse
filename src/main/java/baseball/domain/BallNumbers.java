package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import baseball.constant.BallNumberConstant;
import baseball.generator.NumberGenerator;

public class BallNumbers {
	private static final String INVALID_BALL_NUMBER_SIZE = "ballNumbers 의 크기는 3개 이어야 합니다.";

	private final List<BallNumber> ballNumbers;

	private BallNumbers(List<BallNumber> ballNumbers) {
		validSizeOfBallNumbers(ballNumbers);
		this.ballNumbers = ballNumbers;
	}

	public static BallNumbers createBy(NumberGenerator numberGenerator) {
		List<BallNumber> ballNumbers = new ArrayList<>();
		for (Integer number : numberGenerator.generate()) {
			ballNumbers.add(BallNumber.of(number));
		}

		return new BallNumbers(ballNumbers);
	}

	public BallNumber getBallNumber(int index) {
		return this.ballNumbers.get(index);
	}

	private void validSizeOfBallNumbers(List<BallNumber> ballNumbers) {
		if (ballNumbers == null || ballNumbers.size() != BallNumberConstant.VALID_SIZE) {
			throw new IllegalArgumentException(INVALID_BALL_NUMBER_SIZE);
		}
	}
}
