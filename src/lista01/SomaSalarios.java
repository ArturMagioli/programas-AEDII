package lista01;

//nota: Muro infinito aplicado em C.

import java.util.Scanner;

public class SomaSalarios {

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

        System.out.println("Soma dos salários: " + somaSalarios(salarios));
    }

    private static int somaSalarios(int[] salarios) {
        int somatorio = 0;
        for(int s : salarios) {
            somatorio += s;
        }
        return somatorio;
    }
}
