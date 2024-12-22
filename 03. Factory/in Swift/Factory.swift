protocol Vehicle { // Product
    init(name: String)
    func move() -> Void
}

protocol VehicleFactory { // Factory
    func produce(name: String) -> Vehicle
}

class Bus: Vehicle { // Concrete Product
    var name: String

    required init(name: String) {
        self.name = name
    }

    func move() {
        print("Bus \(name) Moves")
    }
}

class BusFactory: VehicleFactory { // Concrete Factory
    init(){}

    func produce(name: String) -> Vehicle {
        return Bus(name: name)
    }
}

class Boat: Vehicle { // Concrete Product
    var name: String

    required init(name: String) {
        self.name = name
    }

    func move() {
        print("Boat \(name) Moves")
    }
}

class BoatFactory: VehicleFactory { // Concrete Factory
    init(){}

    func produce(name: String) -> Vehicle {
        return Boat(name: name)
    }
}

let busFactory = BusFactory()
let bus3022 = busFactory.produce(name: "3022")
let bus4011 = busFactory.produce(name: "4011")

bus3022.move()
bus4011.move()

let boatFactory = BoatFactory()
let boat101 = boatFactory.produce(name: "101")
let boat332 = boatFactory.produce(name: "302")

boat101.move()
boat332.move()