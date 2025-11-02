package lotto.model.factory;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberFactoryTest {

    @DisplayName("숫자가 아닌 문자를 입력하면 예외를 발생한다.")
    @Test
    void throwExceptionWhenInputIsNonNumeric() {
        // given
        String input = "abc";

        // when //then
        assertThrows(IllegalArgumentException.class, () -> BonusNumberFactory.from(input));
    }

    @DisplayName("숫자와 문자가 섞인 입력값이면 예외를 발생한다.")
    @Test
    void throwExceptionWhenInputContainsMixedCharacters() {
        // given
        String input = "7a";

        // when //then
        assertThrows(IllegalArgumentException.class, () -> BonusNumberFactory.from(input));
    }
}