// Light class
public class Light implements Device {
    private boolean isOn = false;
    
    public void operate() {
        isOn = !isOn;
        System.out.println("Light is now " + (isOn ? "ON" : "OFF"));
    }
    
    public String getStatus() {
        return "Light: " + (isOn ? "ON" : "OFF");
    }
    
    public void turnOff() {
        isOn = false;
        System.out.println("Light turned OFF");
    }
    
    public void dimLight() {
        System.out.println("Light dimmed to 30%");
    }
}
