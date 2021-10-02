package baseball.domain;

import baseball.domain.ballnumber.BallNumbers;
import baseball.domain.hint.Hint;
import baseball.generator.NumberGenerator;

public class Computer {
	private final NumberGenerator numberGenerator;
	private final Hint hint;

	private BallNumbers problemBallNumbers;
	private GameStateType gameState;

	private Computer(BallNumbers ballNumbers, NumberGenerator numberGenerator) {
		this.numberGenerator = numberGenerator;
		this.hint = Hint.create();
		this.problemBallNumbers = ballNumbers;
		this.gameState = GameStateType.PLAY;
	}

	public static Computer createBy(NumberGenerator numberGenerator) {
		BallNumbers problemBallNumbers = BallNumbers.createBy(numberGenerator);
		return new Computer(problemBallNumbers, numberGenerator);
	}

	public void makeTotalHint(BallNumbers playerBallNumbers) {
		this.hint.init();
		this.hint.makeTotalHint(this.problemBallNumbers, playerBallNumbers);
	}

	public void restartOrExitGame(GameStateType gameState) {
		if (gameState.isPlay()) {
			init();
		}
		this.gameState = gameState;
	}

	public boolean isPlay() {
		return this.gameState.isPlay();
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

	private void init() {
		this.problemBallNumbers = BallNumbers.createBy(this.numberGenerator);
		this.hint.init();
	}
}
