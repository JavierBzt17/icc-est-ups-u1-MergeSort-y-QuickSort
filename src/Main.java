import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] numeros = {5, 10, 20, 2, 40, 33, 7, 22, 4, 39, 1};

        View view = new View();
        MergeSort mergesort = new MergeSort();
        QuickSort quicksort = new QuickSort();

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ORDEN ORIGINAL ===");
        view.printArray(numeros);
        System.out.println("-------------------------");

        System.out.println("Elija un algoritmo de ordenamiento:");
        System.out.println("1. MergeSort");
        System.out.println("2. QuickSort");
        System.out.print("Opción: ");
        int opcion = scanner.nextInt();

        System.out.print("¿Desea mostrar los pasos? (s/n): ");
        String respuestaPasos = scanner.next();
        boolean mostrarPasos = respuestaPasos.equalsIgnoreCase("s");

        int[] arregloParaOrdenar = Arrays.copyOf(numeros, numeros.length);

        switch (opcion) {
            case 1:
                System.out.println("\n--- MERGE SORT " + (mostrarPasos ? "(con pasos)" : "(sin pasos)") + " ---");
                mergesort.sort(arregloParaOrdenar, true, mostrarPasos);
                
                System.out.println("Resultado final:");
                view.printArray(arregloParaOrdenar);
                break;
                
            case 2:
                System.out.println("\n--- QUICK SORT " + (mostrarPasos ? "(con pasos)" : "(sin pasos)") + " ---");
                quicksort.sort(arregloParaOrdenar, true, mostrarPasos);
                
                System.out.println("Resultado final:");
                view.printArray(arregloParaOrdenar);
                break;
                
            default:
                System.out.println("Opción no válida.");
                break;
        }

        scanner.close();
    }
}