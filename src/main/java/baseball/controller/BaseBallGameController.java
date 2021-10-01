package baseball.controller;

import java.util.List;

import baseball.domain.Computer;
import baseball.domain.ballnumber.BallNumbers;
import baseball.generator.BallNumberGenerator;
import baseball.view.BallNumberInputView;
import baseball.view.HintView;

public class BaseBallGameController {
	private final BallNumberInputView inputView;
	private final HintView hintView;

	public BaseBallGameController() {
		this.inputView = new BallNumberInputView();
		this.hintView = new HintView();
	}

	public void play() {
		Computer computer = Computer.createBy(new BallNumberGenerator());
		while (!computer.isAllStrike()) {
			BallNumbers playerBallNumbers = BallNumbers.of(this.inputView.inputBallNumbers());
			computer.makeTotalHint(playerBallNumbers);
			this.hintView.printHint(computer);
		}
	}
}
