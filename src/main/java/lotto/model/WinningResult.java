package lotto.model;

import lotto.model.vo.LottoNumber;

public class WinningResult {

    private final WinningNumbers winningNumbers;
    private final LottoNumber bonusNumber;

    public WinningResult(WinningNumbers winningNumbers, LottoNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }
}
