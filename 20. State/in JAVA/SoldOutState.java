class SoldOutState implements State {
	GumballMachine gumballMachine;
	
	public SoldOutState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	public void insertQuarter() {
		System.out.println("알맹이가 없습니다.");
		gumballMachine.ejectQuarter();
	}
	public void ejectQuarter() {
		System.out.println("동전을 돌려드렸습니다.");
	}
	public void turnCrank() { 
		System.out.println("알맹이가 없습니다. 손잡이를 돌려도 소용 없습니다.");
	}	
	public void dispense() {
		System.out.println("나가는 알맹이는 없습니다.");
	}
}