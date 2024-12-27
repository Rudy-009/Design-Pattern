public class GumballMachine {
    State state;
    State noQuarterState;
    State hasQuarterState;
    State soldState;
    State soldOutState;
    State winnerState;
    int count = 0;
    int balance = 0; // 기계에 동전이 얼마가 있는지 저장
    int waitingQuarter = 0; // 아직 계산이 안된 동전이 있음 (turnCrank or eject)
    
    public GumballMachine(int numberGumballs) {
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        soldOutState = new SoldOutState(this);
        winnerState = new WinnerState(this);
        state =  soldOutState;
        this.count = numberGumballs;
        if (numberGumballs > 0 ) {
            state = noQuarterState;
        }
    }
    
    public void insertQuarter() { state.insertQuarter(); } 
    public void ejectQuarter() { state.ejectQuarter(); }
    public void turnCrank() { state.turnCrank(); state.dispense(); }
    
    public void setNoQuarterState() { this.state = noQuarterState; }
    public void setHasQuarterState() { this.state = hasQuarterState; } 
    public void setSoldState() { this.state = soldState; } 
    public void setSoldOutState() { this.state = soldOutState; }
    public void setWinnerState() { this.state = winnerState; }
    
    public void releaseBall() {
        System.out.println("A gumball comes rolling out the slot…");
        if (count != 0)
            count = count - 1;
    }
    
    public int getCount() {
        return this.count;
    }
    
    public State getState() {
        return this.state;
    }
}