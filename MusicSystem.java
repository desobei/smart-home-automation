// Music System class
public class MusicSystem implements Device {
    private boolean isPlaying = false;
    
    public void operate() {
        isPlaying = !isPlaying;
        System.out.println("Music System is now " + (isPlaying ? "PLAYING" : "STOPPED"));
    }
    
    public String getStatus() {
        return "Music System: " + (isPlaying ? "PLAYING" : "STOPPED");
    }
    
    public void playMusic(int volume) {
        isPlaying = true;
        System.out.println("Playing music at volume " + volume + "%");
    }
    
    public void stop() {
        isPlaying = false;
        System.out.println("Music System stopped");
    }
}
