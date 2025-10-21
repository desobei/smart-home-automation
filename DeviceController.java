import java.util.Scanner;

public class DeviceController {
    
    private final Scanner scanner;
    
    public DeviceController(Scanner scanner) {
        this.scanner = scanner;
    }
    
    public void controlLivingRoomLight(Device device) {
        System.out.println("\n--- Living Room Light Control ---");
        System.out.println("1. Toggle Light");
        System.out.println("2. Turn Off");
        System.out.print("Choose: ");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                device.operate();
                break;
            case 2:
                ((Light) getBaseDevice(device)).turnOff();
                break;
            default:
                System.out.println("Invalid option!");
        }
    }
    
    public void controlMusicSystem(Device device) {
        System.out.println("\n--- Music System Control ---");
        System.out.println("1. Toggle Music");
        System.out.println("2. Stop");
        System.out.print("Choose: ");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                device.operate();
                break;
            case 2:
                ((MusicSystem) getBaseDevice(device)).stop();
                break;
            default:
                System.out.println("Invalid option!");
        }
    }
    
    public void controlThermostat(Device device) {
        System.out.println("\n--- Thermostat Control ---");
        System.out.println("1. Toggle Thermostat");
        System.out.println("2. Set Eco Mode");
        System.out.println("3. Turn Off");
        System.out.print("Choose: ");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                device.operate();
                break;
            case 2:
                ((Thermostat) getBaseDevice(device)).setEcoMode();
                break;
            case 3:
                ((Thermostat) getBaseDevice(device)).turnOff();
                break;
            default:
                System.out.println("Invalid option!");
        }
    }
    
    public void controlSecurityCamera(Device device) {
        System.out.println("\n--- Security Camera Control ---");
        System.out.println("1. Toggle Camera");
        System.out.println("2. Enable Recording");
        System.out.print("Choose: ");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                device.operate();
                break;
            case 2:
                ((SecurityCamera) getBaseDevice(device)).enable();
                break;
            default:
                System.out.println("Invalid option!");
        }
    }
    
    private Device getBaseDevice(Device device) {
        Device current = device;
        while (current instanceof DeviceDecorator) {
            current = ((DeviceDecorator) current).getWrappedDevice();
        }
        return current;
    }
}