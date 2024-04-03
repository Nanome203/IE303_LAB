import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Bai9 {
    public static void shuffleArray(Integer[] intArray) {
        List<Integer> intList = Arrays.asList(intArray);
        Collections.shuffle(intList);
        intList.toArray(intArray);
    }

    public static void findListOfPatient(int firstId, Integer[] id) {
        int copyOfFirstId = firstId;
        while (id[firstId] != copyOfFirstId) {
            System.out.print(firstId + " ");
            firstId = id[firstId];
        }
        System.out.print(firstId + " ");
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int firstCitizen = 0;
        int n = 0;
        Integer[] id;
        System.out.print("Enter n: ");
        n = scanner.nextInt();
        id = new Integer[n];
        for (int i = 0; i < n; ++i) {
            id[i] = i;
        }
        System.out.print("Enter first patient id (from 0 to " + (n - 1) + "): ");
        firstCitizen = scanner.nextInt();
        System.out.println("ID: " + Arrays.toString(id));
        shuffleArray(id);
        System.out.println("Contactee: " + Arrays.toString(id));
        System.err.println("The following citizens are to be self-isolated:");
        findListOfPatient(firstCitizen, id);
        scanner.close();
    }
}
