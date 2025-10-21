import java.util.Scanner;

public class SmartHomeController {
    
    private final HomeAutomationFacade homeControl;
    private final SmartHomeInitializer initializer;
    private final Scanner scanner;
    private final DeviceController deviceController;
    
    public SmartHomeController(SmartHomeInitializer initializer) {
        this.initializer = initializer;
        this.homeControl = initializer.getHomeControl();
        this.scanner = new Scanner(System.in);
        this.deviceController = new DeviceController(scanner);
    }
    
    public void start() {
        printHeader();
        runMenu();
        shutdown();
    }
    
    private void printHeader() {
        System.out.println("===================================");
        System.out.println("Smart Home Automation System");
        System.out.println("Decorator + Facade Pattern Demo");
        System.out.println("===================================\n");
    }
    
    private void runMenu() {
        boolean running = true;
        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            System.out.println();
            running = handleMenuChoice(choice);
        }
    }
    
    private void displayMenu() {
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
        System.out.println("10. Add New Device");
        System.out.println("11. Remove Device");
        System.out.println("12. List All Devices");
        System.out.println("0. Exit");
        System.out.println("=====================================");
        System.out.print("Choose an option: ");
    }
    
    private boolean handleMenuChoice(int choice) {
        switch (choice) {
            case 1:
                homeControl.displayStatus();
                return true;
            case 2:
                homeControl.activateNightMode();
                return true;
            case 3:
                homeControl.startPartyMode();
                return true;
            case 4:
                homeControl.leaveHome();
                return true;
            case 5:
                deviceController.controlLivingRoomLight(initializer.getLivingRoomLight());
                return true;
            case 6:
                deviceController.controlMusicSystem(initializer.getMusicSystem());
                return true;
            case 7:
                deviceController.controlThermostat(initializer.getThermostat());
                return true;
            case 8:
                deviceController.controlSecurityCamera(initializer.getSecurityCamera());
                return true;
            case 9:
                new DemoRunner(homeControl).runAutoDemo();
                return true;
            case 10:
                addNewDevice();
                return true;
            case 11:
                removeDevice();
                return true;
            case 12:
                initializer.listAllDevices();
                return true;
            case 0:
                return false;
            default:
                System.out.println("Invalid option! Please try again.");
                return true;
        }
    }
    
    private void addNewDevice() {
        System.out.println("\n=== Add New Device ===");
        System.out.println("1. Light");
        System.out.println("2. Music System");
        System.out.println("3. Thermostat");
        System.out.println("4. Security Camera");
        System.out.print("Select device type: ");
        int type = scanner.nextInt();
        scanner.nextLine();
        
        System.out.print("Enter device name: ");
        String name = scanner.nextLine();
        
        Device baseDevice = createBaseDevice(type);
        if (baseDevice == null) {
            System.out.println("Invalid device type!");
            return;
        }
        
        Device decoratedDevice = applyDecoratorOptions(baseDevice);
        initializer.addCustomDevice(name, decoratedDevice);
    }
    
    private Device createBaseDevice(int type) {
        switch (type) {
            case 1: return new Light();
            case 2: return new MusicSystem();
            case 3: return new Thermostat();
            case 4: return new SecurityCamera();
            default: return null;
        }
    }
    
    private Device applyDecoratorOptions(Device device) {
        System.out.println("\n=== Add Features ===");
        System.out.print("Add Voice Control? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            device = new VoiceControlDecorator(device);
        }
        
        System.out.print("Add Energy Saving? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            device = new EnergySavingDecorator(device);
        }
        
        System.out.print("Add Remote Access? (y/n): ");
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            device = new RemoteAccessDecorator(device);
        }
        
        return device;
    }
    
    private void removeDevice() {
        System.out.println("\n=== Remove Device ===");
        if (initializer.getCustomDevices().isEmpty()) {
            System.out.println("No custom devices to remove!");
            return;
        }
        
        System.out.println("Custom devices:");
        int i = 1;
        for (String name : initializer.getCustomDevices().keySet()) {
            System.out.println(i++ + ". " + name);
        }
        
        System.out.print("Enter device name to remove: ");
        String name = scanner.nextLine();
        initializer.removeCustomDevice(name);
    }
    
    private void shutdown() {
        System.out.println("\nShutting down Smart Home System...");
        System.out.println("Goodbye!");
        scanner.close();
    }
}