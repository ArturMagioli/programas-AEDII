package exerciciosGPT;

public class SubsetSum {
    public static void main(String[] args) {
        int[] numeros = {1, 3, 4, 6, 7, 12};
        int s = 24;

        System.out.println("Existe?: " + determinarExistencia(numeros, s));
    }

    private static boolean determinarExistencia(int[] numeros, int s) {
    int n = numeros.length;
    boolean[][] dp = new boolean[n + 1][s + 1];

    // Base: soma 0 é sempre possível (com subconjunto vazio)
    for (int i = 0; i <= n; i++) {
        dp[i][0] = true;
    }

    // Preenchendo a tabela
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= s; j++) {
            if (numeros[i - 1] <= j) {
                // Pode escolher ou não o número atual
                dp[i][j] = dp[i - 1][j] || dp[i - 1][j - numeros[i - 1]];
            } else {
                // Não pode usar o número atual
                dp[i][j] = dp[i - 1][j];
            }
        }
    }

    return dp[n][s];
}

}
