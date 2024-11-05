# 💸 로또

- - -

## 🚀 기능 요구 사항

- - -

### <간단한 로또 발매기 구현>

- 로또 번호의 숫자 범위는 1~45
- 로또 구입 금액 입력 시 구입 금액에 해당하는 만큼 로또 발행
    - 로또 1장의 가격은 1,000원
    - 1,000원으로 나누어 떨어지지 않는 경우 예외 처리
    - 1장의 로또 발행 시 중복되지 않는 6개의 숫자 선정
    - 로또 번호는 오름차순으로 정렬하여 출력
- 당첨 번호 추첨
    - 중복되지 않는 6개의 숫자와 보너스 번호 1개 선정
- 당첨에는 1~5등 존재
    - 당첨 기준과 금액
        - 1등: 6개 번호 일치 / 2,000,000,000원
        - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
        - 3등: 5개 번호 일치 / 1,500,000원
        - 4등: 4개 번호 일치 / 50,000원
        - 5등: 3개 번호 일치 / 5,000원
- 당첨 번호와 보너스 번호를 입력받음
- 사용자가 구매한 로또 번호와 당첨 번호 비교
    - 당첨 내역 및 수익률을 출력한 뒤 로또 게임 종료
    - 수익률은 소수점 둘째 자리에서 반올림
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 발생
    - `[ERROR]`로 시작하는 에러 메시지 출력
    - 그 부분부터 입력을 다시 받음
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 처리
- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms`, `Console API` 사용
- Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()` 활용
- 사용자 입력 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용

## 📃 추가된 프로그래밍 요구 사항

- - -

- 메서드의 길이가 15라인을 넘어가지 않도록 구현
- 메서드가 한 가지 일만 잘 하도록 구현
- `else`, `switch`/`case` 금지
    - `if` 조건절에서 값을 `return`하는 방식으로 구현하면 됨
- Java Enum 적용
- 구현한 기능에 대한 단위 테스트 작성
    - 단, UI(`System.out`, `System.in`, `Scanner`) 로직 제외
    - 단위 테스트 작성이 익숙하지 않다면 `LottoTest` 참고

## 📂 패키지 구조

- - -

```
🌐 src.main.java.lotto
│
├── 📦 constants
│   └── LottoConstantNumbers
│
├── 📦 controller
│   └── LottoController
│
├── 📦 domain
│   ├── Lotto
│   ├── LottoResult
│   ├── Prize
│   └── WinningNumber
│
├── 📦 exception
│   │
│   ├──📦 lottoticketexception
│   │   ├── DuplicateException
│   │   └── LottoNumberSizeException
│   │
│   ├──📦 numberexception
│   │   ├── InvalidNumberException
│   │   └── OutOfRangeNumberException
│   │
│   ├──📦 purchaseamountexception
│   │   ├── InvalidPurchaseAmountException
│   │   ├── MaxPurchaseExceedException
│   │   ├── NegativePurchaseAmountException
│   │   └── NotDivisibleByLottoPriceException
│   │
│   ├── ErrorConstants
│   └── ErrorMessage
│
├── 📦 factory
│   └── LottoTicketStore
│
├── 📦 service
│   ├── LottoGameService
│   ├── LottoPurchaseService
│   ├── LottoResultCalculator
│   └── LottoStatisticsService
│
├── 📦 util
│   ├── DuplicateValidator
│   ├── LottoNumberSorter
│   ├── NumberValidator
│   ├── PurchaseAmountValidator
│   ├── RandomNumberGenerator
│   └── WinningNumberSeparator
│
├── 📦 view
│   ├── ConsoleMessage
│   ├── InputView
│   └── OutputView
│
└── Application
```

## 📌 계획

- - -

- 로또의 흐름 파악
- 어울리는 디자인 패턴 선정
- 패키지 구조 설계
- 구현할 기능 목록 정리
- README.md 작성
- 프로젝트 초기 설정
- 구현
- 예외 처리에 대한 검토
- 테스트 코드 작성
- 리팩토링

## 💡 구현할 기능 목록

