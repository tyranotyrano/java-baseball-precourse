package baseball.domain;

import baseball.constant.BallNumberConstant;

public class Hint {
	private static final int STRIKE_COUNT_MIN = 0;
	private static final int STRIKE_COUNT_MAX = 3;
	private static final int BALL_COUNT_MIN = 0;
	private static final int BALL_COUNT_MAX = 3;

	private int strikeCount;
	private int ballCount;

	private Hint() {
		this.strikeCount = STRIKE_COUNT_MIN;
		this.ballCount = BALL_COUNT_MIN;
	}

	public static Hint create() {
		return new Hint();
	}

	public void countStrike(BallNumbers problemNumbers, BallNumbers playerNumbers) {
		for (int i = 0; i < BallNumberConstant.VALID_SIZE; i++) {
			BallNumber problemNumber = problemNumbers.getBallNumber(i);
			BallNumber playerNumber = playerNumbers.getBallNumber(i);

			boolean isStrike = problemNumber.equals(playerNumber);
			increaseStrikeCount(isStrike);
		}
	}

	public void countBall(BallNumbers problemNumbers, BallNumbers playerNumbers) {
		for (int i = 0; i < BallNumberConstant.VALID_SIZE; i++) {
			BallNumber problemNumber = problemNumbers.getBallNumber(i);
			BallNumber playerNumber = playerNumbers.getBallNumber(i);

			boolean isBall = problemNumbers.contains(playerNumber) && !problemNumber.equals(playerNumber);
			increaseBallCount(isBall);
		}
	}

	public int getStrikeCount() {
		return this.strikeCount;
	}

	public int getBallCount() {
		return this.ballCount;
	}

	private void increaseStrikeCount(boolean isStrike) {
		if (isStrike) {
			this.strikeCount++;
		}
	}

	private void increaseBallCount(boolean isBall) {
		if (isBall) {
			this.ballCount++;
		}
	}
}
