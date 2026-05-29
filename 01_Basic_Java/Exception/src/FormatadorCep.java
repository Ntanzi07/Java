public class FormatadorCep {
    public static void main(String[] args) {
        try {
            String cepFormat = formatarCep("23.765-065");
            System.out.println(cepFormat);
        } catch (CepException e) {
           System.out.println("O cep não cumpre as regras");
        }

    }
    static String formatarCep(String cep) throws CepException{
        if(cep.length() != 8)
            throw new CepException();

        return "23.765-065";
    }
}
