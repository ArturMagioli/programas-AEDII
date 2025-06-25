package lista03;

import java.util.Scanner;

public class MagoSupremo {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int poderBase = sc.nextInt();
        int nivel = sc.nextInt();

        System.out.println(calcularDano(poderBase, nivel));

        sc.close();
    }

    private static int calcularDano(int poderBase, int nivel) {
        if(nivel == 0) return 1;
        if (nivel == 1) return poderBase;
        
        if(nivel % 2 == 0) return calcularDano( poderBase, nivel / 2) * calcularDano(poderBase, nivel / 2);
        else return poderBase * calcularDano( poderBase, nivel / 2) * calcularDano(poderBase, nivel / 2);
    }
}
