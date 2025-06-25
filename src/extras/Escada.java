package extras;

public class Escada {
    public static void main(String[] args) {
        resolverProblemaSemPermutacoes();
        System.out.println("------------------------------------------------");
        resolverProblemaComPermutacoes();
    }

    private static void printarMatrizMemorizacao(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++)
                System.out.print(mat[i][j] + " |");
            System.out.println();
            System.out.println("--------------------------------------------");
        }
    }

    private static void printarVetorMemorizacao(int[] vet) {
        for (int v : vet) {
            System.out.print(v + " | ");
        }
        System.out.println();
    }

    /**
     * As possibilidades de se chegar no degrau i
     * será igual a soma das possibilidades de se
     * chegar nos degrais anteriores. Essa soma 
     * garante, por exemplo, que o degrau seis 
     * pode ser alcançado a partir do degrau 3
     * somando mais um passo 3.
     */
    private static void resolverProblemaComPermutacoes() {
         final int NUMERO_DEGRAUS = 6;
         final int[] passos = {1, 2};

         int[] dp = new int[NUMERO_DEGRAUS + 1];
         dp[0] = 1;
         for (int i = 1; i <= NUMERO_DEGRAUS; i++) {
            for (int j = 0; j < passos.length; j++) {
                if (i >= passos[j]) {
                    dp[i] += dp[i - passos[j]];
                }
            }
         }

        printarVetorMemorizacao(dp);
        System.out.println("Resultado: " + dp[NUMERO_DEGRAUS]);
    }

    private static void resolverProblemaSemPermutacoes() {
        //Desenvolvimento da teoria
        /**
         * Dado n degraus e p formas de subida:
         * T[p, n] == 1 -> n == 0;
         * T[p, n] == 0 -> n < 0 ou p <= 0;
         * T[p, n] == T[n - V[p], p] + T[n, p - 1]
         */

         final int NUMERO_DEGRAUS = 6;
         final int[] passos = {1, 2};
         final int QUANTIDADE_PASSOS = passos.length;

         int[][] dp = new int[QUANTIDADE_PASSOS + 1][NUMERO_DEGRAUS + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= QUANTIDADE_PASSOS; i++) {
            for (int j = 1; j <= NUMERO_DEGRAUS; j++) {
                if (passos[i - 1] <= j) {
                    dp[i][j] = dp[i][j - passos[i - 1]] + dp[i - 1][j];
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        printarMatrizMemorizacao(dp);

        System.out.println("Possibilidades possíveis: " + dp[QUANTIDADE_PASSOS][NUMERO_DEGRAUS]);
    }
}
