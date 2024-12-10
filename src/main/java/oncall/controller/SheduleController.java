package oncall.controller;

import java.util.List;
import java.util.Map;
import oncall.model.GrantSheduleFirst;
import oncall.model.InputManager;
import oncall.model.ScheduleAdjust;
import oncall.model.Shedule;
import oncall.view.InputView;
import oncall.view.OutputView;

public class SheduleController {

    public void run() {
        int month = 0;
        String week = "";

        Map<Integer, String> monthAndWeek = extractMonthAndWeek();

        for (Integer key : monthAndWeek.keySet()) {
            month = key;
            week = monthAndWeek.get(month);
        }
        String inputWeekDayMemberName = InputView.inputWeekDayMemberName();

        List<String> memberWeekDayNames = InputManager.extractMemberNames(inputWeekDayMemberName);
        String inputDayOffMemberName = InputView.inputDayOffMemberName();
        List<String> extractDayOffMemberNames = InputManager.extractMemberNames(inputDayOffMemberName);

        GrantSheduleFirst grantSheduleFirst = new GrantSheduleFirst();
        grantSheduleFirst.setWeekdayShedules(memberWeekDayNames, extractDayOffMemberNames, month, week);

        List<Shedule> weekdayShedules = grantSheduleFirst.getWeekdayShedules();
        List<Shedule> dayOffShedules = grantSheduleFirst.getDayOffShedules();

        ScheduleAdjust scheduleAdjust = new ScheduleAdjust();
        scheduleAdjust.adjustShedule(weekdayShedules, dayOffShedules, month);

        for (Shedule shedule : scheduleAdjust.getFinalShedules()) {
            OutputView.print(shedule);
        }

    }

    private static Map<Integer, String> extractMonthAndWeek() {
        while (true) {
            try {
                String inputMonthAndWeek = InputView.inputMonthAndWeek();
                return InputManager.extractMonthAndWeek(inputMonthAndWeek);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
