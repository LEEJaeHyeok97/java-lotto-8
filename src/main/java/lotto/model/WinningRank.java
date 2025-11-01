package lotto.model;

import java.util.Arrays;

public enum WinningRank {

    NONE(0, false, 0),
    FIFTH_PRIZE(3, false, 5000),
    FOURTH_PRIZE(4, false, 50000),
    THIRD_PRIZE(5, false, 1500000),
    SECOND_PRIZE(5, true, 30000000),
    FIRST_PRIZE(6, false, 2000000000);

    private final int matchCount;
    private final boolean bonusMatch;
    private final int prize;

    WinningRank(int matchCount, boolean bonusMatch, int prize) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }

    public static WinningRank findByMatchCountAndBonusMatch(int count, boolean bonusMatch) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == count)
                .filter(rank -> rank.bonusMatch == bonusMatch)
                .findFirst()
                .orElse(NONE);
    }

    public int getPrize() {
        return prize;
    }
}
