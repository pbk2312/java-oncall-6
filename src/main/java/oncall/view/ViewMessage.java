package oncall.view;

public enum ViewMessage {

    INPUT_MONTH_WEEK("비상 근무를 배정할 월과 시작 요일을 입력하세요> "),
    INPUT_WEEKDAY_MEMBER_NAME("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),
    INPUT_DAYOFF_MEMBER_NAME("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),
    OUTPUT_SHEDULE("%d월 %d일 %s %s\n");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}

