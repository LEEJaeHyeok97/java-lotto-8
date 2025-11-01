package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import lotto.model.vo.Lotto;

public class Lottos implements Iterable<Lotto> {

    public static final int ISSUE_UNIT = 1;

    private final List<Lotto> values;

    public Lottos(List<Lotto> values) {
        this.values = values;
    }

    public static Lottos of(List<Lotto> values) {
        return new Lottos(values);
    }

    public static Lottos generateByQuantity(int quantity, LottoNumbersGenerator lottoNumbersGenerator) {
        List<Lotto> issuedLottos = new ArrayList<>();

        int remaining = quantity;
        while (remaining > 0) {
            issuedLottos.add(issueOneLotto(lottoNumbersGenerator));
            remaining -= ISSUE_UNIT;
        }

        return Lottos.of(issuedLottos);
    }

    @Override
    public Iterator<Lotto> iterator() {
        return Collections.unmodifiableList(values).iterator();
    }

    private static Lotto issueOneLotto(LottoNumbersGenerator lottoNumbersGenerator) {
        return Lotto.issue(generateLottoNumbers(lottoNumbersGenerator));
    }

    private static List<Integer> generateLottoNumbers(LottoNumbersGenerator lottoNumbersGenerator) {
        return lottoNumbersGenerator.generateLottoNumbers();
    }
}
