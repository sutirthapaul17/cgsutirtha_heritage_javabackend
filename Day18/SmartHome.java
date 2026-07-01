interface WiFiEnabled {
    void connectWiFi();
}
interface VoiceControlled {
    void voiceCommand();
}
class SmartLight implements WiFiEnabled, VoiceControlled {
    public void connectWiFi() {
        System.out.println("SmartLight connected to WiFi.");
    }
    public void voiceCommand() {
        System.out.println("Voice command executed.");
    }
}
public class SmartHome {
    public static void main(String[] args) {
        SmartLight light = new SmartLight();
        light.connectWiFi();
        light.voiceCommand();
    }
}
