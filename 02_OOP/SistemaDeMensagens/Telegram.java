public class Telegram extends ServicoDeMensagem{
    
    @Override
    public void enviarMensagem(){
        verificandoInternet();
        System.out.println("Enviando mensagem pelo Telegram!!");
        salvandoMensagem();
    }

    @Override
    public void receberMensagem(){
        System.out.println("Recebendo mensagem pelo Telegram!!");
    }

}
