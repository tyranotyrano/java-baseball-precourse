package baseball.view;

import baseball.domain.Computer;

public class HintView {
	private static final String HINT_NOTHING_MESSAGE = "낫싱";
	private static final String HINT_STRIKE_MESSAGE = "%s 스트라이크 ";
	private static final String HINT_BALL_MESSAGE = "%s 볼";

	public void printHint(Computer computer) {
		if (computer.hasStrike()) {
			System.out.printf(HINT_STRIKE_MESSAGE, computer.getStrikeCount());
		}
		if (computer.hasBall()) {
			System.out.printf(HINT_BALL_MESSAGE, computer.getBallCount());
		}

		System.out.println(computer.isNothing() ? HINT_NOTHING_MESSAGE : "");
	}
}
