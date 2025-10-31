package lotto.model.vo;

public class PurchaseAmount {

    public static final int LOTTO_PRICE = 1000;
    private final Integer amount;

    public PurchaseAmount(String amount) {
        validateAmount(amount);
        Integer parsedAmount = parseToNumber(amount);
        validateParsedAmount(parsedAmount);
        this.amount = parsedAmount;
    }

    private void validateAmount(String amount) {
        validateIsEmpty(amount);
        validateIsBlank(amount);
    }

    private void validateIsEmpty(String amount) {
        if (amount.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액을 입력하지 않았습니다.");
        }
    }

    private void validateIsBlank(String amount) {
        if (amount.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 구입 금액에 공백문자를 입력할 수 없습니다.");
        }
    }

    private void validateParsedAmount(Integer parsedAmount) {
        validateAmountUnit(parsedAmount);
        validateMinimumAmount(parsedAmount);
    }

    private Integer parseToNumber(String amount) {
        try {
            return Integer.parseInt(amount);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자로만 입력해야 합니다.");
        }
    }

    private void validateAmountUnit(Integer amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    private void validateMinimumAmount(Integer amount) {
        if (amount < LOTTO_PRICE) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 이상 입력해야 합니다.");
        }
    }
}
