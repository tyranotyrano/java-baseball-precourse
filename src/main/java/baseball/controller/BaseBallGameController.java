package baseball.controller;

import java.util.List;

import baseball.domain.Computer;
import baseball.domain.ballnumber.BallNumbers;
import baseball.generator.BallNumberGenerator;
import baseball.view.BallNumberInputView;

public class BaseBallGameController {
	private final BallNumberInputView inputView;

	public BaseBallGameController() {
		this.inputView = new BallNumberInputView();
	}

	public void play() {
		Computer computer = Computer.createBy(new BallNumberGenerator());
		while (!computer.isAllStrike()) {
			List<Integer> numbers = this.inputView.inputBallNumbers();
			BallNumbers playerBallNumbers = BallNumbers.of(numbers);
			computer.makeTotalHint(playerBallNumbers);
		}
	}
}
