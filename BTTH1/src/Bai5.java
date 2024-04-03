import java.util.Scanner;

public class Bai5 {
    public static void main(String[] args) throws Exception {
        String s1, s2;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap chuoi s1: ");
        s1 = scanner.nextLine();
        System.out.print("Nhap chuoi s2: ");
        s2 = scanner.nextLine();

        // 5.1
        System.out.println("Tong chieu dau hai chuoi s1 va s2: " + (s1.length() + s2.length()));

        // 5.2
        if (s1.length() > 3) {
            System.out.println("Ba ky tu dau tien cua chuoi s1: " + s1.substring(0, 3));
        } else
            System.out.println("Chuoi ngan hon ba ky tu");

        // 5.3
        if (s2.length() > 3) {
            System.out.println("Ba ky tu dau tien cua chuoi s2: " + s2.substring(0, 3));
        } else
            System.out.println("Chuoi ngan hon ba ky tu");

        // 5.4
        if (s1.length() >= 6)
            System.out.println("Ky tu thu 6 cua chuoi s1: " + s1.substring(5, 6));
        else
            System.out.println("s1 khong co vi tri thu 6");

        // 5.5
        if (s1.length() == s2.length())
            System.out.println("s1 va s2 bang nhau");
        else
            System.out.println("s1 va s2 khong bang nhau");

        // 5.6
        int index = s1.indexOf(s2);
        if (index != -1) {
            System.out.println("s2 co nam trong s1. Vi tri s2 trong s1: " + index);
        } else {
            System.out.println("s1 khong chua s2");
        }
        scanner.close();
    }

}
