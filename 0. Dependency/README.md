# Dependency (의존성)

> 의존성이란? 하나의 객체가 다른 객체를 필요로 하는 관계를 말한다.

> 만약 객체가 다른 객체를 프로퍼티로 갖는다면 이는 **직접 의존성**을 가진것이라고 할 수 있다.

예시
```swift
class A {
    let b = B()
}
```

## Strong Dependency (강한 의존성)

> 객체가 구현 클래스(인스턴스)에 직접 의존하고 있는 상태

다른 구현으로 쉽게 바꾸기 어렵고, 코드가 단단히 결합되어 있음 **(tight coupling)**

- 재사용성이 떨어짐
- 유연성 부족


## Weak Dependency (약한 의존성)

> 객체가 인터페이스(프로토콜) 혹은 옵션적인 존재(Optional)에 의존

- DI(의존성 주입) 혹은 옵션 타입(Optional)을 사용한다.

- 결합도가 낮다
- 테스트/확장에 용이하다
- 객체가 없어도 기본적인 동작 수행이 가능하다

```swift
protocol Engine {
    func start()
}

class GasEngine: Engine {
    func start() {
        print("Gas engine started")
    }
}

class Car {
    var engine: Engine?

    func drive() {
        engine?.start()
        print("Car is driving (even without engine)")
    }
}
```

## Indirect Dependency (간접 의존성)

> 객체가 직접 다른 객체를 만들거나 참조하지 않고, 외부를 통해 주입받거나, 별도의 중간자를 통해 사용

- 보통 팩토리 패턴, 서비스 로케이터, IoC 컨테이너 등을 통해 의존

- 유연한 아키텍처 가능
- 테스트/확장성 매우 좋음
- 추상화 레벨 높음

```swift
protocol Engine {
    func start()
}

class ElectricEngine: Engine {
    func start() {
        print("Electric engine started")
    }
}

// 간접 의존성: Car는 EngineFactory에 의존
class EngineFactory {
    func createEngine() -> Engine {
        return ElectricEngine()
    }
}

class Car {
    let engine: Engine

    init(factory: EngineFactory) {
        self.engine = factory.createEngine() // 간접적으로 의존
    }

    func drive() {
        engine.start()
        print("Car is driving")
    }
}
```

# Dependancy Injection (의존성 주입)

> 간접적으로 객체에 의존성을 주는 방식

## 장점
- 모듈을 쉽게 교체할 수 있는 구조가 되어 테스팅하기 쉽고 마이그레이션하기도 수월하다.
- 구현할 때 추상화 레이어를 넣고 이를 기반으로 구현체를 넣어 주기 떄문에 애플리케이션 의존성 방향이 일관되고, 애플리케이션을 쉽게 추론할 수 있으며, 모듈 간의 관계들이 조금 더 명확해진다.

- 출처 : 면접을 위한 CS 전공지식 노트