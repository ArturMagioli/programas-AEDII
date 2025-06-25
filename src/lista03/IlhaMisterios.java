package lista03;

import java.util.Scanner;

public class IlhaMisterios {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Quantidade de posicoes: ");
        int quantidadePosicoes = sc.nextInt();

        int[] posicoes = new int[quantidadePosicoes];
        System.out.print("Quantidade de posicoes: ");
        for (int i = 0; i < posicoes.length; i++) {
            posicoes[i] = sc.nextInt();
        }

        System.out.print("Verificar posicao: ");
        int posicao = sc.nextInt();

        if(verificarPosicao(posicoes, 0, posicoes.length - 1, posicao)) System.out.println("Tesouro encontrado!");
        else System.out.println("Nenhum tesouro nessa posicao");
        sc.close();
    }

    private static boolean verificarPosicao(int[] posicoes, int i, int j, int posicao) {
        while (i <= j) {
            int meio = (i + j) / 2;
            
            if (posicoes[meio] == posicao) return true;
            else if (posicao > posicoes[meio]) i = meio + 1;
            else j = meio -1;
        }

        return false;
    }
}

