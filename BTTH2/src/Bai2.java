import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) throws Exception {
        // 1

        Scanner scanner = new Scanner(System.in);
        ToaDo A, B;
        A = new ToaDo();
        B = new ToaDo();
        System.out.print("Nhap hoanh do diem A: ");
        A.setX(scanner.nextDouble());
        System.out.print("Nhap tung do diem A: ");
        A.setY(scanner.nextDouble());
        System.out.print("Nhap hoanh do diem B: ");
        B.setX(scanner.nextDouble());
        System.out.print("Nhap tung do diem B: ");
        B.setY(scanner.nextDouble());
        System.out.println(
                "Khoang cach AB la: " + Math.sqrt(Math.pow(B.getX() - A.getX(), 2) +
                        Math.pow(B.getY() - A.getY(), 2)));

        // 2
        System.out.print(
                "Chon so tuong ung voi hinh muon nhap (1 - Tam Giac, 2 - Tu Giac, 3 - Hinh Binh Hanh, 4 - Hinh Chu Nhat, 5 - Hinh Vuong): ");
        int selected = scanner.nextInt();
        switch (selected) {
            case 1:
                TamGiac test = new TamGiac(scanner);
                test.nhap();
                test.xuat();
                test.tinhTien();
                test.quay();
                test.thuPhong();
                System.out.println("\nChu vi tam giac: " + test.tinhChuVi());
                System.out.println("\nDien tich tam giac: " + test.tinhDienTich());
                break;
            case 2:
                TuGiac test2 = new TuGiac(scanner);
                test2.nhap();
                test2.xuat();
                test2.tinhTien();
                test2.quay();
                test2.thuPhong();
                System.out.println("\nChu vi tu giac: " + test2.tinhChuVi());
                System.out.println("\nDien tich tu giac: " + test2.tinhDienTich());
                break;
            case 3:
                HinhBinhHanh test3 = new HinhBinhHanh(scanner);
                test3.nhap();
                test3.xuat();
                test3.tinhTien();
                test3.quay();
                test3.thuPhong();
                System.out.println("\nChu vi hinh binh hanh: " + test3.tinhChuVi());
                System.out.println("\nDien tich hinh binh hanh: " + test3.tinhDienTich());
                break;
            case 4:
                HinhChuNhat test4 = new HinhChuNhat(scanner);
                test4.nhap();
                test4.xuat();
                test4.tinhTien();
                test4.quay();
                test4.thuPhong();
                System.out.println("\nChu vi hinh chu nhat: " + test4.tinhChuVi());
                System.out.println("\nDien tich hinh chu nhat: " + test4.tinhDienTich());
                break;
            case 5:
                HinhVuong test5 = new HinhVuong(scanner);
                test5.nhap();
                test5.xuat();
                test5.tinhTien();
                test5.quay();
                test5.thuPhong();
                System.out.println("\nChu vi hinh vuong: " + test5.tinhChuVi());
                System.out.println("\nDien tich hinh chu nhat: " + test5.tinhDienTich());
                break;
        }

        scanner.close();
    }
}
