protocol Fly {
    func fly()
}

struct Eagle : Fly {
    func fly() {
        print("Eagle Flies")
    }
}

struct Pigeon : Fly {
    func fly() {
        print("Pigeon Flies")
    }
}

var bird: Fly = Eagle() // Fly 프로토콜을 따르는 객체의 인스턴스를 할당할 수 있다.
bird.fly()
bird = Pigeon()
bird.fly()