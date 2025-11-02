package lotto.model.factory;

import java.util.ArrayList;
import java.util.List;
import lotto.model.WinningNumbers;
import lotto.model.vo.WinningNumber;

public class WinningNumbersFactory {

    public WinningNumbersFactory() {
    }

    public static WinningNumbers from(String[] rawNumbers) {

        List<WinningNumber> numbers = new ArrayList<>();
        for (String rawNumber : rawNumbers) {
            int parsedNumber = parseValue(rawNumber);
            numbers.add(WinningNumber.of(parsedNumber));
        }

        return WinningNumbers.of(numbers);
    }

    private static int parseValue(String rawNumber) {
        try {
            return Integer.parseInt(rawNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호에는 숫자만 입력할 수 있습니다.");
        }
    }
}
