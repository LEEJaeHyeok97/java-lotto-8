package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.model.vo.WinningNumber;

public class WinningNumbers {

    private final List<WinningNumber> values;

    public WinningNumbers(List<WinningNumber> values) {
        validateIsDuplicatedWinningNumber(values);
        this.values = values;
    }

    private static void validateIsDuplicatedWinningNumber(List<WinningNumber> values) {
        Set<WinningNumber> nonDuplicatedWinningNumbers = new HashSet<>(values);

        if (nonDuplicatedWinningNumbers.size() != values.size()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복된 숫자를 입력할 수 없습니다.");
        }
    }
}
