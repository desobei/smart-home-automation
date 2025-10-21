// Abstract decorator class for devices
public abstract class DeviceDecorator implements Device {
    protected Device decoratedDevice;
    
    public DeviceDecorator(Device device) {
        this.decoratedDevice = device;
    }
    
    @Override
    public void operate() {
        decoratedDevice.operate();
    }
    
    @Override
    public String getStatus() {
        return decoratedDevice.getStatus();
    }
    
    // Add this method to access wrapped device
    public Device getWrappedDevice() {
        return decoratedDevice;
    }
}