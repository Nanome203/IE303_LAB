import java.util.Scanner;

public class Bai4 {

    public static boolean coDoiXung(int n) {
        int reversedN = 0;
        int backupN = n;
        while (n != 0) {
            reversedN = reversedN * 10 + n % 10;
            n = n / 10;
        }
        if (backupN == reversedN)
            return true;
        return false;
    }

    public static boolean laChinhPhuong(int n) {
        return Math.sqrt((double) n) % 1 == 0;
    }

    public static void main(String[] args) throws Exception {

        int n;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so nguyen duong n: ");
        n = scanner.nextInt();

        // 4.1
        System.out.print("Cac uoc so cua n: ");
        for (int i = 1; i <= n; ++i) {
            if (n % i == 0)
                System.out.print(i + " ");
        }

        // 4.2
        int n2 = n;
        int tongChuSoCuaN = 0;
        while (n2 != 0) {
            n2 = n2 / 10;
            ++tongChuSoCuaN;
        }
        System.out.println("\nTong chu so cua n: " + tongChuSoCuaN);

        // 4.3
        if (coDoiXung(n))
            System.out.println(n + " la so doi xung");
        else
            System.out.println(n + " khong la so doi xung");

        // 4.4
        if (laChinhPhuong(n))
            System.out.println(n + " la so chinh phuong");
        else
            System.out.println(n + " khong la so chinh phuong");
        scanner.close();
    }
}
