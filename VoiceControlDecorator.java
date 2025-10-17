// Voice Control Decorator - adds voice control feature
public class VoiceControlDecorator extends DeviceDecorator {
    
    public VoiceControlDecorator(Device device) {
        super(device);
    }
    
    public void operate() {
        System.out.println("Voice Control: Listening...");
        decoratedDevice.operate();
    }
    
    public String getStatus() {
        return decoratedDevice.getStatus() + " [Voice Control]";
    }
}
