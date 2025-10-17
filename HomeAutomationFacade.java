// Home Automation Facade - provides simple control for all devices
public class HomeAutomationFacade {
    private Device livingRoomLight;
    private Device bedroomLight;
    private Device musicSystem;
    private Device thermostat;
    private Device securityCamera;
    
    public HomeAutomationFacade(Device livingRoomLight, Device bedroomLight, 
                                Device musicSystem, Device thermostat, 
                                Device securityCamera) {
        this.livingRoomLight = livingRoomLight;
        this.bedroomLight = bedroomLight;
        this.musicSystem = musicSystem;
        this.thermostat = thermostat;
        this.securityCamera = securityCamera;
    }
    
    // Night mode - turn off lights, set eco thermostat, enable security
    public void activateNightMode() {
        System.out.println("\n=== NIGHT MODE ===");
        getBaseLight(livingRoomLight).turnOff();
        getBaseLight(bedroomLight).turnOff();
        getBaseThermostat(thermostat).setEcoMode();
        getBaseCamera(securityCamera).enable();
        System.out.println("Night Mode Activated\n");
    }
    
    // Party mode - dim lights and play music
    public void startPartyMode() {
        System.out.println("\n=== PARTY MODE ===");
        getBaseLight(livingRoomLight).dimLight();
        getBaseLight(bedroomLight).dimLight();
        getBaseMusicSystem(musicSystem).playMusic(80);
        System.out.println("Party Mode Started\n");
    }
    
    // Leave home - turn off everything and enable security
    public void leaveHome() {
        System.out.println("\n=== LEAVING HOME ===");
        getBaseLight(livingRoomLight).turnOff();
        getBaseLight(bedroomLight).turnOff();
        getBaseMusicSystem(musicSystem).stop();
        getBaseThermostat(thermostat).turnOff();
        getBaseCamera(securityCamera).enable();
        System.out.println("All systems secured\n");
    }
    
    // Display status of all devices
    public void displayStatus() {
        System.out.println("\n--- System Status ---");
        System.out.println(livingRoomLight.getStatus());
        System.out.println(bedroomLight.getStatus());
        System.out.println(musicSystem.getStatus());
        System.out.println(thermostat.getStatus());
        System.out.println(securityCamera.getStatus());
        System.out.println();
    }
    
    // Helper methods to get base devices from decorators
    private Light getBaseLight(Device device) {
        while (device instanceof DeviceDecorator) {
            device = ((DeviceDecorator) device).decoratedDevice;
        }
        return (Light) device;
    }
    
    private MusicSystem getBaseMusicSystem(Device device) {
        while (device instanceof DeviceDecorator) {
            device = ((DeviceDecorator) device).decoratedDevice;
        }
        return (MusicSystem) device;
    }
    
    private Thermostat getBaseThermostat(Device device) {
        while (device instanceof DeviceDecorator) {
            device = ((DeviceDecorator) device).decoratedDevice;
        }
        return (Thermostat) device;
    }
    
    private SecurityCamera getBaseCamera(Device device) {
        while (device instanceof DeviceDecorator) {
            device = ((DeviceDecorator) device).decoratedDevice;
        }
        return (SecurityCamera) device;
    }
}
