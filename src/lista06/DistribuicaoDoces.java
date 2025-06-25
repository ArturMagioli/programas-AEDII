package lista06;

import java.util.Arrays;

public class DistribuicaoDoces {
    public static void main(String[] args) {
        int[] necessidadesCaloricasCriancas = {5, 7, 3};
        int[] valoresCaloricosDoces = {6, 2, 8, 3, 4};

        distribuirDoces(necessidadesCaloricasCriancas, valoresCaloricosDoces);
    }

    private static void distribuirDoces(int[] necessidadesCaloricas, int[] valoresCaloricos) {
        Arrays.sort(valoresCaloricos);
        Arrays.sort(necessidadesCaloricas);

        int necessidadeCaloricaIndex = necessidadesCaloricas.length - 1;
        int valorCaloricoIndex = valoresCaloricos.length - 1;
        int criancasAtendidas = 0;

        while (necessidadeCaloricaIndex >= 0 && valorCaloricoIndex >= 0) {
            if (necessidadesCaloricas[necessidadeCaloricaIndex] <= valoresCaloricos[valorCaloricoIndex]) {
                System.out.println("Doce " + valoresCaloricos[valorCaloricoIndex] + " Para " + necessidadesCaloricas[necessidadeCaloricaIndex]);
                valorCaloricoIndex--;
                criancasAtendidas++;
            }
            necessidadeCaloricaIndex--;
        }

        System.out.println("Total de crianças atendidas: " + criancasAtendidas);
    }
}
