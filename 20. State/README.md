# State
> 객체의 내부 상태가 바뀔 때 객체의 동작을 변경할 수 있도록 함. 객체는 자신의 클래스를 바꾸는 것처럼 보임.

## 문제 배경
- 여러가지 상태를 if 문으로 관리하는 경우

## 구성 요소
- State < I > : 상태에서 나올 수 있는 모든 동작을 추상 메서드 정리한다. 
    - default 메서드를 이용해서 코드의 양을 줄일 수 있다.

- ConcreteState < C > 
    - Operator operator : 
    - State(Operator operator) {this.operator = operator}

- Operator < C > : 사용자의 입력에 대해 모두 대응할 수 있는 객체
    - State state : 현재 어떤 상태인지 저장하는 객체
    - A...ZState a...zstates: 모든 상태 인스턴스를 가지고 있다.
    - 상태에서 나올 수 있는 모든 동작을 만들고 state에서 메서드를 호출 성공하면 다음 state로 바꿔준다
