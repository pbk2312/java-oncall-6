package oncall.model;

public class DayOff implements WorkingType {

    private final String day;

    public DayOff(String day) {
        this.day = day;
    }

    @Override
    public String getWeeks() {
        return day;
    }

}
