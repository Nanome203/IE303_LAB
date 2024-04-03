import java.util.Calendar;
import java.util.Scanner;

public class Bai6 {
    // Phương thức nhập ngay từ bàn phím
    public static Calendar nhapNgay(Scanner scanner) {
        String input = scanner.nextLine();
        String[] parts = input.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]) - 1; // Calendar.MONTH bắt đầu từ 0
        int year = Integer.parseInt(parts[2]);
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar;
    }

    // Phương thức so sánh 2 ngay
    public static void soSanhHaiNgay(Calendar a, Calendar b) {
        if (a.compareTo(b) > 0) {
            System.out.println("Ngay a sau ngay b");
        } else if (a.compareTo(b) < 0) {
            System.out.println("Ngay a truoc ngay b");
        } else {
            System.out.println("Ngay a va b la cung mot ngay");
        }
    }

    // Phương thức in ngay trước và ngay sau của một ngay
    public static void inNgayTruocVaNgaySau(Calendar calendar) {
        Calendar truoc = (Calendar) calendar.clone();
        truoc.add(Calendar.DAY_OF_MONTH, -1); // Ngay trước
        Calendar sau = (Calendar) calendar.clone();
        sau.add(Calendar.DAY_OF_MONTH, 1); // Ngay sau

        System.out.println("Ngay truoc cua ngay a: " + truoc.get(Calendar.DAY_OF_MONTH) + "/" +
                (truoc.get(Calendar.MONTH) + 1) + "/" + truoc.get(Calendar.YEAR));
        System.out.println("Ngay sau cua ngay a: " + sau.get(Calendar.DAY_OF_MONTH) + "/" +
                (sau.get(Calendar.MONTH) + 1) + "/" + sau.get(Calendar.YEAR));
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        // Nhập vào 2 ngay a, b
        System.out.println("Nhap vao ngay a (dd/MM/yyyy):");
        Calendar a = nhapNgay(scanner);
        System.out.println("Nhap vao ngay b (dd/MM/yyyy):");
        Calendar b = nhapNgay(scanner);

        // So sánh 2 ngay a và b
        soSanhHaiNgay(a, b);

        // In ra ngay trước và ngay tiếp theo của ngay a
        inNgayTruocVaNgaySau(a);

        // Cho biết a là ngay thứ mấy trong năm
        System.out.println("Ngay a la ngay thu " + a.get(Calendar.DAY_OF_YEAR) + " trong nam");

        // Cho biết tháng chứa a có bao nhiêu ngay
        System.out.println("Thang chua ngay a co " + a.getActualMaximum(Calendar.DAY_OF_MONTH) + " ngay");

        // Cho biết năm chứa a có phải là năm nhuần không
        int year = a.get(Calendar.YEAR);
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
        if (isLeapYear) {
            System.out.println("Nam chua ngay a là nam nhuan.");
        } else {
            System.out.println("Nam chua ngay a khong phai la nam nhuan.");
        }
    }

}
