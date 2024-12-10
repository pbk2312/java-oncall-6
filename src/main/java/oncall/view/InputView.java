package oncall.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String inputMonthAndWeek() {
        return readInput(ViewMessage.INPUT_MONTH_WEEK.getMessage());
    }

    public static String inputWeekDayMemberName() {
        return readInput(ViewMessage.INPUT_WEEKDAY_MEMBER_NAME.getMessage());
    }

    public static String inputDayOffMemberName() {
        return readInput(ViewMessage.INPUT_DAYOFF_MEMBER_NAME.getMessage());
    }

    // 콘솔 자원 해제
    public static void close() {
        Console.close();
    }

    private static String readInput(String message) {
        System.out.print(message);
        return Console.readLine();
    }

}
