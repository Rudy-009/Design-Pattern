# Builder Pattern
> 객체 생성을 직접 하지 않고 필수 요소를 전달한 후 생성자를 호출해서 빌더 객체를 생성
> 빌더 객체의 선택 요소에 대해 setter와 비슷한 메소드 들을 호출
> build() 메소드를 호출해서 원하는 immutable 객체 생성

# Before Builder Pattern

## 점층적 생성자 패턴 (telescoping constructor pattern)
> 필수 요소를 받는 생성자 + 필수 요소와 1...N 개의 선택 요소를 받는 생성자

1. 너무 많은 생성자
2. 자료형이 비슷한 경우, 오류 발생 가능성이 높음

## 자바빈즈 패턴 (JavaBeans pattern)
> 인자없는 생성자로 객체 생성 후, setter 메소드들을 이용해서 필수와 선택 요소의 값들을 지정

1. 객체 생성 중간에 일관성이 깨질 수 있음
2. setter 메소드가 있어서 변경 불가능한(immutable) 객체 생성이 안됨

### 해결 방법
- 객체 생성이 완성될 때까지 사용 못하도록 막기
