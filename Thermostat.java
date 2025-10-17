// Thermostat class
public class Thermostat implements Device {
    private int temperature = 22;
    private String mode = "normal";
    
    public void operate() {
        System.out.println("Thermostat operating at " + temperature + "°C");
    }
    
    public String getStatus() {
        return "Thermostat: " + temperature + "°C (" + mode + " mode)";
    }
    
    public void setEcoMode() {
        mode = "eco";
        temperature = 18;
        System.out.println("Thermostat set to ECO mode at " + temperature + "°C");
    }
    
    public void turnOff() {
        System.out.println("Thermostat turned OFF");
    }
}
