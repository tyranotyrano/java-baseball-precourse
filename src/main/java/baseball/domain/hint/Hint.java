package baseball.domain.hint;

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
