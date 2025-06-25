package lista02;

public class GuardiaoSegmentos {
    public static void main(String[] args) {
        int[] vet = new int[10];
        for (int i = 0; i < vet.length; i++) {
            vet[i] = 0;
        }

        //atribuindo uma posicao aleatória
        int pos = (int)(Math.random() * 10);
        vet[pos] = 1;
    
        printarVetor(vet);

        int posInimigo = encontrarPosicao(vet, 0, vet.length - 1);
        System.out.println(posInimigo);
    }

    private static int encontrarPosicao(int[] vet, int inicio, int fim){
        while(inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (vet[meio] == 1) return meio;
            else if(verificarIntervalo(vet, inicio, meio) == 1) fim = meio - 1;
            else inicio = meio + 1;
        }
        return -1;
    }

    private static int verificarIntervalo(int[] vet, int inicio, int fim) {
        int soma = 0;
        while(inicio <= fim) {
            soma += vet[inicio++];
        }
        return soma;
    }

    private static void printarVetor(int[] vet) {
        for (int i : vet) {
            System.out.print(i + " ");
        }
    }
}
