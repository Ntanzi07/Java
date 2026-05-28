package Filas;

public class Main {
    
    public static void main(String[] args) {
        
        Fila<String> minhaFila = new Fila<String>();
        Fila<Integer> minhaSegundaFila = new Fila<Integer>();

        minhaFila.enqueue("primeiro");
        minhaFila.enqueue("segundo");

        minhaSegundaFila.enqueue(1);
        minhaSegundaFila.enqueue(2);


        System.out.println(minhaFila);
        System.out.println(minhaFila);

        System.out.println(minhaFila.dequeue());
        System.out.println(minhaFila);
        System.out.println(minhaFila.first());
    }
}
