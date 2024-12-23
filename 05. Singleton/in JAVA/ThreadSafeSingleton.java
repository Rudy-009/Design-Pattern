// Java 구현 예제

// Classical Singleton with Lazy Initialization

public class ThreadSafeSingleton {

    private volatile static ThreadSafeSingleton inst;
    
    private ThreadSafeSingleton() { }
    
    public static ThreadSafeSingleton getInstance() {
        if (inst == null) {
            synchronized (ThreadSafeSingleton.class) {
                if (inst == null) {
                    inst = new ThreadSafeSingleton();
                }
            }
        }
        return inst;
    }
    // 나머지 멤버 함수 코드
}
