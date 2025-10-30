package lotto.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    public static final String DELIMITER = ",";
    public static final String CONTINUOUS_DELIMITER_REGEX = ",{2,}";
    public static final Pattern CONTINUOUS_DELIMITER_PATTERN = Pattern.compile(CONTINUOUS_DELIMITER_REGEX);

    public static String[] winningNumberParse(String input) {
        Matcher matcher = CONTINUOUS_DELIMITER_PATTERN.matcher(input);
        validateContinuousDelimiter(matcher);

        return input.split(DELIMITER);
    }

    private static void validateContinuousDelimiter(Matcher matcher) {
        if (matcher.find()) {
            throw new IllegalArgumentException("당첨 번호 구분자를 연속으로 입력할 수 없습니다.");
        }
    }
}
