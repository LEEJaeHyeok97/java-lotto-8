package lotto.model;

import java.util.List;

public class WinningRankCalculator {

    private final List<WinningRank> ranks;

    public WinningRankCalculator(List<WinningRank> ranks) {
        this.ranks = ranks;
    }

    public int calculateSum() {
        return ranks.stream()
                .mapToInt(WinningRank::getPrize)
                .sum();
    }

    public int countByRank(WinningRank winningRank) {
        return (int) ranks.stream()
                .filter(rank -> rank == winningRank)
                .count();
    }
}
