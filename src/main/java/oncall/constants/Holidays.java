package oncall.constants;

import java.util.Arrays;

public enum Holidays {

    NEW_YEAR(1, 1),
    THREE_ONE(3, 1),
    CHILDDAY(5, 5),
    SIX_SIX(6, 6),
    KOREA_DAY(8, 15),
    TEN_THREE(10, 3),
    KOREAN_DAY(10, 9),
    CHRISTMAS(12, 23);

    private int Month;
    private int day;

    Holidays(int month, int day) {
        Month = month;
        this.day = day;
    }

    public static Holidays getHolidays(int month, int day) {
        return Arrays.stream(values())
                .filter(holidays -> holidays.Month == month)
                .filter(holidays -> holidays.day == day)
                .findFirst().orElse(null);
    }


    public int getMonth() {
        return Month;
    }

    public int getDay() {
        return day;
    }
}
