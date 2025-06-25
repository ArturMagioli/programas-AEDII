package lista01;

import java.util.Scanner;

public class SomaSalarios2a2 {
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

        System.out.println("Soma dos salários: " + somaSalarios2a2(salarios, 0, salarios.length - 1));
    }

    private static int somaSalarios2a2(int[] salarios, int i, int j) {
        if(i == j) return salarios[i];

        int meio = (i + j) / 2;
        return somaSalarios2a2(salarios, i, meio) + somaSalarios2a2(salarios, meio + 1, j);
    }
}
