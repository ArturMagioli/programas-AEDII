package lista04;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
 * path: C:\Users\artur\Code\AEDII\codigos-estrutura-dados-ii\src\lista04\testes
 */

public class MergeSort {
    public static void main(String[] args) {
        File file = new File(args[0]);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            
            String[] split = sc.nextLine().split(",");

            int[] inteiros = new int[split.length];

            for(int i = 0; i < inteiros.length; i++) inteiros[i] = Integer.parseInt(split[i]);

            double tempoInicial = System.currentTimeMillis();

            mergeSort(inteiros, 0, inteiros.length - 1);

            System.out.println("Tempo de execução: " + (System.currentTimeMillis() - tempoInicial));

        }
        catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        finally {
            if (sc != null) sc.close();
        }
    }

    private static void mergeSort(int[] vet, int p, int r) {
        if (p < r) {
            int q = (p + r) / 2;

            mergeSort(vet, p, q);
            mergeSort(vet, q + 1, r);

            merge(vet, p, q, r);
        }
    }

    private static void merge(int[] vet, int p, int q, int r) {
        int[] vet1 = new int[q - p + 1];
        int[] vet2 = new int[r - q]; // r - (q + 1) + 1
        int i = 0; int j = 0; //vet1 e vet2, respectivamente

        //atribuições

        for (int k = 0; k < vet1.length; k++) {
            vet1[k] = vet[p + k];
        }
        for (int k = 0; k < vet2.length; k++) {
            vet2[k] = vet[q + 1 + k];
        }

        int k = p; //o inicio de vet deve ser considerado relativo aos subarrays para que não haja perda de dados!
        while (i < vet1.length && j < vet2.length) {
            if (vet1[i] < vet2[j])
                vet[k++] = vet1[i++];
            else
                vet[k++] = vet2[j++];
        }

        //atribuir os restantes.
        while (i < vet1.length)
            vet[k++] = vet1[i++];
        while (j < vet2.length)
            vet[k++] = vet2[j++];
    }

    /**
     * Função para mostrar o vetor (teste de código)
     */
    // private static void printarVetor(int[] vet) {
    //     System.out.print("/ ");
    //     for(int elemento : vet) {
    //         System.out.print(elemento + " / ");
    //     }
    //     System.out.println();
    // }
}
