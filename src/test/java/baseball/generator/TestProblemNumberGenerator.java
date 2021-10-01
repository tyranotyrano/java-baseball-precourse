package baseball.generator;

import java.util.Arrays;
import java.util.List;

public class TestProblemNumberGenerator implements NumberGenerator {

	@Override
	public List<Integer> generate() {
		return Arrays.asList(1, 2, 3);
	}
}
