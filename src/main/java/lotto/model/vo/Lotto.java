package lotto.model.vo;

import java.util.Comparator;
import java.util.List;

public class Lotto {

    public static final int LOTTO_NUMBER_COUNT = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto of(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static Lotto issue(List<Integer> numbers) {
        sortNumbers(numbers);

        return Lotto.of(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static void sortNumbers(List<Integer> numbers) {
        numbers.sort(Comparator.naturalOrder());
    }
}
