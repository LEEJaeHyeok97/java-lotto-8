package lotto.view;

import lotto.model.Lottos;
import lotto.model.vo.Lotto;

public class OutputView {

    public void printIssuedLottos(Lottos lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }

        System.out.println();
    }
}
