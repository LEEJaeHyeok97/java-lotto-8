package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.vo.PurchaseAmount;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultTest {

    public static final List<WinningRank> RANKS = List.of(WinningRank.FIFTH_PRIZE);

    @DisplayName("수익률을 소수점 첫째 자리에서 반올림하여 계산한다.")
    @Test
    void calculateProfitRateShouldRoundToOneDecimalPlace() {
        // given
        WinningRankCalculator calculator = WinningRankCalculator.of(RANKS);

        PurchaseAmount purchaseAmount = PurchaseAmount.of(8000);
        LottoResult lottoResult = LottoResult.of(calculator, purchaseAmount);

        // when
        double profitRate = lottoResult.calculateProfitRate();

        // then
        assertThat(profitRate).isEqualTo(62.5);
    }
}