public class RemoteLoader {
	public static void main(String[] args) {
		
		RemoteControl remoteControl = new RemoteControl();
		
		Light livingRoomLight = new Light("Living Room");
		LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
		LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
		remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
		
		//Light kitchenLight = new Light("Kitchen");
		//LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
		//LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);
		//remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
		
		//Stereo stereo = new Stereo("Living Room");
		//StereoOnWithCDCommand stereoOnWithCD = new StereoOnWithCDCommand(stereo);
		//StereoOffWithCDCommand stereoOff = new StereoOffWithCDCommand(stereo);
		//remoteControl.setCommand(3, stereoOnWithCD, stereoOff);
		
		remoteControl.onButtonWasPushed(0);
		remoteControl.offButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
		remoteControl.offButtonWasPushed(0);
		remoteControl.onButtonWasPushed(0);
		System.out.println(remoteControl);
		remoteControl.undoButtonWasPushed();
		
		//remoteControl.onButtonWasPushed(1);
		//remoteControl.offButtonWasPushed(1);
		//remoteControl.onButtonWasPushed(3);
		//remoteControl.offButtonWasPushed(3);
	}
}