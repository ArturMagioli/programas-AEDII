package extras;

public class Bastao {
    public static void main(String[] args) {
        final int COMPRIMENTO = 4;
        final int[] tamanhos = {1, 2, 3, 4};
        final int[] precos = {1, 5, 8, 9};
        int valorMaximo = rod(COMPRIMENTO, tamanhos, precos);

        System.out.println("Valor máximo obtido na venda do bastão: " + valorMaximo);
    }

    /**
     * Formulação:
     * 
     * Sendo uma matriz com COMPRIMENTO n, Tamanho p e precos V:
     * T[n, p] = 0 -> n <= 0 ou p <= 0
     * T[n, p] = 1 -> n = 1
     * T[n, p] = n -> p = 1
     * T[n, p] = Integer.max(V[p - 1] + T[n - p][p], T[n][p - 1])
     *
     * @param COMPRIMENTO
     * @param tamanhos
     * @param precos
     * @return int
     */
    private static int rod(final int COMPRIMENTO, final int[] tamanhos, final int[] precos) {

        final int TAMANHO = tamanhos.length;
        int[][] dp = new int[TAMANHO + 1][COMPRIMENTO + 1];
        //casos base
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        for (int j = 0; j < dp[0].length; j++) {
            dp[1][j] = j;
        }

        //caso recursivo:
        for (int i = 1; i <= TAMANHO; i++) {
            for (int j = 2; j <= COMPRIMENTO; j++) {
                if (j >= tamanhos[i - 1]) {
                    dp[i][j] = Integer.max(precos[i - 1] + dp[i][j - tamanhos[i - 1]], dp[i - 1][j]);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[TAMANHO][COMPRIMENTO];
    }
}
