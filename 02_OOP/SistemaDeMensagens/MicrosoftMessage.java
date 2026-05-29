public class MicrosoftMessage extends ServicoDeMensagem {
    @Override
    public void enviarMensagem(){
        verificandoInternet();
        System.out.println("Enviando mensagem pelo Microsoft Messenger !!");
        salvandoMensagem();
    }

    @Override
    public void receberMensagem(){
        System.out.println("Recebendo mensagem pelo Microsoft Messenger !!");
    }
}
