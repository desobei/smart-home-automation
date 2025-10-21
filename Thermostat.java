// Thermostat class
public class Thermostat implements Device {
    private boolean isOn = false;
    private int temperature = 22;
    
    @Override
    public void operate() {
        isOn = !isOn;
        System.out.println("Thermostat is now " + (isOn ? "ON at " + temperature + "°C" : "OFF"));
    }
    
    @Override
    public String getStatus() {
        return "Thermostat: " + (isOn ? "ON at " + temperature + "°C" : "OFF");
    }
    
    public void setEcoMode() {
        isOn = true;
        temperature = 18;
        System.out.println("Thermostat set to ECO MODE (18°C)");
    }
    
    public void turnOff() {
        isOn = false;
        System.out.println("Thermostat turned OFF");
    }
    
    public void setTemperature(int temp) {
        temperature = temp;
        System.out.println("Thermostat temperature set to " + temp + "°C");
    }
}