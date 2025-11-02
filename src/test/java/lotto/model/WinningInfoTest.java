package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.model.vo.BonusNumber;
import lotto.model.vo.Lotto;
import lotto.model.vo.WinningNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningInfoTest {

    public static final WinningNumbers WINNING_NUMBERS = WinningNumbers.of(List.of(
            WinningNumber.of(1),
            WinningNumber.of(2),
            WinningNumber.of(3),
            WinningNumber.of(4),
            WinningNumber.of(5),
            WinningNumber.of(6)
    ));

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외를 발생한다.")
    @Test
    void throwExceptionWhenBonusNumberIsDuplicatedWithWinningNumbers() {
        // given
        WinningNumbers winningNumbers = WINNING_NUMBERS;
        BonusNumber duplicatedBonus = BonusNumber.of(6);

        // when //then
        assertThrows(IllegalArgumentException.class, () -> WinningInfo.of(winningNumbers, duplicatedBonus));
    }

    @DisplayName("로또가 당첨 번호 3개를 맞췄을 때 일치 개수는 3이다.")
    @Test
    void countMatchReturnsCorrectCount() {
        // given
        WinningNumbers winningNumbers = WINNING_NUMBERS;
        BonusNumber bonus = BonusNumber.of(7);
        WinningInfo info = WinningInfo.of(winningNumbers, bonus);

        Lotto lotto = Lotto.of(List.of(1, 2, 3, 10, 20, 30));

        // when
        int matchCount = info.countMatch(lotto);

        // then
        assertThat(matchCount).isEqualTo(3);
    }

    @DisplayName("로또가 보너스 번호를 포함하면 true를 반환한다.")
    @Test
    void isBonusMatchedReturnsTrueWhenBonusNumberIncluded() {
        // given
        WinningNumbers winningNumbers = WINNING_NUMBERS;
        BonusNumber bonus = BonusNumber.of(7);
        WinningInfo info = WinningInfo.of(winningNumbers, bonus);

        Lotto lotto = Lotto.of(List.of(7, 8, 9, 10, 11, 12));

        // when
        boolean result = info.isBonusMatched(lotto);

        // then
        assertThat(result).isTrue();
    }

    @DisplayName("로또가 5개 번호와 보너스 번호를 맞추면 2등을 반환한다.")
    @Test
    void judgeRankReturnsSecondPrizeWhenFiveAndBonusMatched() {
        // given
        WinningNumbers winningNumbers = WINNING_NUMBERS;
        BonusNumber bonus = BonusNumber.of(7);
        WinningInfo info = WinningInfo.of(winningNumbers, bonus);

        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 7));

        // when
        WinningRank rank = info.judgeRank(lotto);

        // then
        assertThat(rank).isEqualTo(WinningRank.SECOND_PRIZE);
    }
}