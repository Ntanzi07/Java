public abstract class ServicoDeMensagem {
    
    public abstract void enviarMensagem();
    public abstract void receberMensagem();

    protected void verificandoInternet(){
        System.out.println("Conectando...");;
        System.out.println("Conectado!!!");;
    }

    protected void salvandoMensagem(){
        System.out.println("Mensagem salva!!");
    }

}
