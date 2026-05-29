public class SmartTv {
    boolean isOn = false;
    int channel = 1;
    int volume = 25;

    //on/off
    public void on(){
        isOn = true;
    }
    public void off(){
        isOn = false;
    }

    //Volume
    public void volumeUp(){
        volume++;
        System.out.println("Volume: " + volume);
    }
    public void volumeDown(){
        volume--;
        System.out.println("Volume: " + volume);
    }
    public void newVolume(int newValue){
        volume = newValue;
        System.out.println("Volume: " + volume);
    }

    //Channel
    public void channelUp(){
        channel++;
        System.out.println("Channel: " + channel);
    }
    public void channelDonw(){
        channel--;
        System.out.println("Channel: " + channel);
    }
    public void newChannel(int newValue){
        channel = newValue;
        System.out.println("Channel: "+ channel);
    }

}