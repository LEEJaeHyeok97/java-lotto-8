package lotto.model;

import java.util.List;

public class WinningRankCalculator {

    private final List<WinningRank> values;

    public WinningRankCalculator(List<WinningRank> values) {
        this.values = values;
    }

    public int calculateSum() {
        return values.stream()
                .mapToInt(WinningRank::getPrize)
                .sum();
    }

    public int countByRank(WinningRank rank) {
        return (int) values.stream()
                .filter(value -> value == rank)
                .count();
    }
}
