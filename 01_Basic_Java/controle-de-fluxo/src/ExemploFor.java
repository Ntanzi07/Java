public class ExemploFor {
    public static void main(String[] args) {
        //for
        for (int i = 1; i <= 3; i++){
            System.out.println(i);
        }
        
        //for em Arrays
        String nomes[] = {"Nathan", "Enrico", "Marco", "Guilherme", "Rafa", "Lyniker"};
        for (String nome : nomes){
            System.out.println(nome);
        }

        //break
        for (int i = 0; i < 5; i++){
            if(i%3 == 0 && i != 0)
                break;
            System.out.println("Good day");
        }

        //continue
        for (int i = 0; i < 5; i++){
            if(i%2 == 0)
                continue;
            System.out.println("Good day " + i);
        }
    }
}
