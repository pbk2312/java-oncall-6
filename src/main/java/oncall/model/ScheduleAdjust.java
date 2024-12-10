package oncall.model;

import java.util.ArrayList;
import java.util.List;

public class ScheduleAdjust {

    private final List<Shedule> finalShedules = new ArrayList<>();


    public List<Shedule> getFinalShedules() {
        return finalShedules;
    }

    public void adjustShedule(List<Shedule> weekDayShedules, List<Shedule> dayOffShedule, int month) {
        int endDay = getEndDay(month);
        String previousMemberName = "";
        for (int i = 1; i <= endDay; i++) {
            final int currentDay = i;
            Shedule weekDay = weekDayShedules.stream()
                    .filter(shedule -> shedule.getDay() == currentDay)
                    .findFirst()
                    .orElse(null);

            Shedule dayOffShule = dayOffShedule.stream()
                    .filter(shedule -> shedule.getDay() == currentDay)
                    .findFirst()
                    .orElse(null);
            if (weekDay != null) {
                finalShedules.add(weekDay);
                previousMemberName = weekDay.getMemberName();
            }
            if (dayOffShule != null) {
                if (previousMemberName.equals(dayOffShule.getMemberName())) {
                    Shedule nextShdule = dayOffShedule.stream()
                            .filter(shedule -> shedule.getDay() > dayOffShule.getDay())
                            .findFirst().orElse(null);
                    int nextDay = nextShdule.getDay();
                    WorkingType workingType = nextShdule.getWorkingType();
                    nextShdule.changeShdule(dayOffShule.getDay(), dayOffShule.getWorkingType());
                    dayOffShule.changeShdule(nextDay, workingType);
                    finalShedules.add(nextShdule);
                    previousMemberName = nextShdule.getMemberName();
                } else {
                    finalShedules.add(dayOffShule);
                    previousMemberName = "";
                }

            }

        }


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

}
