package lotto.model;

import lotto.model.vo.BonusNumber;
import lotto.model.vo.Lotto;
import lotto.model.vo.WinningNumber;

public class WinningInfo {

    private final WinningNumbers winningNumbers;
    private final BonusNumber bonusNumber;

    public WinningInfo(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        validateDuplicatedBonusNumber(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningInfo of(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        return new WinningInfo(winningNumbers, bonusNumber);
    }

    public void validateDuplicatedBonusNumber(WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        for (WinningNumber winningNumber : winningNumbers) {
            if (isEquals(bonusNumber.getNumber(), winningNumber)) {
                throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨 숫자와 중복될 수 없습니다.");
            }
        }
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
            if (isEquals(number, winningNumber)) {
                return true;
            }
        }

        return false;
    }

    private static boolean isEquals(Integer number, WinningNumber winningNumber) {
        return winningNumber.getNumber().equals(number);
    }
}
