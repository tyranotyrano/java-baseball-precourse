package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.generator.TestPlayerNumberGenerator;
import baseball.generator.TestProblemNumberGenerator;

public class BallHintTest {

	@DisplayName("볼인 경우, 볼 개수 증가한다")
	@ParameterizedTest
	@CsvSource(value = {"4:5:6:0", "4:5:1:1", "3:4:6:1", "3:5:1:2", "2:3:6:2", "2:3:1:3"}, delimiter = ':')
	void increaseCountWhenBall(int firstNumber, int secondNumber, int thirdNumber, int ballCount) {
		// given
		BallNumbers problemBallNumbers = BallNumbers.createBy(new TestProblemNumberGenerator());
		BallNumbers playerBallNumbers = BallNumbers.createBy(
			new TestPlayerNumberGenerator(Arrays.asList(firstNumber, secondNumber, thirdNumber)));
		// when
		BallHint ballHint = BallHint.create();
		ballHint.countBall(problemBallNumbers, playerBallNumbers);
		// then
		assertEquals(ballHint.getBallCount(), ballCount);
	}
}
