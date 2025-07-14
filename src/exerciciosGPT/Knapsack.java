package exerciciosGPT;

public class Knapsack {
    public static void main(String[] args) {
        int W = 10;
        int n = 2;
        int[] pesos = {4, 6};
        int[] valores = {50, 20};
        System.out.println("Maior valor possível: " + resolverKnapsack(n, pesos, valores, W));
    }

    private static int resolverKnapsack(int n, int[] pesos, int[] valores, int W) {
        //i = pesos
        //j = capacidade da mochila
        //caso de contorno: sem capacidade ou sem itens para colocar

        int[][] dp = new int[n + 1][W + 1];

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
            dp[0][i] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                if (pesos[i - 1] <= j) {
                    dp[i][j] = Integer.max(dp[i - 1][j], valores[i - 1] + dp[i - 1][j - pesos[i - 1]]);
                }else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][W];
    }
}
