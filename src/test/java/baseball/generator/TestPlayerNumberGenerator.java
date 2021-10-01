package baseball.generator;

import java.util.List;

public class TestPlayerNumberGenerator implements NumberGenerator {
	private List<Integer> numbers;

	public TestPlayerNumberGenerator(List<Integer> numbers) {
		this.numbers = numbers;
	}

	@Override
	public List<Integer> generate() {
		return numbers;
	}
}
