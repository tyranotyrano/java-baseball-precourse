package baseball.domain.hint;

import baseball.constant.BallNumberConstant;
import baseball.domain.ballnumber.BallNumber;
import baseball.domain.ballnumber.BallNumbers;

public class StrikeHint {
	private static final int STRIKE_COUNT_MIN = 0;
	private static final int STRIKE_COUNT_MAX = 3;

	private int strikeCount;

	private StrikeHint() {
		this.strikeCount = STRIKE_COUNT_MIN;
	}

	public static StrikeHint create() {
		return new StrikeHint();
	}

	public void countStrike(BallNumbers problemNumbers, BallNumbers playerNumbers) {
		for (int i = 0; i < BallNumberConstant.VALID_SIZE; i++) {
			BallNumber problemNumber = problemNumbers.getBallNumber(i);
			BallNumber playerNumber = playerNumbers.getBallNumber(i);

			boolean isStrike = problemNumber.equals(playerNumber);
			increaseStrikeCount(isStrike);
		}
	}

	public int getStrikeCount() {
		return this.strikeCount;
	}

	private void increaseStrikeCount(boolean isStrike) {
		if (isStrike) {
			this.strikeCount++;
		}
	}
}
