// Security Camera class
public class SecurityCamera implements Device {
    private boolean isRecording = false;
    
    public void operate() {
        isRecording = !isRecording;
        System.out.println("Security Camera is now " + (isRecording ? "RECORDING" : "IDLE"));
    }
    
    public String getStatus() {
        return "Security Camera: " + (isRecording ? "RECORDING" : "IDLE");
    }
    
    public void enable() {
        isRecording = true;
        System.out.println("Security Camera ENABLED");
    }
}
