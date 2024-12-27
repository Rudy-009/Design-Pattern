class NoQuarterState implements State {
	GumballMachine gumballMachine;
	
	public NoQuarterState(GumballMachine gumballMachine) {
		this.gumballMachine = gumballMachine;
	}
	
	public void insertQuarter() {
		System.out.println("동전을 넣으셨습니다");
		gumballMachine.setHasQuarterState();
	}
	
	public void ejectQuarter() { System.out.println("동전을 넣어주세요."); }
	public void turnCrank() { System.out.println("동전을 넣어주세요."); }
	public void dispense() { System.out.println("동전을 넣어주세요."); }
}