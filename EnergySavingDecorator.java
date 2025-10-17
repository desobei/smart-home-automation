// Energy Saving Decorator - adds energy saving feature
public class EnergySavingDecorator extends DeviceDecorator {
    
    public EnergySavingDecorator(Device device) {
        super(device);
    }
    
    public void operate() {
        System.out.println("Energy Saving Mode activated");
        decoratedDevice.operate();
    }
    
    public String getStatus() {
        return decoratedDevice.getStatus() + " [Energy Saving]";
    }
}
