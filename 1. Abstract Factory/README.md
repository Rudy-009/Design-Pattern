# Abstract Factory
> 관련된 여러 제품군의 다양한 형태를 생성하는 데 사용됩니다.

## 구성요소
- AbstractProduct A...Z < AC >: 다양한 형태의 제품
- AbstractFactory < I > : 모든 제품군을 생성하는 추상 메서드가 있음
```
abstract createProduct A...Z() : Product A...Z
```

![](./Abstract_Factory.png)
