package lista02;

public class TorreDeHanoi {
    
    public static void main(String[] args) {
        int discos = 3;

        hanoi(discos, 'A', 'B', 'C');
    }

    private static void hanoi(int discos, char origem, char suporte, char destino) {
        if (discos > 0) {
            hanoi(discos - 1, origem, destino, suporte);
            System.out.println("Movendo o disco " + discos + " de " + origem + " para " + destino);
            hanoi(discos - 1, suporte, origem, destino);
        }
    }
}
