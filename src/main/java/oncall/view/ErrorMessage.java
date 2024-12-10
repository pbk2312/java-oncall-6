package oncall.view;

public enum ErrorMessage {

    NOT_EMPTY("[ERROR] 빈 값은 허용되지 않습니다."),
    INVALID_FORMAT("[ERROR] 쉼표(,)로 구분해주세요"),
    INVALID_MONTH("[ERROR] 1-12월 중에 선택해주세요"),
    DUPLICATED_MEMBER_NAME("[ERROR] 사원 이름은 중복되면 안됩니다.");


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
