import java.util.Random;

class HasQuarterState implements State {
	GumballMachine gumballMachine;
	private static final Random random = new Random();
	
	public HasQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	public void insertQuarter() { System.out.println("동전은 한 개만 넣어주세요."); }
	public void ejectQuarter() { 
		System.out.println("동전이 반환됩니다");
		gumballMachine.setNoQuarterState();
	}
	public void turnCrank() {
		System.out.println("손잡이를 돌리셨습니다");
		int winner = random.nextInt(10);
		if ((winner == 0) && (gumballMachine.getCount() > 1)) {
			gumballMachine.setWinnerState();
		} else {
			gumballMachine.setSoldState();
		}
	}
	public void dispense() { System.out.println("알맹이가 나갈 수 없습니다"); }
}