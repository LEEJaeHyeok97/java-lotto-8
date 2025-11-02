package lotto.model.stub;

import java.util.List;
import lotto.model.LottoNumbersGenerator;

public class FixedLottoNumberGenerator implements LottoNumbersGenerator {

    @Override
    public List<Integer> generateLottoNumbers() {
        return List.of(1, 2, 3, 4, 5, 6);
    }
}
