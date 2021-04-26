package baseballgame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BaseBallGameTest {

	@DisplayName("1~9 중 랜덤으로 숫자를 추출")
	@Test
	void drawRandomNumberFrom1to9() {
		Set<Integer> numberSet = new HashSet<>();
		BaseBallGame baseBallGame = new BaseBallGame();

		while (numberSet.size() < 9) {
			numberSet.add(baseBallGame.drawRandomNumberFrom1to9());
		}

		assertThat(numberSet).contains(1, 2, 3, 4, 5, 6, 7, 8, 9)
							 .size()
							 .isEqualTo(9);
	}

	@DisplayName("1~9 로 이루어진 서로 다른 3자리수 유효성 체크")
	@ParameterizedTest
	@CsvSource(value = {"'':false", "012:false", "a23:false", "122:false", "1123:false", "3456:false", "123:true"}, delimiter = ':')
	void validateStringNumbers(String value, boolean result) {
		String[] stringNumbers = value.split("");
		BaseBallGame baseBallGame = new BaseBallGame();
		boolean validateResult = baseBallGame.validateStringNumbers(stringNumbers);

		assertThat(validateResult).isEqualTo(result);
	}
}
