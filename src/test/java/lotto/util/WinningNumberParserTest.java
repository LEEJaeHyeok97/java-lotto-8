package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberParserTest {

    @DisplayName("쉼표로 구분된 당첨 번호 문자열을 배열로 파싱한다.")
    @Test
    void parseValidWinningNumbers() {
        // given
        String input = "1,2,3,4,5,6";

        // when
        String[] result = WinningNumberParser.winningNumberParse(input);

        // then
        assertThat(result).containsExactly("1", "2", "3", "4", "5", "6");
    }

    @DisplayName("당첨 번호 사이에 공백이 포함되면 예외를 발생한다.")
    @Test
    void throwExceptionWhenInputContainsBlank() {
        // given
        String input = "1, 2,3,4,5,6";

        // when //then
        assertThrows(IllegalArgumentException.class, () -> WinningNumberParser.winningNumberParse(input));
    }
}