# 연습 문제: Swift로 Bridge Pattern 구현하기

## 문제 설명
당신은 다양한 알림(Notification) 시스템을 설계해야 합니다. 알림은 이메일이나 SMS 같은 **전송 방식(Implementation)**과 함께, 일반 알림 또는 긴급 알림 같은 **알림 유형(Abstraction)**으로 나뉩니다. 새로운 전송 방식이나 새로운 알림 유형이 추가되더라도 기존 코드를 최소한으로 수정할 수 있는 구조를 만들어야 합니다.
## 요구 사항
- 알림 유형 (Abstraction):
    - 일반 알림 (NormalNotification)
    - 긴급 알림 (UrgentNotification)
- 전송 방식 (Implementation):
    - 이메일 (EmailSender)
    - SMS (SMSSender)

- 클라이언트는 각 알림 유형과 전송 방식을 조합하여 알림을 보낼 수 있어야 합니다.

## 예시 시나리오
- "긴급 알림"을 "SMS"로 전송.
- "일반 알림"을 "이메일"로 전송.

## 제약 조건
- 새로운 전송 방식(예: Push Notification)이나 새로운 알림 유형(예: Critical Notification)이 추가되더라도 기존 코드를 수정하지 않고 확장 가능해야 합니다.

- Bridge 패턴의 구조를 활용하세요.

## 출력 예시
```swift
// 긴급 알림을 SMS로 전송
UrgentNotification(SMSSender).send(message: "This is an urgent message!")

// 일반 알림을 이메일로 전송
NormalNotification(EmailSender).send(message: "This is a normal message.")
```
> 힌트: 
Abstraction은 Notification 클래스로 만들고, 이를 상속받아 NormalNotification과 UrgentNotification을 구현하세요.
Implementation은 MessageSender 프로토콜로 정의하고, 이를 채택한 EmailSender와 SMSSender를 구현하세요.
클라이언트는 Notification과 MessageSender를 조합하여 사용합니다.