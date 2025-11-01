package lotto.model.vo;

public class WinningNumber {

    public static final int LOTTO_NUMBER_MIN = 1;
    public static final int LOTTO_NUMBER_MAX = 45;

    private final Integer number;

    public WinningNumber(Integer number) {
        validateLottoNumberInRange(number);
        this.number = number;
    }

    private static void validateLottoNumberInRange(Integer number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }
}
