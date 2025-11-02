package lotto.model.vo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BonusNumberTest {

    @ParameterizedTest
    @CsvSource(value = {"0", "46", "100", "1000"})
    @DisplayName("보너스 번호는 1~45 사이가 아닌 숫자가 입력될 때 예외가 발생한다.")
    void validateBonusNumberOutRange(Integer bonusNumber) {
        //given
        //when //then
        assertThrows(IllegalArgumentException.class, () -> BonusNumber.of(bonusNumber));
    }

    @ParameterizedTest
    @CsvSource(value = {"1", "10", "45"})
    @DisplayName("보너스 번호에 1~45 사이 숫자가 입력되면 보너스 객체가 생성된다.")
    void createBonusNumber(Integer bonusNumber) {
        //given
        //when
        BonusNumber createdBonusNumber = BonusNumber.of(bonusNumber);

        //then
        Assertions.assertThat(createdBonusNumber.getNumber()).isEqualTo(bonusNumber);
    }
}