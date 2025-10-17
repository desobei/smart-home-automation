// Remote Access Decorator - adds remote control feature
public class RemoteAccessDecorator extends DeviceDecorator {
    
    public RemoteAccessDecorator(Device device) {
        super(device);
    }
    
    public void operate() {
        System.out.println("Remote Access: Connected");
        decoratedDevice.operate();
    }
    
    public String getStatus() {
        return decoratedDevice.getStatus() + " [Remote Access]";
    }
}
