protocol Handler {
    var nextHandler: Handler? { get set }
    func handle(request: String)
}

class ConcreteHandlerA: Handler {
    var nextHandler: Handler?

    func handle(request: String) {
        if request == "A" {
            print("Handler A가 요청 처리")
        } else {
            print("HandlerA에서 처리 불가")
            nextHandler?.handle(request: request)
        }
    }
}

class ConcreteHandlerB: Handler {
    var nextHandler: Handler?

    func handle(request: String) {
        if request == "B" {
            print("Handler B가 요청 처리")
        } else {
            nextHandler?.handle(request: request)
        }
    }
}

// 체인 구성
let handlerA: ConcreteHandlerA = ConcreteHandlerA()
let handlerB: ConcreteHandlerB = ConcreteHandlerB()
handlerA.nextHandler = handlerB

// 요청 처리
handlerA.handle(request: "A") 
// 출력: "Handler A가 요청 처리"
handlerA.handle(request: "B") 
// 출력: 
// "HandlerA에서 처리 불가"
// "Handler B가 요청 처리"