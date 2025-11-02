package lotto.model.vo;

import static org.assertj.core.api.Assertions.assertThat;
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

    @DisplayName("구매할 금액이 1000원 단위가 아닌 금액이 입력되면 예외를 발생한다.")
    @Test
    public void PurchaseAmountIsNotLottoPriceUnit() {
        //given
        int amount = 1500;

        //when //then
        assertThrows(IllegalArgumentException.class, () -> PurchaseAmount.of(amount));
    }

    @DisplayName("구매 금액이 로또 단위의 배수일 때 올바른 개수를 반환해야 한다.")
    @Test
    public void returnsCorrectQuantityBasedOnPurchaseAmount() {
        //given
        int amount = 8000;

        //when
        PurchaseAmount purchaseAmount = PurchaseAmount.of(amount);
        int quantity = purchaseAmount.calculateQuantity();

        //then
        assertThat(quantity).isEqualTo(8);
    }
}