package lotto.model.vo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningNumberTest {

    @ParameterizedTest
    @CsvSource(value = {"0", "46", "100"})
    @DisplayName("당첨 번호는 1~45 사이가 아닌 숫자가 입력될 때 예외가 발생한다.")
    void validateWinningNumberOutRange(Integer winningNumber) {
        //given
        //when//then
        assertThrows(IllegalArgumentException.class, () -> WinningNumber.of(winningNumber));
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "10", "45"})
    @DisplayName("당첨 번호는 1~45 사이의 숫자가 입력되면 당첨 숫자 객체가 생성된다.")
    void createWinningNumber(Integer winningNumber) {
        //given
        //when
        WinningNumber createdWinningNumber = WinningNumber.of(winningNumber);

        //then
        assertThat(createdWinningNumber.getNumber()).isEqualTo(winningNumber);
    }
}