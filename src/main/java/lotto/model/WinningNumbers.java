package lotto.model;

import java.util.List;
import lotto.model.vo.LottoNumber;

public class WinningNumbers {

    private final List<LottoNumber> values;

    public WinningNumbers(List<LottoNumber> values) {
        this.values = values;
    }
}
