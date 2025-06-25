package lista03;

public class CorridaGalactica {
    
    public static void main(String[] args) {
        
        int[] vet = {130, 98, 120, 145, 110};

        printarVetor(vet);

        mergeSort(vet, 0, vet.length - 1);

        printarVetor(vet);
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
    private static void printarVetor(int[] vet) {
        System.out.print("/ ");
        for(int elemento : vet) {
            System.out.print(elemento + " / ");
        }
        System.out.println();
    }
}
