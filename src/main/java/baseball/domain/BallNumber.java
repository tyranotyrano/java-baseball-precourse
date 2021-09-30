package baseball.domain;

import java.util.Objects;

import baseball.constant.BallNumberConstant;

public class BallNumber {
	private static final String INVALID_BALL_NUMBER = String.format("%d 부터 %d 까지 숫자만 입력 가능합니다.",
																	BallNumberConstant.MIN,
																	BallNumberConstant.MAX);
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
			throw new IllegalArgumentException(INVALID_BALL_NUMBER);
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
