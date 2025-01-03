public class Main {
    public static void main(String[] args) {
        System.out.println("Executing");
        Parent p  = new Parent();  // (1) 특정 타입의 참조변수는 같은 타입의 인스턴스를 참조할 수 있다.
        p.who();
        Child  c  = new Child();   // (1) c : 참조변수 (주소), Child()는 인스턴스 실제로 구현된 객체.
        c.who();
        Parent px = new Child();   // (2) 부모는 자식타입의 인스턴스를 참조할 수 있다.
        px.who();
        // Child  cx = new Parent(); // (3) 자식은 부모타입의 인스턴스를 참조할 수 없다. 
    }
}

class Parent {
    public Parent() {}

    public void who() {
        System.out.println("I'm a Parent");
    }
}

class Child extends Parent {
    public Child() {
        super();
    }

    @Override
    public void who() {
        System.out.println("I'm a Child");
    }
}