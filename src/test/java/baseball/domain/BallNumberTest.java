package baseball.domain;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import baseball.constant.ErrorMessage;

class BallNumberTest {

	@DisplayName("1~9 사이의 숫자로 BallNumber 를 생성할 수 있다.")
	@ParameterizedTest
	@ValueSource(ints = {1, 5, 9})
	void createBallNumberBy_1_to_9(int number) {
		// given : number
		// when
		BallNumber ballNumber = BallNumber.of(number);
		// then
		assertEquals(number, ballNumber.getNumber());
	}

	@DisplayName("1~9 를 벗어나는 숫자로 BallNumber 를 생성하면 예외가 발생한다.")
	@ParameterizedTest
	@ValueSource(ints = {-1, 0, 10})
	void throwExceptionWhenBallNumberNotValid(int number) {
		// given : number
		// when
		// then
		assertThatIllegalArgumentException()
			.isThrownBy(() -> BallNumber.of(number))
			.withMessageMatching(ErrorMessage.INVALID_BALL_NUMBER);
	}
}