- - -

### 1. 입력

- [x] 로또 구입 금액 입력 받기
    - [x] 1,000원 단위로 입력 받아야 함
    - [x] 양의 정수가 아닌 경우 예외 발생
    - [x] 1,000으로 나누어 떨어지지 않는 경우 예외 발생
    - [x] 1회 최대 구매 가능 금액을 초과할 시 예외 발생
    - [x] 로또 구매 개수 출력
- [x] 당첨 번호 입력
    - [x] 쉼표로 구분
        - [x] 올바르게 구분할 수 없을 시 예외 발생
    - [x] 6개 입력 받음
        - [x] 6개가 아닐 경우 예외 발생
    - [x] 1~45 범위의 정수만 있는지 검증
        - [x] 범위 외의 수 입력 시 예외 발생
    - [x] 중복 없이 입력되었는지 검증
        - [x] 중복되었을 시 예외 발생
- [x] 보너스 번호 입력
    - [x] 1개 입력 받음
    - [x] 1~45 범위의 정수인지 검증
    - [x] 범위 외의 수 입력 시 예외 발생

### 2. 로또 발행

- [x] 발행할 로또 수량 계산
- [x] 로또 번호 선정
    - [x] 1~45 범위의 정수 중 중복 없이 무작위 6개의 숫자
    - [x] 각 로또마다 오름차순으로 번호 정렬
- [x] 로또 리스트 생성
    - [x] 구입 금액에 따라 계산된 수만큼의 로또 생성
        - [x] 리스트에 저장
    - [x] 생성된 로또 리스트를 형식에 맞게 출력

### 3. 당첨 결과 계산

- [x] 각 로또의 번호와 당첨 번호를 비교
    - [x] 일치하는 번호의 개수 계산
- [x] 당첨 등수 판단
    - [x] 일치하는 번호의 개수에 따라 등수 결정
- [x] 각 등수의 당첨 횟수 카운팅
- [x] 당첨 횟수 저장

### 4. 수익률 계산

- [x] 총 당첨금 계산 (각 등수별 당첨 횟수 * 당첨금)
- [x] 수익률 계산 (총 당첨금 / 총 구입 금액) * 100
    - [x] 소수점 둘째 자리에서 반올림

### 5. 결과 출력

- [x] 로또 구매 내역(생성된 로또 수와 각 로또의 번호를 오름차순 정렬) 출력
- [x] 당첨 통계(등수별 당첨 횟수와 당첨금) 출력
- [x] 계산된 수익률 출력

### 6. 단위 테스트 작성

- [x] 구현한 기능에 대한 단위 테스트 작성

### 7. 유틸리티

- [x] 숫자 검증 유틸리티
- [x] 숫자 랜덤 추출 유틸리티
- [x] 오름차순 정렬 유틸리티

### 8. 구조 개선 및 리팩토링

- [ ] 메서드 분리
    - [ ] 메서드의 길이가 15라인을 넘어가지 않도록 구현
    - [ ] 메서드가 한 가지 일만 잘 하도록 구현
- [ ] 책임 분리: 각 클래스가 단일 책임 원칙을 따르도록 구조 개선
- [x] else, switch/case문 금지
- [x] Enum의 적용

## 🤔 생각의 흔적

- - -

### 로또의 흐름

1. 로또 구입 금액 입력 받음
2. 당첨 번호 입력 받음
3. 보너스 번호 입력 받음
4. 발행한 로또의 수량 출력
5. 발행한 로또의 번호를 오름차순으로 정렬하여 출력
6. 당첨 내역 출력
7. 수익률 출력

- 예외 상황 시 에러 문구 출력 후 다시 입력 받음

### 고민한 부분

- 로또 구매 가능 금액을 int나 long으로 할 것인가, 현실처럼 10만 원까지 제한할 것인가
    - 10만 원으로 제한
- Validator.validate가 맘에 안 드는데 어쩔까..

### 자기 반성

- 3시간 만에 하려니까 너무 촉박했다. 다음엔 시간을 조금 더 내서 하자.. 