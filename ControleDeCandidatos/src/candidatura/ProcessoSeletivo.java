import java.util.concurrent.ThreadLocalRandom;
import java.util.Random;

public class ProcessoSeletivo {

    public static void main(String[] args) {
        String[] candidatos = {"LUIZ", "FILIPE", "MATHEU", "TAIS", "FERNANDA"};
        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }
    }

    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;

        do {
            atendeu = atender();
            continuarTentando = !atendeu;

            if (continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("CONTATO REALIZADO COM SUCESSO");
            }

        } while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu) {
            System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + "ª TENTATIVA");
        } else {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ". NÚMERO MÁXIMO DE TENTATIVAS (" + tentativasRealizadas + ") REALIZADAS.");
        }

        System.out.println("--------------------------------------------------");
    }

    static boolean atender() {
        return new Random().nextInt(3) == 1; // 1 chance em 3 de atender
    }

    static void imprimirSelecionados() {
        String[] candidatos = {"LUIZ", "FILIPE", "MATHEU", "TAIS", "FERNANDA"};

        System.out.println("Imprimindo a lista de candidatos informando o índice do elemento:");
        for (int indice = 0; indice < candidatos.length; indice++) {
            System.out.println("O candidato de nº " + indice + " é " + candidatos[indice]);
        }

        System.out.println("Forma alternativa (for-each):");
        for (String candidato : candidatos) {
            System.out.println("O candidato selecionado é " + candidato);
        }
    }

    static void selecaoCandidato() {
        String[] candidatos = {"LUIZ", "FILIPE", "MATHEU", "TAIS", "FERNANDA", "ELZITA", "LUZIA", "GRAZIELLY", "LUZIELLY", "SIPRIOLA"};

        int candidatosSelecionados = 0;
        int candidatoAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatoAtual < candidatos.length) {
            String candidato = candidatos[candidatoAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salário: R$" + String.format("%.2f", salarioPretendido));

            if (salarioBase >= salarioPretendido) {
                System.out.println("-> O candidato " + candidato + " foi selecionado para a vaga.");
                candidatosSelecionados++;
            }

            candidatoAtual++;
        }
    }

    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    static void analisarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;

        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }
    }
}
