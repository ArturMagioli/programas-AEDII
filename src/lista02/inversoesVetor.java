package lista02;

public class inversoesVetor {
    
    public static void main(String[] args) {
        int[] nums = {2, 4, 1, 3, 5};

        System.out.println(contarInversoes(nums, 0, nums.length - 1));
    }

    private static int contarInversoes(int[] nums, int inicio, int fim) {
        //1 elemento
        if (inicio == fim) return 0;

        //2 elementos
        if (inicio + 1 == fim) return nums[inicio] > nums[fim] ? 1 : 0;

        //demais
        if(inicio < fim) {
            
            int meio = (inicio + fim) / 2;
            int inversoes = contarInversoes(nums, inicio, meio) + contarInversoes(nums, meio + 1, fim);

            //comparando os dois subarrays ordenados
            int[] aux = new int[fim - inicio + 1];
            int p = inicio;
            int q = meio + 1;
            int k = inicio;

            for (int i = inicio; i <= fim; i++) aux[i] = nums[i];

            while(p <= meio && q <= fim) {
                if(aux[p] > aux[q]) {
                    nums[k++] = aux[q++];
                    inversoes += (meio - p + 1);
                }else{
                    nums[k++] = aux[p++];
                }
            }
            
            while(p <= meio) nums[k++] = aux[p++];
            while(q <= fim) nums[k++] = aux[q++];

            return inversoes;
        }
        return 0;
    }
}
