public class MergeSort {

    public void sort(int[] numeros, boolean asc, boolean pasos) {
        mergeSortRecursive(numeros, 0, numeros.length - 1, asc, pasos);
    }

    private void mergeSortRecursive(int[] numeros, int left, int right, boolean asc, boolean pasos) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSortRecursive(numeros, left, mid, asc, pasos);
            mergeSortRecursive(numeros, mid + 1, right, asc, pasos);
            merge(numeros, left, mid, right, asc, pasos);
        }
    }

    private void merge(int[] numeros, int left, int mid, int right, boolean asc, boolean pasos) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] l = new int[n1];
        int[] r = new int[n2];

        for (int i = 0; i < n1; ++i)
            l[i] = numeros[left + i];
        for (int j = 0; j < n2; ++j)
            r[j] = numeros[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (asc ? (l[i] <= r[j]) : (l[i] >= r[j])) {
                numeros[k] = l[i];
                i++;
            } else {
                numeros[k] = r[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            numeros[k] = l[i];
            i++;
            k++;
        }

        while (j < n2) {
            numeros[k] = r[j];
            j++;
            k++;
        }

        if (pasos) {
            printArray(numeros);
        }
    }

    private void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}