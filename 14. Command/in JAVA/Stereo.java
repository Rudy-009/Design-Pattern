public class Stereo {
	
	private boolean isOn;
	private int volume;
	private String name;
	
	public Stereo(String name) {
		this.name = name;
		this.isOn = false;
		this.volume = 0;
	}
	
	public void on(){
		System.out.println(name + ", Stereo On");
		if (!this.isOn) {
			isOn = true;
		}
	}
	
	public void off() {
		System.out.println(name + ", Stereo Off");
		this.isOn = false;
	}
	
	public void setCD() {
		System.out.println(name + ", Stereo Set CD");
	}
	
	public void setVolume(int volume) {
		this.volume = volume;
		System.out.println(name + ", Volume to " + this.volume);
	}
	
}