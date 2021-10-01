package baseball.constant;

public class ErrorMessage {
	public static final String INVALID_BALL_NUMBER = String.format("%d 부터 %d 까지 숫자만 입력 가능합니다.",
																   BallNumberConstant.MIN,
																   BallNumberConstant.MAX);
	public static final String INVALID_BALL_NUMBER_SIZE = "ballNumbers 의 크기는 3개 이어야 합니다.";
}
