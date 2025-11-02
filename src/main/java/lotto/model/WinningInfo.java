package lotto.model;

import lotto.model.vo.BonusNumber;
import lotto.model.vo.Lotto;
import lotto.model.vo.WinningNumber;

public class WinningInfo {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningInfo(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningInfo of(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return new WinningInfo(winningNumbers, bonusNumber);
    }

    public WinningRank judgeRank(Lotto lotto) {
        return WinningRank.findByMatchCountAndBonusMatch(countMatch(lotto), isBonusMatched(lotto));
    }

    public int countMatch(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(this::isInWinningNumber)
                .count();
    }

    public boolean isBonusMatched(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber.getNumber());
    }

    private boolean isInWinningNumber(Integer number) {
        for (WinningNumber winningNumber : winningNumbers) {
            if (winningNumber.getNumber().equals(number)) {
                return true;
            }
        }

        return false;
    }
}
