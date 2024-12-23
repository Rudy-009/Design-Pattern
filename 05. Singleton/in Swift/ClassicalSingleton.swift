class ClassicalSingleton {
    private static var uniqueInstance: ClassicalSingleton?; // thread-safe 초기화 X
    
    private init() {}

    static func getInstance() -> ClassicalSingleton { 
        if let singleton: ClassicalSingleton = uniqueInstance {
            return singleton
        }
        
        uniqueInstance = ClassicalSingleton()
        return uniqueInstance!
    }
}

class ClassicalSingleton2 {
    // 메모리에 크게 문제가 되지 않는 경우 나중에 만들 필요는 없다.
    private static let uniqueInstance = ClassicalSingleton2() // thread-safe 초기화

    private init() {}

    static func getInstance() -> ClassicalSingleton2 {
        return uniqueInstance
    }
}