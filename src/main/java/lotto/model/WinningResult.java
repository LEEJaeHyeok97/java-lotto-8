package lotto.model;

import lotto.model.vo.BonusNumber;

public class WinningResult {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningResult(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningResult of(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return new WinningResult(winningNumbers, bonusNumber);
    }
}
