# Memento Pattern
> 객체의 상태를 캡슐화하여 저장하고, 이후 해당 상태를 복원할 수 있도록 지원하는 디자인 패턴.

## 구성 요소
- Originator
    - 상태를 보유하고 있는 객체. 현재 상태를 Memento로 저장하거나, Memento를 통해 상태를 복원하는 역할을 수행.
    - saveStateToMemento(): 현재 상태를 캡슐화하여 Memento 객체로 반환.
    - restoreStateFromMemento(memento: Memento): 전달받은 Memento 객체를 통해 상태를 복원.
- Memento
    - Originator의 상태를 캡슐화하여 저장하는 객체. 외부에서는 내부 상태에 접근할 수 없으며, 오직 Originator만이 이를 복원 가능.
    - 불변(Immutable) 객체로 설계되는 것이 일반적.
- Caretaker
    - Memento 객체를 관리하며, Originator의 상태를 저장하거나 복원할 때 이를 사용.
    - Originator의 내부 구조에 대해 알지 못하며, 단순히 Memento를 저장하고 전달하는 역할만 수행.

## 장점
- 객체의 이전 상태로 손쉽게 복원 가능. (Undo/Redo)
- Originator의 내부 구조가 외부에 노출되지 않음(캡슐화 유지).

## 단점
- Originator의 상태가 클 경우, Memento 객체가 메모리를 많이 차지할 수 있음.
- Caretaker가 다수의 Memento 객체를 관리해야 할 경우 복잡성이 증가.
