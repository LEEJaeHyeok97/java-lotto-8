package lotto.model.factory;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.model.LottoResult;
import lotto.model.Lottos;
import lotto.model.WinningInfo;
import lotto.model.WinningNumbers;
import lotto.model.WinningRank;
import lotto.model.vo.BonusNumber;
import lotto.model.vo.Lotto;
import lotto.model.vo.PurchaseAmount;
import lotto.model.vo.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoResultFactoryTest {

    @DisplayName("여러 개의 로또와 당첨 정보를 입력하면 LottoResult 객체를 생성한다.")
    @Test
    void createLottoResultFromLottosAndWinningInfo() {
        // given
        Lottos lottos = Lottos.of(List.of(
                Lotto.of(List.of(1, 2, 3, 4, 5, 6)),
                Lotto.of(List.of(1, 2, 3, 4, 5, 7)),
                Lotto.of(List.of(1, 2, 3, 4, 9, 10)),
                Lotto.of(List.of(7, 8, 9, 10, 11, 12))
        ));

        WinningNumbers winningNumbers = WinningNumbers.of(List.of(
                WinningNumber.of(1),
                WinningNumber.of(2),
                WinningNumber.of(3),
                WinningNumber.of(4),
                WinningNumber.of(5),
                WinningNumber.of(6)
        ));
        BonusNumber bonusNumber = BonusNumber.of(7);
        WinningInfo winningInfo = WinningInfo.of(winningNumbers, bonusNumber);
        PurchaseAmount purchaseAmount = PurchaseAmount.of(4000);

        // when
        LottoResult lottoResult = LottoResultFactory.create(lottos, winningInfo, purchaseAmount);

        // then
        assertThat(lottoResult.countByRank(WinningRank.FIRST_PRIZE)).isEqualTo(1);
        assertThat(lottoResult.countByRank(WinningRank.SECOND_PRIZE)).isEqualTo(1);
        assertThat(lottoResult.countByRank(WinningRank.FOURTH_PRIZE)).isEqualTo(1);
        assertThat(lottoResult.countByRank(WinningRank.NONE)).isEqualTo(1);
    }
}