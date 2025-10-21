public class DemoRunner {
    
    private final HomeAutomationFacade homeControl;
    
    public DemoRunner(HomeAutomationFacade homeControl) {
        this.homeControl = homeControl;
    }
    
    public void runAutoDemo() {
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