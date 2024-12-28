class Notification { // Abstraction
    let sender: MessageSender

    init(sender: MessageSender) {
        self.sender = sender
    }

    func send(message: String) {
        sender.push(message)
    }
}

protocol MessageSender { // Implementaion
    func push(_ message: String)
}

class NormalNotification: Notification {
    override func send(message: String) {
        sender.push("(Normal)" + message)
    }
}

class UrgentNotification: Notification {
    override func send(message: String) {
        sender.push("(Urgent)" + message)
    }
}

class SMSSender: MessageSender {
    func push(_ message: String) {
        print("SMS: \(message)")
    }
}

class EmailSender: MessageSender {
    func push(_ message: String) { 
        print("Email: \(message)")
    }
}

let smsSender = SMSSender()
let emailSender = EmailSender()

UrgentNotification(sender: smsSender).send(message: "Earthquake!!")
NormalNotification(sender: emailSender).send(message: "Promotional!!")
