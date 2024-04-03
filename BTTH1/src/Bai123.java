import java.util.Scanner;

public class Bai123 {
    public static double sumOfS(double x, int n) {
        double sum = x;
        int tong_mau = 1;
        for (int i = 2; i <= n; ++i) {
            tong_mau = tong_mau + i;
            sum = sum + Math.pow(x, i) / (tong_mau);
        }
        return sum;
    }

    public static double tinhChuVi(double canh1, double canh2, double canh3) {
        return canh1 + canh2 + canh3;
    }

    public static double tinhDienTich(double canh1, double canh2, double canh3) {
        double nuaChuVi = tinhChuVi(canh1, canh2, canh3) / 2;
        return Math.sqrt(nuaChuVi * (nuaChuVi - canh1) * (nuaChuVi - canh2) * (nuaChuVi - canh3));
    }

    public static void main(String[] args) throws Exception {

        // bai 1
        System.out.println("BAI 1: \n\n");
        System.out.println("Hello World!");
        System.out.println("\n\n");

        // bai 2
        System.out.println("BAI 2: \n\n");
        int n;
        double x;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap x: ");
        x = scanner.nextDouble();
        System.out.print("Nhap n: ");
        n = scanner.nextInt();
        System.out.println("Tong S(x): " + sumOfS(x, n));
        System.out.println("\n\n");

        // bai 3
        double canh1, canh2, canh3;
        System.out.println("BAI 3: \n\n");
        System.out.print("Nhap canh dau tien cua tam giac: ");
        canh1 = scanner.nextDouble();
        System.out.print("Nhap canh thu hai cua tam giac: ");
        canh2 = scanner.nextDouble();
        System.out.print("Nhap canh thu ba cua tam giac: ");
        canh3 = scanner.nextDouble();
        System.out.println("Chu vi tam giac: " + tinhChuVi(canh1, canh2, canh3));
        System.out.println("Dien tich tam giac: " + tinhDienTich(canh1, canh2, canh3));

        System.out.println("\n\n");

        scanner.close();
    }
}
