## 문자열 계산기

요구 사항

- [x] 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
- [x] 입력 문자열의 숫자와 사칙 연산 사이에는 반드시 빈 공백 문자열이 있다고 가정한다.
- [x] 나눗셈의 경우 결과 값을 정수로 떨어지는 값으로 한정한다.
- [x] 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
- [x] 예를 들어 2 + 3 * 4 / 2와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.



테스트 미션 목록

- [x] 덧셈
- [x] 뺄셈
- [x] 곱셈
- [x] 나눗셈
- [x] 입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw
- [x] 사칙연산 기호가 아닌 경우 IllegalArgumentException throw
- [x] 사칙 연산을 모두 포함하는 기능 구현



## 자동차 경주

### 요구 사항

- [x] 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- [x] 사용자는 몇 대의 자동차로 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- [x] 전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
- [x] 자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.



### 기능

- [x] 자동차 댓수 입력
- [x] 시도 횟수 입력
- [x] 자동차 전진
- [x] 자동차 멈춤
- [x] 0 ~ 9 랜덤 값 구하기
- [x] 자동차 상태 출력



## 자동차 경주(우승자)

### 요구 사항

- [x] 각 자동차에 이름을 부여할 수 있다. **자동차 이름은 5자를 초과**할 수 없다.
- [x] 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- [x] 자동차 이름은 쉼표(,)를 기준으로 구분한다.
- [x] **자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한명 이상일 수 있다.**