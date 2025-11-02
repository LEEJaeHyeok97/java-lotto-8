package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.stub.FixedLottoNumberGenerator;
import lotto.model.vo.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottosTest {

    public static final int QUANTITY = 5;

    @DisplayName("요청한 수량을 입력하면 요청한 수 만큼 로또가 발급된다.")
    @Test
    void generateLottosByGivenQuantity() {
        //given
        int quantity = QUANTITY;

        //when
        Lottos lottos = Lottos.generateByQuantity(quantity, new FixedLottoNumberGenerator());

        //then
        for (Lotto lotto : lottos) {
            assertThat(lotto.getNumbers()).containsExactly(1,2,3,4,5,6);
        }
    }
}