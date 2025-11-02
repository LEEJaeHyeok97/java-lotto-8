package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningRankCalculatorTest {

    public static final List<WinningRank> RANKS = List.of(WinningRank.FIRST_PRIZE, WinningRank.FIFTH_PRIZE,
            WinningRank.THIRD_PRIZE);

    @DisplayName("모든 당첨 등수의 상금을 합산한다.")
    @Test
    void calculateTotalPrizeSum() {
        //given
        List<WinningRank> winningRanks = RANKS;
        WinningRankCalculator calculator = WinningRankCalculator.of(winningRanks);
        int totalPrize = WinningRank.FIRST_PRIZE.getPrize() + WinningRank.FIFTH_PRIZE.getPrize()
                + WinningRank.THIRD_PRIZE.getPrize();

        //when
        int calculatedSum = calculator.calculateSum();

        //then
        assertThat(calculatedSum).isEqualTo(totalPrize);
    }

    @DisplayName("특정 당첨 등수의 개수를 계산한다.")
    @Test
    void countRanksByGivenWinningRank() {
        //given
        List<WinningRank> winningRanks = RANKS;
        WinningRankCalculator calculator = WinningRankCalculator.of(winningRanks);

        //when
        int countByRank = calculator.countByRank(WinningRank.FIRST_PRIZE);

        //then
        assertThat(countByRank).isEqualTo(1);
    }
}