package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.ballnumber.BallNumbers;
import baseball.generator.BallNumberGenerator;
import baseball.view.GameInputView;
import baseball.view.GamePrintView;

public class BaseBallGameController {
	private final GameInputView inputView;
	private final GamePrintView printView;

	public BaseBallGameController() {
		this.inputView = new GameInputView();
		this.printView = new GamePrintView();
	}

	public void play() {
		Computer computer = Computer.createBy(new BallNumberGenerator());
		while (computer.isPlay()) {
			runGame(computer);
			this.printView.printGameEnd();
			restartOrExitGame(computer);
		}
	}

	private void runGame(Computer computer) {
		while (!computer.isAllStrike()) {
			BallNumbers playerBallNumbers = BallNumbers.of(this.inputView.inputBallNumbers());
			computer.makeTotalHint(playerBallNumbers);
			this.printView.printHint(computer);
		}
	}

	private void restartOrExitGame(Computer computer) {
		this.printView.printRestartOrExit();
		computer.restartOrExitGame(this.inputView.inputGameState());
	}
}
