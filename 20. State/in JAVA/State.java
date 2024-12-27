public interface State {
	default public void insertQuarter() {
		System.out.println("invalid operation");
	}
	default public void ejectQuarter() {
		System.out.println("invalid operation");
	}
	default public void turnCrank() {
		System.out.println("invalid operation");
	}
	default public void dispense() {
		System.out.println("invalid operation");
	}
}