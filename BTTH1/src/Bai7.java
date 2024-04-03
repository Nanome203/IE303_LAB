import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Bai7 {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        do {
            System.out.print("Nhap so luong mang so nguyen A khac 0: ");
            n = scanner.nextInt();
        } while (n <= 0);
        int[] A = new int[n];
        System.out.print("Nhap cac phan tu mang: ");
        for (int i = 0; i < n; ++i) {
            A[i] = scanner.nextInt();
        }

        // 7.1
        int nB = 0;
        do {
            System.out.print("Nhap so luong phan tu mang B khac 0: ");
            nB = scanner.nextInt();
        } while (nB <= 0);
        int[] B = new int[nB];
        Random rand = new Random();
        for (int i = 0; i < nB; ++i) {
            B[i] = rand.nextInt(1000);
        }

        // 7.2
        System.out.println("Mang B: " + Arrays.toString(B));

        // 7.3
        int[] C = Arrays.copyOf(A, n);
        System.out.println("Mang C: " + Arrays.toString(C));

        // 7.4
        System.arraycopy(B, nB - 3, C, 0, 3);
        System.out.println("Mang C sau khi thay cac phan tu: " + Arrays.toString(C));

        // 7.5
        Arrays.sort(C);
        System.out.println("Mang C sau khi sort: " + Arrays.toString(C));
        scanner.close();

    }

}
