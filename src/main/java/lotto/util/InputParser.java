package lotto.util;

public class InputParser {

    public static final String DELIMITER = ",";
    public static final String CONTINUOUS_DELIMITER_REGEX = ",{2,}";
    public static final String BLANK = " ";
    public static final String STARTS_OR_ENDS_WITH_DELIMITER_REGEX = "^,|,$";

    public static String[] winningNumberParse(String input) {
        validate(input);

        return input.split(DELIMITER);
    }

    private static void validate(String input) {
        validateContinuousDelimiter(input);
        validateStartsOrEndsWithDelimiter(input);
        validateContainsBlank(input);
    }

    private static void validateStartsOrEndsWithDelimiter(String input) {
        if (input.matches(STARTS_OR_ENDS_WITH_DELIMITER_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 구분자가 맨 앞 또는 맨 뒤에 올 수 없습니다.");
        }
    }

    private static void validateContainsBlank(String input) {
        if (input.contains(BLANK)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 공백일 수 없습니다.");
        }
    }

    private static void validateContinuousDelimiter(String input) {
        if (input.matches(CONTINUOUS_DELIMITER_REGEX)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호 구분자를 연속으로 입력할 수 없습니다.");
        }
    }
}
