package baseball.domain.ballnumber;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.constant.BallNumberConstant;
import baseball.domain.ballnumber.BallNumbers;
import baseball.generator.BallNumberGenerator;

class BallNumbersTest {

	@DisplayName("BallNumbers 에 들어있는 숫자의 개수는 3개 이다")
	@Test
	void validateBallNumbersCount() {
		// given
		// when
		BallNumbers ballNumbers = BallNumbers.createBy(new BallNumberGenerator());
		// then
		assertEquals(BallNumberConstant.VALID_SIZE, ballNumbers.size());
	}
}