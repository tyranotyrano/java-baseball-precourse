package baseball.generator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import baseball.constant.BallNumberConstant;

class BallNumberGeneratorTest {

	@DisplayName("랜덤하게 생성된 숫자의 개수는 항상 3개이다")
	@Test
	void validateSizeOfBallNumbers() {
		// given
		BallNumberGenerator ballNumberGenerator = new BallNumberGenerator();
		// when
		List<Integer> numbers = ballNumberGenerator.generate();
		// then
		assertEquals(numbers.size(), BallNumberConstant.VALID_SIZE);
	}

	@DisplayName("랜덤하게 생성된 숫자는 서로 중복되지 않는다")
	@Test
	void validateDuplicatedBallNumbers() {
		// given
		BallNumberGenerator ballNumberGenerator = new BallNumberGenerator();
		// when
		List<Integer> numbers = ballNumberGenerator.generate();
		Set<Integer> numberSet = new LinkedHashSet<>(numbers);
		// then
		assertEquals(numbers.size(), BallNumberConstant.VALID_SIZE);
		assertEquals(numberSet.size(), BallNumberConstant.VALID_SIZE);
		assertEquals(numbers.size(), numberSet.size());
	}
}