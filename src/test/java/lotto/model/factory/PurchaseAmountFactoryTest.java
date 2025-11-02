package lotto.model.factory;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountFactoryTest {

    @DisplayName("빈 문자열을 입력하면 예외를 발생한다.")
    @Test
    void throwExceptionWhenInputIsEmpty() {
        // given
        String input = "";

        // when //then
        assertThrows(IllegalArgumentException.class, () -> PurchaseAmountFactory.from(input));
    }

    @DisplayName("공백 문자열만 입력하면 예외를 발생한다.")
    @Test
    void throwExceptionWhenInputIsBlank() {
        // given
        String input = "   ";

        // when //then
        assertThrows(IllegalArgumentException.class, () -> PurchaseAmountFactory.from(input));
    }

    @DisplayName("숫자가 아닌 문자를 포함하면 예외를 발생한다.")
    @Test
    void throwExceptionWhenInputContainsNonNumericCharacters() {
        // given
        String input = "12a0";

        // when //then
        assertThrows(IllegalArgumentException.class, () -> PurchaseAmountFactory.from(input));
    }
}