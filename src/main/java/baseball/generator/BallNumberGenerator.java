package baseball.generator;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import baseball.constant.BallNumberConstant;
import nextstep.utils.Randoms;

public class BallNumberGenerator implements NumberGenerator {

	@Override
	public List<Integer> generate() {
		Set<Integer> ballNumbers = new LinkedHashSet<>();
		while (ballNumbers.size() < BallNumberConstant.VALID_SIZE) {
			ballNumbers.add(Randoms.pickNumberInRange(BallNumberConstant.MIN, BallNumberConstant.MAX));
		}

		return new ArrayList<>(ballNumbers);
	}
}
