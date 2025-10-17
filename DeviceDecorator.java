// Abstract decorator class for devices
public abstract class DeviceDecorator implements Device {
    protected Device decoratedDevice;
    
    public DeviceDecorator(Device device) {
        this.decoratedDevice = device;
    }
    
    public void operate() {
        decoratedDevice.operate();
    }
    
    public String getStatus() {
        return decoratedDevice.getStatus();
    }
}
