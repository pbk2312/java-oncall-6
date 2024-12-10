package oncall.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import oncall.view.ErrorMessage;

public class InputManager {

    public static Map<Integer, String> extractMonthAndWeek(String inputMonthWeek) {
        validateEmpty(inputMonthWeek);
        String[] split = getSplit(inputMonthWeek);
        int month = parseNumber(split[0]);
        String week = split[1];
        return Map.of(month, week);
    }

    public static List<String> extractMemberNames(String inputWeekDayMemberNames) {
        validateEmpty(inputWeekDayMemberNames);
        List<String> parseNames = parseNames(inputWeekDayMemberNames);
        validateNoDuplicates(parseNames);
        return parseNames;
    }

    private static List<String> parseNames(String input) {
        String[] parseNames = input.split(",");
        return Arrays.stream(parseNames)
                .map(String::trim) // 공백 제거
                .toList();
    }

    private static void validateNoDuplicates(List<String> names) {
        Set<String> Membernames = new HashSet<>(names);
        if (Membernames.size() != names.size()) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATED_MEMBER_NAME.getMessage());
        }
    }

    private static int parseNumber(String input) {
        try {
            int parseMonth = Integer.parseInt(input);
            validateMonthRange(parseMonth);
            return parseMonth;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT.getMessage());
        }
    }

    private static void validateMonthRange(int parseMonth) {
        if (parseMonth < 1 || parseMonth > 12) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONTH.getMessage());
        }
    }

    private static String[] getSplit(String inputMonthWeek) {
        return inputMonthWeek.split(",");
    }


    private static void validateEmpty(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException(ErrorMessage.NOT_EMPTY.getMessage());
        }
    }


}
