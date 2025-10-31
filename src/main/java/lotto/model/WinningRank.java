package lotto.model;

public enum WinningRank {

    FIFTH_PRIZE(3, false, 5000),
    FOURTH_PRIZE(4, false, 50000),
    THIRD_PRIZE(5, false, 1500000),
    SECOND_PRIZE(5, true, 30000000),
    FIRST_PRIZE(6, false, 2000000000);

    private int matchCount;
    private boolean bonusMatch;
    private int prize;

    WinningRank(int matchCount, boolean bonusMatch, int prize) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
        this.prize = prize;
    }
}
