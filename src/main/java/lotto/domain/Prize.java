package lotto.domain;

import java.util.Arrays;

public enum Prize {
	FIRST(6, false, 2_000_000_000),
	SECOND(5, true, 30_000_000),
	THIRD(5, false, 1_500_000),
	FOURTH(4, false, 50_000),
	FIFTH(3, false, 5_000),
	NONE(0, false, 0);

	private final int matchCount;
	private final boolean matchBonus;
	private final int prizeAmount;

	Prize(int matchCount, boolean matchBonus, int prizeAmount) {
		this.matchCount = matchCount;
		this.matchBonus = matchBonus;
		this.prizeAmount = prizeAmount;
	}

	public int getPrizeAmount() {
		return prizeAmount;
	}

	public static Prize findPrize(int matchCount, boolean matchBonus) {
		return Arrays.stream(values())
			.filter(prize -> prize.matchCount == matchCount && prize.matchBonus == matchBonus)
			.findFirst()
			.orElse(NONE);
	}
}
