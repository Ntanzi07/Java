import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
public class TryCatch {
    public static void main(String[] args) {
        try{
        Scanner entrada = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Digite seu nome:");
        String nome = entrada.next();
        
        System.out.println("Digite seu sobrenome:");
        String sobreNome = entrada.next();

        System.out.println("Digite sua idade:");
        int idade = entrada.nextInt();

        System.out.println("Digite sua altura:");
        Double altura = entrada.nextDouble();

        System.out.println("ola " + nome.toUpperCase() + " " + sobreNome.toUpperCase());
        System.out.println("sua idade: "+idade+" e altura de "+ altura);
        entrada.close();
        }
        catch (InputMismatchException e){
            System.err.println("o campo idade ou altura precisam ser numericos:");
        }
    }
}
