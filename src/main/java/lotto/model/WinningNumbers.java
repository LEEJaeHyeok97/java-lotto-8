package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.vo.WinningNumber;

public class WinningNumbers {

    public static final int WINNING_NUMBER_COUNT = 6;
    private final List<WinningNumber> values;

    public WinningNumbers(List<WinningNumber> values) {
        validateIsDuplicatedWinningNumber(values);
        validateWinningNumberCount(values);
        this.values = values;
    }

    public static WinningNumbers of(List<WinningNumber> values) {
        return new WinningNumbers(values);
    }

    private void validateWinningNumberCount(List<WinningNumber> values) {
        if (values.size() != WINNING_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
    }

    private void validateIsDuplicatedWinningNumber(List<WinningNumber> values) {
        Set<WinningNumber> nonDuplicatedWinningNumbers = new HashSet<>(values);

        if (nonDuplicatedWinningNumbers.size() != values.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복된 숫자를 입력할 수 없습니다.");
        }
    }
}
