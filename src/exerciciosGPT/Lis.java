package exerciciosGPT;

public class Lis {
    public static void main(String[] args) {
        int[] entrada = {10, 9, 2, 5, 3, 7, 101, 18}; 
        System.out.println("LIS: " + resolverLis(entrada));
    }

    private static int resolverLis(int[] entrada) {

        int n = entrada.length;
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] dp = new int[entrada.length + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = 1;
            for (int j = 1; j <= i; j++) {
                if (entrada[j - 1] < entrada[i - 1]) {
                    dp[i] = Integer.max(dp[i], 1 + dp[j]);
                }
            }
        }

        return dp[n];
    }
}
