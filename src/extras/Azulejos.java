package extras;

/**
 * Dado um conjunto de azulejos de dimensões 2 x 1, quer-se saber de quantas maneiras distintas pode-se
 * azulejar uma parede de dimensões 2 x n, com esses azulejos.
 * T(n) = número de maneiras distintas para o azulejamento.
 * T(1) = 1
 * T(2) = 2
 * T(n) = T(n - 1) + T(n - 2)
 */
public class Azulejos {
    public static void main(String[] args) {
        final int LARGURA = 8;
        resolverProbleamaAzulejos(LARGURA);
    }

    private static void resolverProbleamaAzulejos(final int LARGURA) {
        int[] maneirasDistintas = new int[LARGURA + 1];
        maneirasDistintas[0] = 0;
        if (LARGURA > 0) {
            maneirasDistintas[1] = 1;
            for (int i = 2; i < maneirasDistintas.length; i++) {
                maneirasDistintas[i] = maneirasDistintas[i - 1] + maneirasDistintas[i - 2];
            }
        }

        printarVetorMemorizacao(maneirasDistintas);
        System.out.println("Maneiras distintas: " + maneirasDistintas[LARGURA]);
    }

    private static void printarVetorMemorizacao(int[] vet) {
        for (int v : vet) {
            System.out.print(v + " | ");
        }
        System.out.println();
    }
}
