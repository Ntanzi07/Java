import java.util.Scanner;

public class User {
    public static void main(String[] args) throws Exception {
        SmartTv smarTv = new SmartTv();

        Scanner entrada = new Scanner(System.in);

        System.out.println("Tv is on?: " + smarTv.isOn);
        System.out.println("your channel is: "+ smarTv.channel);
        System.out.println("your volume is: " + smarTv.volume);

        smarTv.on();
        System.out.println("Tv is on?: " + smarTv.isOn);

        smarTv.volumeUp();
        smarTv.volumeUp();
        smarTv.volumeUp();
        smarTv.volumeDown();

        System.out.println("new volume:");
        smarTv.newVolume(entrada.nextInt());

        smarTv.channelUp();
        smarTv.channelUp();
        smarTv.channelDonw();
        System.out.println("new channel:");
        smarTv.newChannel(entrada.nextInt());

        
        entrada.close();
    }
}
