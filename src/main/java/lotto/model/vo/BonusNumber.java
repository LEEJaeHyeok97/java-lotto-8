package lotto.model.vo;

public class BonusNumber {

    public static final int BONUS_NUMBER_MIN = 1;
    public static final int BONUS_NUMBER_MAX = 45;

    private final Integer number;

    public BonusNumber(Integer number) {
        validateLottoNumberInRange(number);
        this.number = number;
    }

    public static BonusNumber of(Integer number) {
        return new BonusNumber(number);
    }

    public Integer getNumber() {
        return number;
    }

    private void validateLottoNumberInRange(Integer number) {
        if (number < BONUS_NUMBER_MIN || number > BONUS_NUMBER_MAX) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
