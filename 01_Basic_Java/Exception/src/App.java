import java.text.NumberFormat;
import java.text.ParseException;

public class App {
    public static void main(String[] args) throws CepException {
        Number valor;
        try{
            valor = NumberFormat.getInstance().parse("a1.75");
            System.out.println(valor);
        }catch (ParseException e){
            e.printStackTrace();
        }
    }
}
