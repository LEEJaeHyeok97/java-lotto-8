package lotto.view;

import lotto.model.Lottos;
import lotto.model.vo.Lotto;

public class OutputView {

    public static final String PURCHASE_COUNT_MESSAGE = "%d개를 구매했습니다.";

    public void printPurchaseCount(int count) {
        System.out.printf(PURCHASE_COUNT_MESSAGE, count);
    }

    public void printIssuedLottos(Lottos lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }

        System.out.println();
    }
}
