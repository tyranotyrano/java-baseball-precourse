package baseballgame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallGameTest {

	private BaseBallGame baseBallGame;

	@BeforeEach
	void setUp() {
		baseBallGame = new BaseBallGame(new Validator());
	}

	@DisplayName("1~9 중 랜덤으로 숫자를 추출")
	@Test
	void drawRandomNumberFrom1to9() {
		Set<Integer> numberSet = new HashSet<>();

		while (numberSet.size() < 9) {
			numberSet.add(baseBallGame.drawRandomNumberFrom1to9());
		}

		assertThat(numberSet).contains(1, 2, 3, 4, 5, 6, 7, 8, 9)
							 .size()
							 .isEqualTo(9);
	}

	@DisplayName("스트라이크인 경우, 스트라이크 개수 증가")
	@ParameterizedTest
	@CsvSource(value = {"234:0", "214:1", "691:1", "614:2", "639:2", "619:3"}, delimiter = ':')
	void increaseCountWhenStrike(String stringNumber, int result) {
		String[] problemNumbers = {"6", "1", "9"};
		String[] answerNumbers = stringNumber.split("");

		for (int i = 0; i < problemNumbers.length; i++) {
			baseBallGame.increaseCountWhenStrike(problemNumbers[i], answerNumbers[i]);
		}

		assertThat(baseBallGame.getStrikeCount()).isEqualTo(result);
	}

	@DisplayName("볼인 경우, 볼 개수 증가")
	@ParameterizedTest
	@CsvSource(value = {"234:0", "612:0", "621:1", "392:1", "169:2", "192:2", "196:3"}, delimiter = ':')
	void increaseCountWhenBall(String stringNumber, int result) {
		String[] problemNumbers = {"6", "1", "9"};
		String[] answerNumbers = stringNumber.split("");

		for (int i = 0; i < problemNumbers.length; i++) {
			boolean isStrike = problemNumbers[i].equals(answerNumbers[i]);
			baseBallGame.increaseCountWhenBall(Arrays.asList(problemNumbers), answerNumbers[i], isStrike);
		}

		assertThat(baseBallGame.getBallCount()).isEqualTo(result);
	}

	@DisplayName("문제와 답이 맞는지 확인")
	@ParameterizedTest
	@CsvSource(value = {"234:false", "916:false", "169:false", "691:false", "619:true"}, delimiter = ':')
	void isCorrectAnswer(String stringNumber, boolean result) {
		String[] problemNumbers = {"6", "1", "9"};
		String[] answerNumbers = stringNumber.split("");

		for (int i = 0; i < problemNumbers.length; i++) {
			boolean isStrike = problemNumbers[i].equals(answerNumbers[i]);
			baseBallGame.increaseCountWhenStrike(problemNumbers[i], answerNumbers[i]);
			baseBallGame.increaseCountWhenBall(Arrays.asList(problemNumbers), answerNumbers[i], isStrike);
		}

		assertThat(baseBallGame.isCorrectAnswer()).isEqualTo(result);
	}
}
