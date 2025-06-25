package lista05;

public class Mochila {
    public static void main(String[] args) {
        //n -> capacidade da mochila
        //p -> quantidade de itens
        //caso base: T(n,p) == 0 -> n == 0 ou p == 0
        //caso recursivo: T(n, p) -> T(n, p - 1) ou T(n - V[p], p) + T(n - 1, p)

        //inserindo os dados do problema
        int p = 4;
        int n = 10;
        Item[] itens = {
            new Item(3, 4),
            new Item(4, 7),
            new Item(5, 10),
            new Item(6, 12)
        };

        int[][] mat = gerarMatrizMemorizacao(p, n);

        int valorMaximo = obterValorMaximo(mat, itens);

        printarMatrizMemorizacao(mat);

        System.out.println("Valor máximo: " + valorMaximo);
    }

    private static int[][] gerarMatrizMemorizacao(int p, int n) {
        int[][] mat = new int[p + 1][n + 1];
        for (int i = 0; i < mat.length; i++) 
            for (int j = 0; j < mat[0].length; j++)
                mat[i][j] = -1;
        return mat;
    }

    private static void printarMatrizMemorizacao(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++)
                System.out.print(mat[i][j] + " |");
            System.out.println();
            System.out.println("--------------------------------------------");
        }
    }

    private static int obterValorMaximo(int[][] mat, Item[] itens) {
        int p = mat.length - 1;
        int n = mat[0].length - 1;

        for (int i = 0; i <= p; i++) {
            mat[i][0] = 0;
        }
        for (int j = 0; j <= n; j++) {
            mat[0][j] = 0;
        }

        for (int i = 1; i <= p; i++) {
            for (int j = 0; j <= n; j++) {
                if (itens[i - 1].getPeso() > j) {
                    mat[i][j] = mat[i - 1][j];  
                }else {
                    mat[i][j] = Integer.max(itens[i - 1].getValor() + mat[i - 1][j - itens[i - 1].getPeso()], mat[i - 1][j]);
                }
            }
        }

        return mat[p][n];
    }
}
