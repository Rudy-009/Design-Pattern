# Template Method
> 알고리즘의 뼈대를 정의하고, 일부를 서브 클래스로 위임함. 템플릿 메소드는 알고리즘 구조를 변경하지 않고 알고리즘의 일부 내용을 서브 클래스에서 재정의할 수 있도록함.

- idea) 거대한 하나의 메서드를 자식클래스에서 공통으로 나타나는 부분과 자식클래스에서 구현해야 하는 부분으로 메서드를 나누어 하나의 Template Method와 그 안에 여러 메서드들을 배치하여 코드의 양을 줄인다.

## 문제 배경

- 알고리즘들을 캡슐화시키면서 중복되는 코드가 여러 클래스에 존재함

- 자식 클래스를 여러개 만들어도 중복되는 코드들이 존재할 수 있다. 중복되는 코드는 부모 클래스에서 미리 정의하고 나머지를 자식클래스에서 구현하도록 한다.

## 헐리우드 원칙(Hollywood Principle)
> "우리가 연락할 테니 먼저 연락하지마"

- 저수준의 구성 요소에서 시스템에 접속 가능하지만 사용 순서나 방법은 고수준에서 결정, 저수준은 이를 모른다.

## 예시

```java
public abstaract class Above {
	public final void process() { // 템플릿 메서드를 나타내는 부분
		start();
		doing();
		done();
	}
	public void start() { // 공통부분
        ...
    } 
	public abstract doing();// 차이나는 부분
	public void done() { // 공통부분
        ...
    } 
}

class Child extends Above { 
	public abstract doing() { // 공통이 아닌 부분은 자식클래스에서 구현
		
	}
}
```