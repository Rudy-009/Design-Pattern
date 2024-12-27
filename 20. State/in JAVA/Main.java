public class Main {
	public static void main(String[] args) {
		 // GumballMachine 객체 생성
        GumballMachine gumballMachine = new GumballMachine(10);

        // 테스트 시나리오
       gumballMachine.insertQuarter();
       gumballMachine.turnCrank();

       gumballMachine.insertQuarter();
       gumballMachine.ejectQuarter();

       gumballMachine.insertQuarter();
       gumballMachine.turnCrank();
       gumballMachine.turnCrank(); // 중복 동작 테스트

        // 알맹이가 다 떨어질 때까지 테스트
        for (int i = 0; i < 10; i++) {
            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
        }
	}
}