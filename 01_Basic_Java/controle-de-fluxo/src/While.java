import java.util.concurrent.ThreadLocalRandom;
public class While {
    public static void main(String[] args) {
        double mesada = 50.0;
         while (mesada>0) {
            double valorDoce = valorAleatorio();
            if (valorDoce > mesada) 
                valorDoce = mesada;
            
            System.out.println("\nDoce no valor de: " + valorDoce + " adicionado ao carrinho!");
            mesada -= valorDoce;
            System.out.println("Mesada = " + mesada);
         }
         
    }

    private static double valorAleatorio(){
        return ThreadLocalRandom.current().nextDouble(2, 8);
    }

}
