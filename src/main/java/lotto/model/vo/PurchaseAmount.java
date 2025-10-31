package lotto.model.vo;

public class PurchaseAmount {

    public static final int LOTTO_PRICE = 1000;

    private final Integer amount;

    public PurchaseAmount(Integer amount) {
        validate(amount);
        this.amount = amount;
    }

    private void validate(Integer parsedAmount) {
        validateAmountUnit(parsedAmount);
        validateMinimumAmount(parsedAmount);
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
