import java.util.Scanner;

public class CelularDoPedrinho {

    public static void main(String[] args) {
        
        ServicoDeMensagem smi = null;
        
        Scanner input = new Scanner(System.in);

        smi = new Telegram();
  
        System.out.println("Qual app vc quer usar ?");
        String app = input.nextLine().toLowerCase();

        switch (app) {
            case "telegram":
                smi = new Telegram();
                break;
            case "msn":
                smi = new Msn();
                break;
            default:
                smi = new MicrosoftMessage();
                break;
        }

        smi.enviarMensagem();
        smi.receberMensagem();

        input.close();
    }
}