package lotto.model;

import java.util.ArrayList;
import java.util.List;
import lotto.model.vo.Lotto;

public class Lottos {

    private final List<Lotto> values;

    public Lottos(List<Lotto> values) {
        this.values = values;
    }

    public static Lottos of(List<Lotto> values) {
        return new Lottos(values);
    }

    public Lottos generateByQuantity(int quantity, LottoNumbersGenerator lottoNumbersGenerator) {
        List<Lotto> values = new ArrayList<>();

        while (quantity > 0) {
            values.add(getIssuedLotto(lottoNumbersGenerator));
            quantity -= 1;
        }

        return Lottos.of(values);
    }

    private Lotto getIssuedLotto(LottoNumbersGenerator lottoNumbersGenerator) {
        return Lotto.issue(getGenerateLottoNumbers(lottoNumbersGenerator));
    }

    private List<Integer> getGenerateLottoNumbers(LottoNumbersGenerator lottoNumbersGenerator) {
        return lottoNumbersGenerator.generateLottoNumbers();
    }
}
