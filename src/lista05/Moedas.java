package lista05;

public class Moedas {
    public static void main(String[] args) {
        int[] V = {1, 3, 4};
        //O menor número de missões é aquele em que usamos a missão de maior recompensa possível m vezes?
        int menorNumeroMissoes = minMissoes(18, V);;

        System.out.println("Menor número de missões possível: " + menorNumeroMissoes);
    }

    public static int minMissoes(int x, int[] V) {
        int n = V.length;
        int[] T = new int[x + 1];
        T[0] = 0;
        for (int i = 1; i <= x; i++) {
            T[i] = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (V[j] <= i) {
                    T[i] = Integer.min(T[i], T[i - V[j]] + 1);
                }
            }
        }
        printarVetor(T);
        return T[x];
    }

    private static void printarVetor(int[] T) {
        for (int i : T) {
            System.out.print(i + " | ");
        }
    }

}