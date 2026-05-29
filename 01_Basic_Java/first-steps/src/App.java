public class App{
    public static void main(String[] args){
        //Tipos de variaveis:
        String name = "Nathan";
        int age = 2;
        double weight = 70.8;
        char gender = 'M';
        boolean likeCoffee = true;

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("weight: " + weight);
        System.out.println("gender: " + gender);

        System.out.print("Like coffee? ");
        
        String resultado = likeCoffee ? "yes!!" : "No!!";
        System.out.print(resultado);

        System.out.println("\n");
    }
}