import Foundation

class ThreadSafeSingleton {
    static let shared = ThreadSafeSingleton()
    private init() {}

    // Concurrent queue for thread-safe property access
    private let queue = DispatchQueue(label: "com.singleton.queue", attributes: .concurrent)
    private var _someProperty: String = "Default Value"

    var someProperty: String {
        get {
            return queue.sync { _someProperty }
        }
        set {
            queue.async(flags: .barrier) { self._someProperty = newValue }
        }
    }
}
