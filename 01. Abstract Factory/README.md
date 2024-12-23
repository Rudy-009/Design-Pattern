# Abstract Factory
> 관련된 여러 제품군의 다양한 형태를 생성하는 데 사용됩니다.

## 구성요소
- AbstractProduct A...Z < AC >: 제품에 관해 공통된 부분은 메서드로 구현하고, 제품 마다 나뉠 수 있는 부분은 추상 클래스로 구현한다. 
- AbstractFactory < I > : 각 제품군을 생성하는 추상 메서드가 있다.
```
abstract createProduct A...Z() : Product A...Z
```

![](./Abstract_Factory.png)
