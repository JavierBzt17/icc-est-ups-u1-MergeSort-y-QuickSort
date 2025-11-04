public class QuickSort {

    public void sort(int[] numeros, boolean asc, boolean pasos) {
        quickSortRecursive(numeros, 0, numeros.length - 1, asc, pasos);
    }

    private void quickSortRecursive(int[] numeros, int low, int high, boolean asc, boolean pasos) {
        if (low < high) {
            int pi = partition(numeros, low, high, asc, pasos);
            quickSortRecursive(numeros, low, pi - 1, asc, pasos);
            quickSortRecursive(numeros, pi + 1, high, asc, pasos);
        }
    }

    private int partition(int[] numeros, int low, int high, boolean asc, boolean pasos) {
        int pivot = numeros[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (asc ? (numeros[j] <= pivot) : (numeros[j] >= pivot)) {
                i++;
                int temp = numeros[i];
                numeros[i] = numeros[j];
                numeros[j] = temp;
            }
        }

        int temp = numeros[i + 1];
        numeros[i + 1] = numeros[high];
        numeros[high] = temp;

        int part = i + 1;

        if (pasos) {
            printArray(numeros);
        }

        return part;
    }

    private void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}