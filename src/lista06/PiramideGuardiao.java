package lista06;

import java.util.ArrayList;

public class PiramideGuardiao {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> piramide = new ArrayList<>();
        ArrayList<Integer> sequenciaPossivel = new ArrayList<>();
        final int S = 10;
        int somaAtual = 0;

        preencherPiramide(piramide);
    
        mostrarSequenciasPossiveis(piramide, 0, 0, sequenciaPossivel, S, somaAtual);
    }

    private static void mostrarSequenciasPossiveis(ArrayList<ArrayList<Integer>> piramide, int linha, int coluna, ArrayList<Integer> sequenciaPossivel, int S, int somaAtual) {
        if (somaAtual > S)
            return;

        if (linha < piramide.size() && coluna < piramide.get(linha).size()) {
            sequenciaPossivel.addLast(piramide.get(linha).get(coluna));
            somaAtual += piramide.get(linha).get(coluna);

            if (somaAtual == S && linha == piramide.size() - 1) {
                System.out.println("Sequencia possivel: " + sequenciaPossivel);
            }   

            mostrarSequenciasPossiveis(piramide, linha + 1, coluna, sequenciaPossivel, S, somaAtual);
            mostrarSequenciasPossiveis(piramide, linha + 1, coluna + 1, sequenciaPossivel, S, somaAtual);
            sequenciaPossivel.removeLast();
        }
    }

    private static void preencherPiramide(ArrayList<ArrayList<Integer>> piramide) {
        ArrayList<Integer> linha1 = new ArrayList<>();
        linha1.add(0);

        ArrayList<Integer> linha2 = new ArrayList<>();
        linha2.add(1);
        linha2.add(2);

        ArrayList<Integer> linha3 = new ArrayList<>();
        linha3.add(3);
        linha3.add(4);
        linha3.add(5);

        ArrayList<Integer> linha4 = new ArrayList<>();
        linha4.add(6);
        linha4.add(7);
        linha4.add(8);
        linha4.add(9);

        piramide.add(linha1);
        piramide.add(linha2);
        piramide.add(linha3);
        piramide.add(linha4);
    }
}