public class ClassicalSingleton {
    // Singleton 클래스의 유일한 인스턴스를 저장
    private static ClassicalSingleton uniqueInstance; 

    private ClassicalSingleton() { } // 생성자 은닉화
    
    public static ClassicalSingleton getInstance() {
        if (uniqueInstance == null) { // 첫 호출
                uniqueInstance = new ClassicalSingleton(); // 생성
        }
        return uniqueInstance;
    }
    // 기타 메소드
}
