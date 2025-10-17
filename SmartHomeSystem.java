// Main class - Smart Home Automation System
import java.util.Scanner;

public class SmartHomeSystem {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("===================================");
        System.out.println("Smart Home Automation System");
        System.out.println("Decorator + Facade Pattern Demo");
        System.out.println("===================================\n");
        
        // Create devices
        System.out.println("Creating devices...");
        Light livingRoomLight = new Light();
        Light bedroomLight = new Light();
        MusicSystem musicSystem = new MusicSystem();
        Thermostat thermostat = new Thermostat();
        SecurityCamera securityCamera = new SecurityCamera();
        System.out.println("Done!\n");
        
        // Apply decorators to devices
        System.out.println("Adding features to devices...");
        
        // Living room light with voice control and energy saving
        Device decoratedLivingRoomLight = new EnergySavingDecorator(
            new VoiceControlDecorator(livingRoomLight)
        );
        
        // Bedroom light with voice control
        Device decoratedBedroomLight = new VoiceControlDecorator(bedroomLight);
        
        // Music system with remote access and energy saving
        Device decoratedMusicSystem = new EnergySavingDecorator(
            new RemoteAccessDecorator(musicSystem)
        );
        
        // Thermostat with remote access and voice control
        Device decoratedThermostat = new VoiceControlDecorator(
            new RemoteAccessDecorator(thermostat)
        );
        
        // Security camera with remote access
        Device decoratedSecurityCamera = new RemoteAccessDecorator(securityCamera);
        
        System.out.println("Done!\n");
        
        // Create facade for easy control
        System.out.println("Setting up home automation...");
        HomeAutomationFacade homeControl = new HomeAutomationFacade(
            decoratedLivingRoomLight,
            decoratedBedroomLight,
            decoratedMusicSystem,
            decoratedThermostat,
            decoratedSecurityCamera
        );
        System.out.println("Done!\n");
        
        // Interactive menu
        boolean running = true;
        while (running) {
            System.out.println("\n========== SMART HOME MENU ==========");
            System.out.println("1. View System Status");
            System.out.println("2. Activate Night Mode");
            System.out.println("3. Start Party Mode");
            System.out.println("4. Leave Home");
            System.out.println("5. Control Living Room Light");
            System.out.println("6. Control Music System");
            System.out.println("7. Control Thermostat");
            System.out.println("8. Control Security Camera");
            System.out.println("9. Run Auto Demo");
            System.out.println("0. Exit");
            System.out.println("=====================================");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            System.out.println();
            
            switch (choice) {
                case 1:
                    homeControl.displayStatus();
                    break;
                    
                case 2:
                    homeControl.activateNightMode();
                    break;
                    
                case 3:
                    homeControl.startPartyMode();
                    break;
                    
                case 4:
                    homeControl.leaveHome();
                    break;
                    
                case 5:
                    controlLivingRoomLight(decoratedLivingRoomLight, livingRoomLight, scanner);
                    break;
                    
                case 6:
                    controlMusicSystem(decoratedMusicSystem, musicSystem, scanner);
                    break;
                    
                case 7:
                    controlThermostat(decoratedThermostat, thermostat, scanner);
                    break;
                    
                case 8:
                    controlSecurityCamera(decoratedSecurityCamera, securityCamera, scanner);
                    break;
                    
                case 9:
                    runAutoDemo(homeControl);
                    break;
                    
                case 0:
                    System.out.println("Shutting down Smart Home System...");
                    System.out.println("Goodbye!");
                    running = false;
                    break;
                    
                default:
                    System.out.println("Invalid option! Please try again.");
            }
        }
        
        scanner.close();
    }
    
    // Control individual devices
    private static void controlLivingRoomLight(Device device, Light light, Scanner scanner) {
        System.out.println("\n--- Living Room Light Control ---");
        System.out.println("1. Toggle Light");
        System.out.println("2. Dim Light");
        System.out.println("3. Turn Off");
        System.out.print("Choose: ");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                device.operate();
                break;
            case 2:
                light.dimLight();
                break;
            case 3:
                light.turnOff();
                break;
            default:
                System.out.println("Invalid option!");
        }
    }
    
    private static void controlMusicSystem(Device device, MusicSystem music, Scanner scanner) {
        System.out.println("\n--- Music System Control ---");
        System.out.println("1. Toggle Music");
        System.out.println("2. Play at specific volume");
        System.out.println("3. Stop");
        System.out.print("Choose: ");
        int choice = scanner.nextInt();
        
        switch (choice) {
            case 1:
                device.operate();
                break;
            case 2:
                System.out.print("Enter volume (0-100): ");
                int volume = scanner.nextInt();
                music.playMusic(volume);
                break;
            case 3:
                music.stop();
                break;
            default:
                System.out.println("Invalid option!");
        }
    }
    
    private static void controlThermostat(Device device, Thermostat thermo, Scanner scanner) {
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
                thermo.setEcoMode();
                break;
            case 3:
                thermo.turnOff();
                break;
            default:
                System.out.println("Invalid option!");
        }
    }
    
    private static void controlSecurityCamera(Device device, SecurityCamera camera, Scanner scanner) {
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
                camera.enable();
                break;
            default:
                System.out.println("Invalid option!");
        }
    }
    
    private static void runAutoDemo(HomeAutomationFacade homeControl) {
        System.out.println("\n=== Running Automatic Demo ===\n");
        
        System.out.println("Test 1: Party Mode");
        homeControl.startPartyMode();
        homeControl.displayStatus();
        
        System.out.println("\nTest 2: Night Mode");
        homeControl.activateNightMode();
        homeControl.displayStatus();
        
        System.out.println("\nTest 3: Leaving Home");
        homeControl.leaveHome();
        homeControl.displayStatus();
        
        System.out.println("Demo Complete!");
    }
}
