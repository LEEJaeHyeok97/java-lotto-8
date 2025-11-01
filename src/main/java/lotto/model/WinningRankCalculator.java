package lotto.model;

import java.util.List;

public class WinningRankCalculator {

    private final List<WinningRank> values;

    public WinningRankCalculator(List<WinningRank> values) {
        this.values = values;
    }

    public int countFifthPrize() {
        return (int) values.stream()
                .filter(value -> value == WinningRank.FIFTH_PRIZE)
                .count();
    }

    public int countFourthPrize() {
        return (int) values.stream()
                .filter(value -> value == WinningRank.FOURTH_PRIZE)
                .count();
    }

    public int countThirdPrize() {
        return (int) values.stream()
                .filter(value -> value == WinningRank.THIRD_PRIZE)
                .count();
    }

    public int countSecondPrize() {
        return (int) values.stream()
                .filter(value -> value == WinningRank.SECOND_PRIZE)
                .count();
    }

    public int countFirstPrize() {
        return (int) values.stream()
                .filter(value -> value == WinningRank.FIRST_PRIZE)
                .count();
    }
}
