package baseball.domain.hint;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.domain.ballnumber.BallNumbers;
import baseball.generator.TestPlayerNumberGenerator;
import baseball.generator.TestProblemNumberGenerator;

class HintTest {

	@DisplayName("스트라이크, 볼을 종합하여 판단한다")
	@ParameterizedTest
	@CsvSource(value = {"4:5:6:0:0", "1:2:3:3:0", "3:1:2:0:3", "1:3:6:1:1", "1:2:6:2:0"}, delimiter = ':')
	void countTotalStrikeAndBall(int firstNumber, int secondNumber, int thirdNumber, int strikeCount, int ballCount) {
		// given
		BallNumbers problemBallNumbers = BallNumbers.createBy(new TestProblemNumberGenerator());
		BallNumbers playerBallNumbers = BallNumbers.createBy(
			new TestPlayerNumberGenerator(Arrays.asList(firstNumber, secondNumber, thirdNumber)));
		// when
		Hint hint = Hint.create();
		hint.countTotalHint(problemBallNumbers, playerBallNumbers);
		// then
		assertEquals(hint.getStrikeCount(), strikeCount);
		assertEquals(hint.getBallCount(), ballCount);
	}

	@DisplayName("숫자 3개가 값, 위치 모두 일치하는 경우에만 3개 모두 스트라이크다")
	@ParameterizedTest
	@CsvSource(value = {"1:2:3:true", "4:5:6:false", "1:2:6:false", "1:3:6:false"}, delimiter = ':')
	void checkAllStrike(int firstNumber, int secondNumber, int thirdNumber, boolean isAllStrike) {
		// given
		BallNumbers problemBallNumbers = BallNumbers.createBy(new TestProblemNumberGenerator());
		BallNumbers playerBallNumbers = BallNumbers.createBy(
			new TestPlayerNumberGenerator(Arrays.asList(firstNumber, secondNumber, thirdNumber)));
		// when
		Hint hint = Hint.create();
		hint.countTotalHint(problemBallNumbers, playerBallNumbers);
		// then
		assertEquals(hint.isAllStrike(), isAllStrike);
	}

	@DisplayName("숫자 3개가 모두 다르면 낫싱이다")
	@ParameterizedTest
	@CsvSource(value = {"4:5:6:true", "1:2:3:false", "1:2:6:false", "1:3:6:false"}, delimiter = ':')
	void checkNothing(int firstNumber, int secondNumber, int thirdNumber, boolean isNothing) {
		// given
		BallNumbers problemBallNumbers = BallNumbers.createBy(new TestProblemNumberGenerator());
		BallNumbers playerBallNumbers = BallNumbers.createBy(
			new TestPlayerNumberGenerator(Arrays.asList(firstNumber, secondNumber, thirdNumber)));
		// when
		Hint hint = Hint.create();
		hint.countTotalHint(problemBallNumbers, playerBallNumbers);
		// then
		assertEquals(hint.isNothing(), isNothing);
	}
}