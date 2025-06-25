package lista04;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class QuickSort {
    
    public static void main(String[] args) {
        File file = new File(args[0]);
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            
            String[] split = sc.nextLine().split(",");

            int[] inteiros = new int[split.length];

            for(int i = 0; i < inteiros.length; i++) inteiros[i] = Integer.parseInt(split[i]);

            double tempoInicial = System.currentTimeMillis();

            quickSort(inteiros, 0, inteiros.length - 1);

            System.out.println("Tempo de execução: " + (System.currentTimeMillis() - tempoInicial));

        }
        catch (IOException e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        finally {
            if (sc != null) sc.close();
        }
    }

    //Escolhendo o último elemento como pivô
    private static void quickSort(int[] vet, int inicio, int fim) {
        if (inicio < fim) {
            int pivo = particionar(vet, 0, fim - 1);
            //dividir para conquistar: quickSort dos subarrays:
            quickSort(vet, inicio, pivo - 1);
            quickSort(vet, pivo + 1, fim);
        }
    }

    private static int particionar(int[] vet, int inicio, int fim) {
        int i = 0;
        //realizando trocas para que os menores fiquem antes do pivô
        for (int j = 0; j < fim; j++) {
            if(vet[j] <= vet[fim]) {
                int aux = vet[i];
                vet[i] = vet[j];
                vet[j] = aux;
                i++;
            }
        }

        //reposicionando o pivô, sabendo que ele sempre será o último:
        int aux = vet[fim];
        vet[fim] = vet[i];
        vet[i] = aux;

        //retornando a nova posição do pivô
        return i;
    }

    // private static void printarVetor(int[] vet) {
    //     System.out.print("/ ");
    //     for(int elemento : vet) System.out.print(elemento + " / ");
    //     System.out.println();
    // }
}
