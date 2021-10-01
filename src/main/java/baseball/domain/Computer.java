package baseball.domain;

import baseball.domain.ballnumber.BallNumbers;
import baseball.domain.hint.Hint;
import baseball.generator.NumberGenerator;

public class Computer {
	private final BallNumbers problemBallNumbers;
	private final Hint hint;

	private Computer(BallNumbers ballNumbers) {
		this.problemBallNumbers = ballNumbers;
		this.hint = Hint.create();
	}

	public static Computer createBy(NumberGenerator numberGenerator) {
		BallNumbers problemBallNumbers = BallNumbers.createBy(numberGenerator);
		return new Computer(problemBallNumbers);
	}

	public void makeTotalHint(BallNumbers playerBallNumbers) {
		this.hint.init();
		this.hint.makeTotalHint(this.problemBallNumbers, playerBallNumbers);
	}

	public boolean isAllStrike() {
		return this.hint.isAllStrike();
	}

	public boolean isNothing() {
		return this.hint.isNothing();
	}

	public boolean hasStrike() {
		return this.hint.hasStrike();
	}

	public boolean hasBall() {
		return this.hint.hasBall();
	}

	public int getStrikeCount() {
		return this.hint.getStrikeCount();
	}

	public int getBallCount() {
		return this.hint.getBallCount();
	}
}
