import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Candidatura {
    public static void main(String[] args) throws Exception {
        System.out.println("Proceso seletivo");
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO"};
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }

    }

    static void entrandoEmContato(String candidato){
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do{
            atendeu = atender();
            continuarTentando = !atendeu;
            if(continuarTentando)
                tentativasRealizadas++;
            else
                System.out.println("Contato realizado com sucesso");
        }while(continuarTentando && tentativasRealizadas<3);

        if(atendeu)
            System.out.println("Conseguimos contato com " + candidato + " na " + tentativasRealizadas + " tentativa");
        else
            System.out.println("Não conseguimos contato com o candidato "+ candidato);
    }

    static boolean atender(){
        return new Random().nextInt(3)==1;
    }

    static void imprimirSelecionados(){
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO"};
        System.out.println("Imprimir a lista de candidatos informando o indice do elemento");
        for(int indice=0; indice < candidatos.length; indice++){
            System.out.println("O candidato de numero " + (indice+1) + " é " + candidatos[indice]);
        }

        System.out.println("Forma abreviada de interção for each");

        for(String candidato: candidatos) {
            System.out.println("O candidato selecionado foi "+ candidato);
        }
    }

    static void selecaoCandidato(){
        String [] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRIZIO", "MIRELA", "DANIELA"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;
        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " Solicitou o salario: " + salarioPretendido);
            if(salarioBase >= salarioPretendido){
                System.out.println("O candidato " + candidato + "foi selecionado para a vaga");
                candidatosSelecionados++;
            }
            candidatoAtual++;
        }
    }

    static double valorPretendido(){
        return ThreadLocalRandom.current().nextDouble(1800, 2000);
    }

    static void analiseCandidato(double salarioPretendido){
        double salario = 2000.0;

        if(salario > salarioPretendido)
            System.out.println("Ligar para candidato");
        else if( salario == salarioPretendido)
            System.out.println("Ligar para candidato com contra proposta");
        else
            System.out.println("Aguardando o resultado dos demais candidatos");

    }
}
