# 기능 요구 사항

입력(InputView)

- `비상 근무를 배정할 월과 시작 요일을 입력하세요>`
- `평일 비상 근무 순번대로 사원 닉네임을 입력하세요> `
- `휴일 비상 근무 순번대로 사원 닉네임을 입력하세요>`

법정 휴일(DayOff)

- `1,1`
- `3,1`
- `5,5`
- `6,6`
- `8,15`
- `10,3`
- `10,9`
- `12,25`

WeekDaySchedule(model)

- 평일 근무
- 근무 타입
- 근무자 이름
- 요일

DayOffSchedule(model)

- 휴일 근무
- 근무 타입
- 근무자 이름
- 요일

FirstSheduleGrant

FinalShedule

- 휴일 근무표
- 평일 근무표
- 2일 연속이면 변경

OutputView

- 근무표 출력


