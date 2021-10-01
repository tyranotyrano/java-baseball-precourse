package baseball.domain.hint;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.domain.ballnumber.BallNumbers;
import baseball.domain.hint.StrikeHint;
import baseball.generator.TestPlayerNumberGenerator;
import baseball.generator.TestProblemNumberGenerator;

public class StrikeHintTest {

	@DisplayName("스트라이크인 경우, 스트라이크 개수 증가한다")
	@ParameterizedTest
	@CsvSource(value = {"4:5:6:0", "1:5:6:1", "4:2:6:1", "1:2:6:2", "4:2:3:2", "1:2:3:3"}, delimiter = ':')
	void increaseCountWhenStrike(int firstNumber, int secondNumber, int thirdNumber, int strikeCount) {
		// given
		BallNumbers problemBallNumbers = BallNumbers.createBy(new TestProblemNumberGenerator());
		BallNumbers playerBallNumbers = BallNumbers.createBy(
			new TestPlayerNumberGenerator(Arrays.asList(firstNumber, secondNumber, thirdNumber)));
		// when
		StrikeHint strikeHint = StrikeHint.create();
		strikeHint.countStrike(problemBallNumbers, playerBallNumbers);
		// then
		assertEquals(strikeHint.getStrikeCount(), strikeCount);
	}
}
