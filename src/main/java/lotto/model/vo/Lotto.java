package lotto.model.vo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        validateIsDuplicatedNumbers(numbers);
        validateLottoNumberCount(numbers);
    }

    private void validateLottoNumberCount(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private void validateIsDuplicatedNumbers(List<Integer> numbers) {
        Set<Integer> nonDuplicatedLottoNumbers = new HashSet<>(numbers);
        if (nonDuplicatedLottoNumbers.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 입력될 수 없습니다.");
        }
    }

    private static List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> copiedNumbers = new ArrayList<>(numbers);
        copiedNumbers.sort(Comparator.naturalOrder());

        return copiedNumbers;
    }
}
