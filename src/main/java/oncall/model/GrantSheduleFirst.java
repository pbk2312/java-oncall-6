package oncall.model;

import java.util.ArrayList;
import java.util.List;
import oncall.constants.Holidays;

public class GrantSheduleFirst {

    private final List<String> weekDay = new ArrayList<>(List.of("일", "월", "화", "수", "목", "금", "토"));
    private final List<Shedule> weekdayShedules = new ArrayList<>();
    private final List<Shedule> dayOffShedules = new ArrayList<>();

    public void setWeekdayShedules(List<String> weekdayMembers,
                                   List<String> dayOffMembers,
                                   int month, String day) {
        int weekDayMemberSeq = 0;
        int datOffMemberSeq = 0;
        int endDay = getEndDay(month);

        int startWeek = weekDay.indexOf(day);

        for (int i = 1; i <= endDay; i++) {
            String week = weekDay.get(startWeek);
            startWeek += 1;
            if (startWeek > 6) {
                startWeek = 0;
            }

            if (isDayOff(week)) {
                datOffMemberSeq = getDatOffMemberSeq(dayOffMembers, month, datOffMemberSeq, i, week);
            }

            if (!isDayOff(week)) {
                if (isHoliday(month, i)) {
                    datOffMemberSeq = getDatOffMemberSeq(dayOffMembers, month, datOffMemberSeq, i, week + "(휴일)");
                }
                if (!isHoliday(month, i)) {
                    weekDayMemberSeq = getWeekDayMemberSeq(weekdayMembers, month, weekDayMemberSeq, i, week);
                }
            }
        }
    }

    private int getWeekDayMemberSeq(List<String> weekdayMembers, int month, int weekDayMemberSeq, int i, String week) {
        String weekdayMemberName = weekdayMembers.get(weekDayMemberSeq);
        weekDayMemberSeq += 1;
        if (weekDayMemberSeq > weekdayMembers.size() - 1) {
            weekDayMemberSeq = 0;
        }
        Shedule shedule = new Shedule(weekdayMemberName, month, i, new WeekDay(week));
        weekdayShedules.add(shedule);
        return weekDayMemberSeq;
    }

    private int getDatOffMemberSeq(List<String> dayOffMembers, int month, int datOffMemberSeq, int i, String week) {
        String dayOffMemberName = dayOffMembers.get(datOffMemberSeq);
        datOffMemberSeq += 1;
        if (datOffMemberSeq > dayOffMembers.size() - 1) {
            datOffMemberSeq = 0;
        }
        Shedule shedule = new Shedule(dayOffMemberName, month, i, new DayOff(week));
        dayOffShedules.add(shedule);
        return datOffMemberSeq;
    }

    private static int getEndDay(int month) {
        if (month == 2) {
            return 28;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }

        return 31;
    }


    private static boolean isDayOff(String week) {
        return week.equals("일") || week.equals("토");
    }

    private static boolean isHoliday(int month, int day) {
        Holidays holidays = Holidays.getHolidays(month, day);
        if (holidays != null) {
            return true;
        }
        return false;

    }

    public List<Shedule> getWeekdayShedules() {
        return weekdayShedules;
    }

    public List<Shedule> getDayOffShedules() {
        return dayOffShedules;
    }

}
