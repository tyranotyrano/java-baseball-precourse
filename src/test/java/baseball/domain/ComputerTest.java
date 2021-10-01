package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import baseball.domain.ballnumber.BallNumbers;
import baseball.generator.TestPlayerNumberGenerator;
import baseball.generator.TestProblemNumberGenerator;

class ComputerTest {

	@DisplayName("컴퓨터와 플레이어의 숫자를 비교하여 3 스트라이크이면 정답이다")
	@ParameterizedTest
	@CsvSource(value = {"1:2:3:true", "4:5:6:false", "1:2:6:false", "1:3:6:false"}, delimiter = ':')
	void checkIsCorrectWhenHintIsAllStrike(int firstNumber, int secondNumber, int thirdNumber, boolean isAllStrike) {
		// given
		Computer computer = Computer.createBy(new TestProblemNumberGenerator());
		BallNumbers playerBallNumbers = BallNumbers.createBy(
			new TestPlayerNumberGenerator(Arrays.asList(firstNumber, secondNumber, thirdNumber)));
		// when
		computer.makeTotalHint(playerBallNumbers);
		// then
		assertEquals(computer.isAllStrike(), isAllStrike);
	}
}