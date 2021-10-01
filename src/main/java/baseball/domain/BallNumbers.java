package baseball.domain;

import java.util.ArrayList;
import java.util.List;

import baseball.constant.BallNumberConstant;
import baseball.constant.ErrorMessage;
import baseball.generator.NumberGenerator;

public class BallNumbers {
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
			throw new IllegalArgumentException(ErrorMessage.INVALID_BALL_NUMBER_SIZE);
		}
	}
}
