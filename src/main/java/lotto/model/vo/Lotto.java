package lotto.model.vo;

import java.util.ArrayList;
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

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static Lotto issue(List<Integer> numbers) {
        return Lotto.of(sortNumbers(numbers));
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> copiedNumbers = new ArrayList<>(numbers);
        copiedNumbers.sort(Comparator.naturalOrder());

        return copiedNumbers;
    }
}
