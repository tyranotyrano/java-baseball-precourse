package baseball.domain;

import baseball.constant.BallNumberConstant;

public class BallHint {
	private static final int BALL_COUNT_MIN = 0;
	private static final int BALL_COUNT_MAX = 3;

	private int ballCount;

	private BallHint() {
		this.ballCount = BALL_COUNT_MIN;
	}

	public static BallHint create() {
		return new BallHint();
	}

	public void countBall(BallNumbers problemNumbers, BallNumbers playerNumbers) {
		for (int i = 0; i < BallNumberConstant.VALID_SIZE; i++) {
			BallNumber problemNumber = problemNumbers.getBallNumber(i);
			BallNumber playerNumber = playerNumbers.getBallNumber(i);

			boolean isBall = problemNumbers.contains(playerNumber) && !problemNumber.equals(playerNumber);
			increaseBallCount(isBall);
		}
	}

	public int getBallCount() {
		return this.ballCount;
	}

	private void increaseBallCount(boolean isBall) {
		if (isBall) {
			this.ballCount++;
		}
	}
}