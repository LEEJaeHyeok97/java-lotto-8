package lotto.model.factory;

import lotto.model.vo.PurchaseAmount;

public class PurchaseAmountFactory {

    public PurchaseAmountFactory() {
    }

    public static PurchaseAmount from(String input) {
        validate(input);

        return PurchaseAmount.of(parseValue(input));
    }

    private static void validate(String input) {
        validateIsNotEmpty(input);
        validateIsNotBlank(input);
    }

    private static void validateIsNotEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 입력하지 않았습니다.");
        }
    }

    private static void validateIsNotBlank(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액에 공백 문자만 입력할 수 없습니다.");
        }
    }

    private static Integer parseValue(String input) {
        try {
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액에는 숫자만 입력할 수 있습니다.");
        }
    }
}
