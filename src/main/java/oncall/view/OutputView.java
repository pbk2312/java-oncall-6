package oncall.view;

import oncall.model.Shedule;

public class OutputView {

    public static void print(Shedule shedule) {
        System.out.printf(ViewMessage.OUTPUT_SHEDULE.getMessage(), shedule.getMonth(), shedule.getDay(),
                shedule.getWorkingType().getWeeks(), shedule.getMemberName());
    }

}
