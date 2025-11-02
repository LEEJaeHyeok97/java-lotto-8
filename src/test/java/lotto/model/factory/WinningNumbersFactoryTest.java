package lotto.model.factory;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersFactoryTest {

    @DisplayName("숫자가 아닌 문자가 포함된 경우 예외를 발생한다.")
    @Test
    void throwExceptionWhenInputContainsNonNumericValue() {
        // given
        String[] input = {"1", "2", "3", "a", "5", "6"};

        // when //then
        assertThrows(IllegalArgumentException.class, () -> WinningNumbersFactory.from(input));
    }

    @DisplayName("입력된 당첨 번호의 개수가 6개가 아니면 예외를 발생한다.")
    @Test
    void throwExceptionWhenWinningNumberCountIsNotSix() {
        // given
        String[] input = {"1", "2", "3", "4", "5"};

        // when //then
        assertThrows(IllegalArgumentException.class, () -> WinningNumbersFactory.from(input));
    }
}