package lotto.model.factory;

import lotto.model.vo.BonusNumber;

public class BonusNumberFactory {

    public BonusNumberFactory() {
    }

    public static BonusNumber from(String input) {
        return BonusNumber.of(parseValue(input));
    }

    private static Integer parseValue(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호에는 숫자만 입력할 수 있습니다.");
        }
    }
}
