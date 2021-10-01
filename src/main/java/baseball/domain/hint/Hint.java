package baseball.domain.hint;

import baseball.domain.ballnumber.BallNumbers;

public class Hint {
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

	public void countTotalHint(BallNumbers problemBallNumbers, BallNumbers playerBallNumbers) {
		this.strikeHint.countStrike(problemBallNumbers, playerBallNumbers);
		this.ballHint.countBall(problemBallNumbers, playerBallNumbers);
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
}
