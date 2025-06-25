package lista01;

import java.util.Scanner;

public class SomaSalariosRecursivo {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe a quantidade de salários: ");
        int n = sc.nextInt();

        int[] salarios = new int[n];

        System.out.println("Informe os salários: ");
        for (int i = 0; i < n; i++) {
            salarios[i] = sc.nextInt();
        }
        sc.close();

        System.out.println("Soma dos salários: " + somaSalariosRecursivo(salarios, salarios.length - 1));
    }

    private static int somaSalariosRecursivo(int[] salarios, int n) {
        if(n == 0) return salarios[0];
        return salarios[n] + somaSalariosRecursivo(salarios, n - 1);
    }
}
