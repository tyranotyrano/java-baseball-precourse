package baseball.domain;

import java.util.Objects;

import baseball.constant.BallNumberConstant;
import baseball.constant.ErrorMessage;

public class BallNumber {
	private final int number;

	private BallNumber(int number) {
		this.number = number;
	}

	public static BallNumber of(int number) {
		validateBallNumber(number);
		return new BallNumber(number);
	}

	public int getNumber() {
		return number;
	}

	private static void validateBallNumber(int number) {
		if (number < BallNumberConstant.MIN || BallNumberConstant.MAX < number) {
			throw new IllegalArgumentException(ErrorMessage.INVALID_BALL_NUMBER);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		BallNumber that = (BallNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
