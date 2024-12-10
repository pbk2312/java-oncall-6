package oncall.model;

public class Shedule {

    private final String memberName;
    private final int month;
    private int day;
    private WorkingType workingType;


    public Shedule(String memberName, int month, int day, WorkingType workingType) {
        this.memberName = memberName;
        this.month = month;
        this.day = day;
        this.workingType = workingType;
    }

    public String getMemberName() {
        return memberName;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public WorkingType getWorkingType() {
        return workingType;
    }

    public void changeShdule(int changeday, WorkingType changeWorkingType) {
        this.day = changeday;
        this.workingType = changeWorkingType;
    }

}
