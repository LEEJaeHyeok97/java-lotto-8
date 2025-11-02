package lotto.model;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import lotto.model.vo.WinningNumber;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    public static final List<WinningNumber> WINNING_NUMBERS = List.of(
            WinningNumber.of(1),
            WinningNumber.of(2),
            WinningNumber.of(3),
            WinningNumber.of(4),
            WinningNumber.of(5)
    );
    public static final List<WinningNumber> DUPLICATED_NUMBERS = List.of(
            WinningNumber.of(1),
            WinningNumber.of(2),
            WinningNumber.of(3),
            WinningNumber.of(4),
            WinningNumber.of(5),
            WinningNumber.of(5)
    );
    public static final List<WinningNumber> VALID_NUMBERS = List.of(
            WinningNumber.of(1),
            WinningNumber.of(2),
            WinningNumber.of(3),
            WinningNumber.of(4),
            WinningNumber.of(5),
            WinningNumber.of(6)
    );

    @DisplayName("당첨 번호가 6개가 아니면 예외를 발생한다.")
    @Test
    void throwExceptionWhenWinningNumberCountIsNotSix() {
        // given
        List<WinningNumber> invalidCountNumbers = WINNING_NUMBERS;

        // when //then
        assertThrows(IllegalArgumentException.class, () -> WinningNumbers.of(invalidCountNumbers));
    }

    @DisplayName("중복된 당첨 번호가 존재하면 예외를 발생한다.")
    @Test
    void throwExceptionWhenWinningNumbersContainDuplicates() {
        // given
        List<WinningNumber> duplicatedNumbers = DUPLICATED_NUMBERS;

        // when //then
        assertThrows(IllegalArgumentException.class, () -> WinningNumbers.of(duplicatedNumbers));
    }

    @DisplayName("유효한 당첨 번호 6개로 객체를 정상 생성한다.")
    @Test
    void createWinningNumbersSuccessfullyWhenValidInput() {
        // given
        List<WinningNumber> validNumbers = VALID_NUMBERS;

        // when //then
        Assertions.assertThat(WinningNumbers.of(validNumbers)).isInstanceOf(WinningNumbers.class);
    }
}