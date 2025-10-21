public class SmartHomeSystem {
    
    public static void main(String[] args) {
        SmartHomeInitializer initializer = new SmartHomeInitializer();
        initializer.initialize();
        
        SmartHomeController controller = new SmartHomeController(initializer);
        controller.start();
    }
}