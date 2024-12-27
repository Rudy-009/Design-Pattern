protocol Prototype {
    func clone() -> Self
}

class Apple: Prototype {
    private var name: String

    required init(name: String) {
        self.name = name
    }

    func clone() -> Self {
        return Self(name: self.name)
    }

    func changeName(to newName: String) {
        self.name = newName
    }

    func info() {
        print("name is \(self.name)")
    }
}


let apple01: Apple = Apple(name: "01")
let apple02 = apple01.clone()

apple01.info()
apple02.info()

apple01.changeName(to: "03")
apple01.info()
apple02.info()

