package baseball.domain;

import baseball.constant.BallNumberConstant;

public class Hint {
	private StrikeHint strikeHint;
	private BallHint ballHint;

	private Hint() {
		this.strikeHint = StrikeHint.create();
		this.ballHint = BallHint.create();
	}

	public static Hint create() {
		return new Hint();
	}
}
