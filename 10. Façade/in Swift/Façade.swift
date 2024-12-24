class ComponentA {
    init() {}

    func on(){
        print("On")
    }
}

class ComponentB {
    init() {}

    func working() {
        print("Working")
    }
}

class ComponentC {
    init() {}

    func off() {
        print("Off")
    }
}

class Facade {
    private let a: ComponentA
    private let b: ComponentB
    private let c: ComponentC

    init(a: ComponentA, b: ComponentB, c: ComponentC) {
        self.a = a
        self.b = b
        self.c = c
    }

    func complexMethod() {
        a.on()
        b.working()
        c.off()
    }
}

let a = ComponentA()
let b = ComponentB()
let c = ComponentC()

let facade = Facade(a: a, b: b, c: c)
facade.complexMethod()
