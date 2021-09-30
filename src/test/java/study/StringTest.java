package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@DisplayName("split() 을 이용하여 문자열 분리한다.")
	@Test
	void split_이용하여_문자열_분리한다() {
		// given
		String str1 = "1,2";

		// when
		String[] splitValues1 = str1.split(",");

		// then
		assertThat(splitValues1).containsExactly("1", "2");
	}

	@DisplayName("split() 을 이용하여 문자열 분리 후 배열로 반환한다.")
	@Test
	void split_이용하여_문자열_분리_후_배열로_반환한다() {
		// given
		String str2 = "1";

		// when
		String[] splitValues2 = str2.split(",");

		// then
		assertThat(splitValues2).containsExactly("1");
	}

	@DisplayName("substring() 을 이용하여 문자열에 있는 소괄호를 제거한다.")
	@Test
	void substring_이용하여_문자열에_있는_소괄호를_제거한다() {
		// given
		String str = "(1,2)";

		// when
		String substringStr = str.substring(1, str.length() - 1);

		// then
		assertThat(substringStr).isEqualTo("1,2");
	}

	@DisplayName("charAt() 으로 특정 위치의 문자를 가져온다.")
	@Test
	void charAt_으로_특정_위치의_문자를_가져온다() {
		// given
		String str = "abc";

		// when
		// then
		assertThat(str.charAt(0)).isEqualTo('a');
		assertThat(str.charAt(1)).isEqualTo('b');
		assertThat(str.charAt(2)).isEqualTo('c');
	}

	@DisplayName("charAt() 으로 특정 위치의 문자를 가져올 때, 위치 값을 벗어나면 예외가 발생한다.")
	@Test
	void charAt_으로_특정_위치의_문자를_가져올_때_위치값을_벗어나면_예외가_발생한다() {
		// given
		String str = "abc";

		// when
		// then
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> {
				char c = str.charAt(str.length());
			})
			.withMessageMatching("String index out of range: " + str.length());
	}
}
