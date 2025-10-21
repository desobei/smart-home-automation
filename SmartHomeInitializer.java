import java.util.*;

public class SmartHomeInitializer {
    
    private Device livingRoomLight;
    private Device bedroomLight;
    private Device musicSystem;
    private Device thermostat;
    private Device securityCamera;
    private HomeAutomationFacade homeControl;
    
    // Additional devices storage
    private Map<String, Device> customDevices;
    
    public SmartHomeInitializer() {
        customDevices = new HashMap<>();
    }
    
    public void initialize() {
        System.out.println("Creating devices...");
        Light livingRoomLightBase = new Light();
        Light bedroomLightBase = new Light();
        MusicSystem musicSystemBase = new MusicSystem();
        Thermostat thermostatBase = new Thermostat();
        SecurityCamera securityCameraBase = new SecurityCamera();
        System.out.println("Done!\n");
        
        System.out.println("Adding features to devices...");
        applyDecorators(livingRoomLightBase, bedroomLightBase, musicSystemBase, 
                       thermostatBase, securityCameraBase);
        System.out.println("Done!\n");
        
        System.out.println("Setting up home automation...");
        homeControl = new HomeAutomationFacade(
            livingRoomLight, bedroomLight, musicSystem, thermostat, securityCamera
        );
        System.out.println("Done!\n");
    }
    
    private void applyDecorators(Light livingRoomLightBase, Light bedroomLightBase,
                                 MusicSystem musicSystemBase, Thermostat thermostatBase,
                                 SecurityCamera securityCameraBase) {
        livingRoomLight = new EnergySavingDecorator(
            new VoiceControlDecorator(livingRoomLightBase)
        );
        
        bedroomLight = new VoiceControlDecorator(bedroomLightBase);
        
        musicSystem = new EnergySavingDecorator(
            new RemoteAccessDecorator(musicSystemBase)
        );
        
        thermostat = new VoiceControlDecorator(
            new RemoteAccessDecorator(thermostatBase)
        );
        
        securityCamera = new RemoteAccessDecorator(securityCameraBase);
    }
    
    // Add custom device
    public void addCustomDevice(String name, Device device) {
        customDevices.put(name, device);
        System.out.println("Device '" + name + "' added successfully!");
    }
    
    // Remove custom device
    public boolean removeCustomDevice(String name) {
        if (customDevices.containsKey(name)) {
            customDevices.remove(name);
            System.out.println("Device '" + name + "' removed successfully!");
            return true;
        }
        System.out.println("Device '" + name + "' not found!");
        return false;
    }
    
    // Get all custom devices
    public Map<String, Device> getCustomDevices() {
        return new HashMap<>(customDevices);
    }
    
    // List all devices
    public void listAllDevices() {
        System.out.println("\n=== All Devices ===");
        System.out.println("1. Living Room Light - " + livingRoomLight.getStatus());
        System.out.println("2. Bedroom Light - " + bedroomLight.getStatus());
        System.out.println("3. Music System - " + musicSystem.getStatus());
        System.out.println("4. Thermostat - " + thermostat.getStatus());
        System.out.println("5. Security Camera - " + securityCamera.getStatus());
        
        if (!customDevices.isEmpty()) {
            System.out.println("\nCustom Devices:");
            int i = 6;
            for (Map.Entry<String, Device> entry : customDevices.entrySet()) {
                System.out.println(i++ + ". " + entry.getKey() + " - " + entry.getValue().getStatus());
            }
        }
        System.out.println();
    }
    
    public HomeAutomationFacade getHomeControl() {
        return homeControl;
    }
    
    public Device getLivingRoomLight() {
        return livingRoomLight;
    }
    
    public Device getBedroomLight() {
        return bedroomLight;
    }
    
    public Device getMusicSystem() {
        return musicSystem;
    }
    
    public Device getThermostat() {
        return thermostat;
    }
    
    public Device getSecurityCamera() {
        return securityCamera;
    }
}