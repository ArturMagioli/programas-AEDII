package extras;

public class ParticaoInteiros {
    public static void main(String[] args) {
        final int INTEIRO_PARTICIONADO = 5;

        int[][] dp = new int[INTEIRO_PARTICIONADO + 1][INTEIRO_PARTICIONADO + 1];
        /**
         * Formulação recursiva: n inteiro para seus p inteiros particionados
         * T[p, n] = 1 -> n == 0
         * T[p, n] = 0 se (n < 0) ou (n > 0, p = 0)
         * T[p, n] = T[p, n - p] + T[p - 1, n]
         */

        dp[0][0] = 1;
        for (int i = 1; i <= INTEIRO_PARTICIONADO; i++) {
            dp[i][0] = 0;
            dp[0][i] = 1;
        }

        for (int particionado = 1; particionado <= INTEIRO_PARTICIONADO; particionado++) {
            for (int parcela = 1; parcela <= INTEIRO_PARTICIONADO; parcela++) {
                if (particionado >= parcela) {
                    dp[particionado][parcela] = dp[particionado - parcela][parcela] + dp[particionado][parcela - 1];
                }else {
                    dp[particionado][parcela] = dp[particionado][parcela - 1];
                }
            }
        }

        printarMatrizMemorizacao(dp);

        System.out.println("Resolução: " + dp[INTEIRO_PARTICIONADO][INTEIRO_PARTICIONADO]);
    }

    private static void printarMatrizMemorizacao(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++)
                System.out.print(mat[i][j] + " |");
            System.out.println();
            System.out.println("--------------------------------------------");
        }
    }
}
