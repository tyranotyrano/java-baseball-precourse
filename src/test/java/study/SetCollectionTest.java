package study;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class SetCollectionTest {

	private Set<Integer> numbers;

	@BeforeEach
	void setUp() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}

	@DisplayName("size() 를 이용해서 크기를 확인한다.")
	@Test
	void size_이용해서_크기를_확인한다() {
		assertThat(numbers.size()).isEqualTo(3);
	}

	@DisplayName("contains 를 이용하여 값이 존재하는지 확인한다")
	@ParameterizedTest
	@ValueSource(ints = {1, 2, 3})
	void contains_이용하여_값_존재하는지_확인한다(int value) {
		assertThat(numbers.contains(value)).isTrue();
	}

	@DisplayName("입력값에 따라 결과 기대값을 반환한다.")
	@ParameterizedTest
	@CsvSource(value = {"1:true", "2:true", "3:true", "4:false", "5:false"}, delimiter = ':')
	void 입력값에_따라_결과_기대값을_반환한다(Integer value, boolean result) {
		assertThat(numbers.contains(value)).isEqualTo(result);
	}
}
