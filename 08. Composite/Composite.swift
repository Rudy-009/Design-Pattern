protocol Component {
    func operation()
}

class Branch: Component {
    private let branchName: String

    init(name: String) {
        self.branchName = name
    }

    func operation() {
        print("Branch \(branchName) operation")
    }
}

class Leaf: Branch {
    private let leafName: String

    init(branchName: String, leafName: String) {
        self.leafName = leafName
        super.init(name: branchName) // 슈퍼클래스 초기화 호출
    }

    override func operation() {
        print("Leaf \(leafName) operation")
    }
}

class Composite: Component {
    private var components: [Component]
    
    init() {
        components = []
    }

    func add (_ component: Component) {
        components.append(component)
    }

    func remove(_ component: Component) {
        // 실제 구현에서는 참조 비교 등을 통해 제거
        components.removeAll { $0 as AnyObject === component as AnyObject }
    }

    func operation() {
        print("Composite operation start")
        for component in components {
            component.operation()
        }
        print("Composite operation end")
    }

}

let leaf1 = Leaf(branchName: "10", leafName: "1010")
let leaf2 = Leaf(branchName: "20", leafName: "2020")
let composite = Composite()
composite.add(leaf1)
composite.add(leaf2)

composite.operation()