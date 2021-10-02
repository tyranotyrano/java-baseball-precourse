package baseball.view;

import baseball.domain.Computer;

public class GamePrintView {
	private static final String HINT_NOTHING_MESSAGE = "낫싱";
	private static final String HINT_STRIKE_MESSAGE = "%s스트라이크 ";
	private static final String HINT_BALL_MESSAGE = "%s볼";
	private static final String GAME_END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
	private static final String GAME_STATE_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

	public void printHint(Computer computer) {
		if (computer.hasStrike()) {
			System.out.printf(HINT_STRIKE_MESSAGE, computer.getStrikeCount());
		}
		if (computer.hasBall()) {
			System.out.printf(HINT_BALL_MESSAGE, computer.getBallCount());
		}

		System.out.println(computer.isNothing() ? HINT_NOTHING_MESSAGE : "");
	}

	public void printGameEnd() {
		System.out.println(GAME_END_MESSAGE);
	}

	public void printRestartOrExit() {
		System.out.println(GAME_STATE_MESSAGE);
	}
}
