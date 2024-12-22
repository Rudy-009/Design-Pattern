protocol Chair { // Product
    init(code: String)
    func info() -> Void
}

protocol Desk { // Product
    init(code: String)
    func info() -> Void
}

protocol FactoryProtocol { // Factory
    func produceChair(code: String) -> Chair
    func produceDesk(code: String) -> Desk
}

class ChairA: Chair { // Concrete Product
    var code: String

    required init(code: String) {
        self.code = code
    }

    func info() {
        print("ChairA serial code \(code)")
    }
}

class ChairB: Chair { // Concrete Product
    var code: String
    
    required init(code: String) {
        self.code = code
    }

    func info() {
        print("ChairB serial code \(code)")
    }
}

class DeskA: Desk { // Concrete Product
    var code: String

    required init(code: String) {
        self.code = code
    }

    func info() {
        print("DeskA serial code \(code)")
    }
}

class DeskB: Desk { // Concrete Product
    var code: String

    required init(code: String) {
        self.code = code
    }

    func info() {
        print("DeskB serial code \(code)")
    }
}

class AFactory: FactoryProtocol {

    init(){}

    func produceChair(code: String) -> Chair {
        return ChairA(code: code)
    }

    func produceDesk(code: String) -> Desk {
        return DeskA(code: code)
    }
}

class BFactory: FactoryProtocol {

    init(){}

    func produceChair(code: String) -> Chair {
        return ChairB(code: code)
    }

    func produceDesk(code: String) -> Desk {
        return DeskB(code: code)
    }
}

let typeAFactory = AFactory()
let typeAChair = typeAFactory.produceChair(code: "3022")
let typeADesk = typeAFactory.produceDesk(code: "4011")

typeAChair.info()
typeADesk.info()

let typeBFactory = BFactory()
let typeBChair = typeAFactory.produceChair(code: "3022")
let typeBDesk = typeAFactory.produceDesk(code: "4011")

typeBChair.info()
typeBDesk.info()
