package oncall.model;

public class WeekDay implements WorkingType {

    private final String day;

    public WeekDay(String day) {
        this.day = day;
    }

    @Override
    public String getWeeks() {
        return day;
    }
    
}
