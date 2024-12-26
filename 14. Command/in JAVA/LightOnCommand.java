public class LightOnCommand implements Command {
	// Receiver
	Light light; // light 객체가 Receiver가 됨
	public LightOnCommand(Light light) {
		this.light = light;
	}
	public void execute() {
		light.on();
	}
	public void undo() {
		light.off();
	}
}