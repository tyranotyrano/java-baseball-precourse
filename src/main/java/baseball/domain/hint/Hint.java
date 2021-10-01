package baseball.domain.hint;

import static baseball.constant.ErrorMessage.*;

import baseball.domain.ballnumber.BallNumbers;

public class Hint {
	private static final int HINT_TOTAL_COUNT_MIN = 0;
	private static final int HINT_TOTAL_COUNT_MAX = 3;

	private final StrikeHint strikeHint;
	private final BallHint ballHint;

	private Hint() {
		this.strikeHint = StrikeHint.create();
		this.ballHint = BallHint.create();
	}

	public static Hint create() {
		return new Hint();
	}

	public boolean isAllStrike() {
		return this.strikeHint.isAllStrike() && !this.ballHint.hasBall();
	}

	public void makeTotalHint(BallNumbers problemBallNumbers, BallNumbers playerBallNumbers) {
		this.strikeHint.countStrike(problemBallNumbers, playerBallNumbers);
		this.ballHint.countBall(problemBallNumbers, playerBallNumbers);
		validateTotalHint();
	}

	public boolean isNothing() {
		return !this.strikeHint.hasStrike() && !this.ballHint.hasBall();
	}

	public int getStrikeCount() {
		return this.strikeHint.getStrikeCount();
	}

	public int getBallCount() {
		return this.ballHint.getBallCount();
	}

	private void validateTotalHint() {
		int totalHintCount = this.getStrikeCount() + this.getBallCount();
		if (totalHintCount < HINT_TOTAL_COUNT_MIN || HINT_TOTAL_COUNT_MAX < totalHintCount) {
			throw new IllegalStateException(INVALID_HINT_TOTAL_COUNT);
		}
	}
}
