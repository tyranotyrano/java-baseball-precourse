package baseball.constant;

public class ErrorMessage {
	public static final String INVALID_BALL_NUMBER = String.format("[ERROR] %d 부터 %d 까지 숫자만 입력 가능합니다.",
																   BallNumberConstant.MIN,
																   BallNumberConstant.MAX);
	public static final String INVALID_BALL_NUMBER_SIZE = "[ERROR] ballNumbers 의 크기는 3개 이어야 합니다.";
	public static final String INVALID_HINT_TOTAL_COUNT = "[ERROR] Strike 와 Ball 의 총 개수는 0 ~ 3개 이어야 합니다.";
	public static final String INVALID_INPUT_NUMBER = "[ERROR] 1~9 로 구성된 서로 다른 3개의 숫자를 입력해주세요.";
	public static final String INVALID_GAME_STATE = "[ERROR] 새로운 게임은 1, 게임종료는 2 를 입력해주세요.";
}
