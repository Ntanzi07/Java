public class Msn extends ServicoDeMensagem {

    @Override
    public void enviarMensagem(){
        verificandoInternet();
        System.out.println("Enviando mensagem pelo MSN!!");
        salvandoMensagem();
    }

    @Override
    public void receberMensagem(){
        System.out.println("Recebendo mensagem pelo MSN!!");
    }
}
