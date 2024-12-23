# Singleton

> Singleton 패턴은 클래스에 단 하나의 인스턴스만 존재하도록 보장하며, 이 인스턴스에 전역적으로 접근할 수 있는 생성 디자인 패턴

## 특징

- 클래스 당 하나의 인스턴스만 존재한다.
- 전역적으로 동일한 인스턴스를 공유한다..

## 문제점 및 해결책

### 1. 단일 책임 원칙(Single Responsibility Principle) 위반
- Singleton 클래스는 인스턴스 관리뿐만 아니라 비즈니스 로직까지 포함할 경우 단일 책임 원칙을 위반하게 된다.
- **해결**: Singleton 클래스는 오직 인스턴스 관리 역할만 담당하도록 설계해야 한다.

### 2. 멀티 쓰레드 환경에서의 문제
- 멀티 쓰레드 환경에서는 여러 쓰레드가 동시에 Singleton 인스턴스를 생성하려고 할 때 race condition 문제가 발생할 수 있다.
- **해결**:
  - Swift에서는 `static let`을 사용하여 thread-safe한 초기화를 보장한다.
  - Java에서는 `synchronized` 키워드를 사용하여 thread-safe한 접근을 구현한다.

### 3. 프로퍼티 접근 시 동시성 문제
- Singleton 내부 프로퍼티에 대해 동시적 읽기/쓰기 작업이 일어나면 데이터 덮어쓰기 문제가 발생할 수 있다.
- **해결**:
  - Swift: `DispatchQueue`의 `.concurrent` 속성을 사용하여 동시 읽기를 허용하고, `.barrier` 플래그를 사용하여 쓰기 작업을 제어한다.
  - Java: `synchronized` 블록을 활용하여 프로퍼티 접근을 제어한다.


