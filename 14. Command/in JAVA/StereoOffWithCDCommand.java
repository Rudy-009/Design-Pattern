public class StereoOffWithCDCommand implements Command {
	Stereo stereo;
	
	public StereoOffWithCDCommand(Stereo stereo) {
		this.stereo = stereo;
	}
	public void execute() {
		stereo.off();
		stereo.setVolume(0);
	}
	
	public void undo() {
	
	}
}