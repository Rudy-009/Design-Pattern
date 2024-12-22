# Factory
> 단일 제품에서 다양한 변형을 생성하는 데 사용

## 구성요소
- Product < I > : 제품은 주로 인터페이스
- ConcreteProduct < C > : 구체적인 제품
- Creator or Factory < AC > : createProduct() 라는 Product를 반환하는 추상 함수를 가지고 있음. 
```
abstract createProduct() : Product
```
- ConcreteFactory < C > : ConcreteProduct를 반환하는 createProduct() 함수를 구현

![](Factory.png)

## in Swift
swift에는 abstract 라는 개념이 존재하지 않는다. 따라서 구현된 클래스에서 반드시 오버라이드 해야한다는 메시지를 담은 함수를 구현하는 방식이 있다.

### 1. print로 Override 해야 한다고 메시지 보내기

```swift
class BaseClass {
    func abstractFunction() {
        preconditionFailure("This method must be overridden") 
    } 
}
```

```swift
class SubClass : BaseClass {
     override func abstractFunction() {
         // Override
     } 
}
```

코드 출처 : https://stackoverflow.com/questions/24110362/abstract-functions-in-swift-language

### 2. 에러 메시지 보내기

```swift
class Loadable<Model> {
    func load(from url: URL) async throws -> Model {
        fatalError("load(from:) has not been implemented")
    }
}
```

```swift
class UserLoader: Loadable<User> {
    override func load(from url: URL) async throws -> User {
        ...
    }
}
```

코드 출처 : https://www.swiftbysundell.com/articles/abstract-types-and-methods/