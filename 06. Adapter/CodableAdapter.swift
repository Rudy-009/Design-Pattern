// with Perplexity

// 시나리오
/* 
당신은 JSON 데이터를 처리하는 애플리케이션을 개발하고 있습니다. 
기존 코드베이스에는 Adaptee로서 Dictionary 타입(JSON 데이터를 표현하기 위해 사용됨)이 있습니다. 
그러나 새로운 요구사항에서는 이 데이터를 Swift의 Codable 프로토콜을 따르는 객체로 변환하여 처리해야 합니다. 
기존 코드를 수정하지 않고, Dictionary를 Codable 객체처럼 사용할 수 있도록 Adapter Pattern을 구현하세요. 
*/

// 요구사항
/* 
Adaptee: Swift의 Dictionary<String, Any> 타입.
Target: Swift의 Codable 프로토콜을 따르는 객체.
Adapter: Dictionary를 Codable 객체처럼 사용할 수 있도록 변환하는 어댑터 클래스를 작성하세요.
클라이언트 코드는 Codable 인터페이스를 사용하여 데이터를 디코딩하거나 출력할 수 있어야 합니다.
*/

// 입력 데이터
// let jsonData: [String: Any] = [
//     "id": 1,
//     "name": "John Doe",
//     "email": "john.doe@example.com"
// ]

// 기대 결과
// 클라이언트는 jsonData를 User라는 Codable 객체로 변환할 수 있어야 합니다.
// 변환 후, 클라이언트는 아래와 같은 방식으로 데이터를 사용할 수 있습니다:

// let user = adapter.toCodable(User.self)
// print(user.name) // 출력: John Doe

import Foundation

struct User: Codable {
    let id: Int
    let name: String
    let email: String
}

typealias JSONDictionary = [String: Any]

struct JSONAdapter {

    private let jsonData: JSONDictionary
    
    init(jsonData: JSONDictionary) {
        self.jsonData = jsonData
    }

    func toCodable<T: Codable>(_ type: T.Type) -> T? {
        do {
            // Dictionary -> JSON Data 변환
            let data = try JSONSerialization.data(withJSONObject: jsonData, options: [])
            // JSON Data -> Codable 객체 디코딩
            let decodedObject = try JSONDecoder().decode(T.self, from: data)
            return decodedObject
        } catch {
            print("Error decoding JSON to \(T.self): \(error)")
            return nil
        }
    }

}

let jsonData: JSONDictionary = [
    "id": 1,
    "name": "John Doe",
    "email": "john.doe@example.com"
]

let adapter = JSONAdapter(jsonData: jsonData)

if let user = adapter.toCodable(User.self) {
    print("User ID:", user.id)       // 출력: User ID: 1
    print("User Name:", user.name)   // 출력: User Name: John Doe
    print("User Email:", user.email) // 출력: User Email: john.doe@example.com
} else {
    print("Failed to convert JSON to User.")
}