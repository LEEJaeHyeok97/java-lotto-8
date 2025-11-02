package lotto.model.vo;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PurchaseAmountTest {

    @DisplayName("구매할 금액이 로또 최소 단위보다 작은 금액이 입력되면 예외를 발생한다.")
    @Test
    public void PurchaseAmountUnderLottoPrice() {
        //given
        int amount = 999;

        //when //then
        assertThrows(IllegalArgumentException.class, () -> PurchaseAmount.of(amount));
    }


}