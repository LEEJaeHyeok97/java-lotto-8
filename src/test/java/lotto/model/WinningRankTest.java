package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningRankTest {

    public static final int MATCH_COUNT = 5;
    public static final boolean BONUS_MATCH = true;

    @DisplayName("일치 개수와 보너스 일치 여부에 따라 해당 등수를 반환한다.")
    @Test
    void findWinningRankByMatchCountAndBonusMatch() {
        //given
        int matchCount = MATCH_COUNT;
        boolean bonusMatch = BONUS_MATCH;

        //when
        WinningRank winningRank = WinningRank.findByMatchCountAndBonusMatch(matchCount, bonusMatch);

        //then
        assertThat(winningRank).isEqualTo(WinningRank.SECOND_PRIZE);
    }

    @DisplayName("일치 개수와 보너스 번호 조건이 어떤 등수에도 해당하지 않으면 NONE을 반환한다.")
    @Test
    void returnNoneWhenNoMatchingRank() {
        //given
        int matchCount = 0;
        boolean bonusMatch = BONUS_MATCH;

        //when
        WinningRank winningRank = WinningRank.findByMatchCountAndBonusMatch(matchCount, bonusMatch);

        //then
        assertThat(winningRank).isEqualTo(WinningRank.NONE);
    }
}