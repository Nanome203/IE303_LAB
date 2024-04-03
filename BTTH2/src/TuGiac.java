import java.util.Scanner;

public class TuGiac extends DaGiac {
    public ToaDo A, B, C, D;
    public double AB, BC, CD, AD;

    TuGiac() {

    }

    TuGiac(Scanner sc) {
        A = new ToaDo();
        B = new ToaDo();
        C = new ToaDo();
        D = new ToaDo();
        super.scanner = sc;
    }

    @Override
    public void nhap() {
        System.out.print("Nhap hoanh do diem A: ");
        A.setX(scanner.nextDouble());
        System.out.print("Nhap tung do diem A: ");
        A.setY(scanner.nextDouble());
        System.out.print("Nhap hoanh do diem B: ");
        B.setX(scanner.nextDouble());
        System.out.print("Nhap tung do diem B: ");
        B.setY(scanner.nextDouble());
        System.out.print("Nhap hoanh do diem C: ");
        C.setX(scanner.nextDouble());
        System.out.print("Nhap tung do diem C: ");
        C.setY(scanner.nextDouble());
        System.out.print("Nhap hoanh do diem D: ");
        D.setX(scanner.nextDouble());
        System.out.print("Nhap tung do diem D: ");
        D.setY(scanner.nextDouble());
        AB = khoangCachHaiDiem(A, B);
        CD = khoangCachHaiDiem(C, D);
        BC = khoangCachHaiDiem(B, C);
        AD = khoangCachHaiDiem(A, D);
    }

    @Override
    public void xuat() {
        if (laTuGiac(A, B, C, D))
            System.out.println("\nBAN VUA NHAP MOT TU GIAC\n");
        else {
            System.out.println("\nBAN KHONG VUA NHAP MOT TU GIAC\n");
            System.exit(0);
        }

    }

    @Override
    public void tinhTien() {
        double dx = 0, dy = 0;
        System.out.print("Nhap hoanh do vector tinh tien: ");
        dx = scanner.nextDouble();
        System.out.print("Nhap tung do vector tinh tien: ");
        dy = scanner.nextDouble();
        System.out.println("\n\nTINH TIEN THANH CONG !!!\n");

        // Tinh tien diem A
        System.out.print(String.format("A(%.1f,%.1f) -> ", A.getX(), A.getY()));
        A.setX(A.getX() + dx);
        A.setY(A.getY() + dy);
        System.out.println(String.format("A(%.1f,%.1f)", A.getX(), A.getY()));

        // Tinh tien diem B
        System.out.print(String.format("B(%.1f,%.1f) -> ", B.getX(), B.getY()));
        B.setX(B.getX() + dx);
        B.setY(B.getY() + dy);
        System.out.println(String.format("B(%.1f,%.1f)", B.getX(), B.getY()));

        // Tinh tien diem C
        System.out.print(String.format("C(%.1f,%.1f) -> ", C.getX(), C.getY()));
        C.setX(C.getX() + dx);
        C.setY(C.getY() + dy);
        System.out.println(String.format("C(%.1f,%.1f)", C.getX(), C.getY()));

        // Tinh tien diem D
        System.out.print(String.format("D(%.1f,%.1f) -> ", D.getX(), D.getY()));
        D.setX(D.getX() + dx);
        D.setY(D.getY() + dy);
        System.out.println(String.format("D(%.1f,%.1f)", D.getX(), D.getY()));
    }

    @Override
    public void thuPhong() {
        double scaleFactor = 0;
        System.out.print("\nNhap muc do phong to hay thu nho: ");
        scaleFactor = scanner.nextDouble();
        B.setX(A.getX() + (B.getX() - A.getX()) * scaleFactor);
        B.setY(A.getY() + (B.getY() - A.getY()) * scaleFactor);
        C.setX(A.getX() + (C.getX() - A.getX()) * scaleFactor);
        C.setY(A.getY() + (C.getY() - A.getY()) * scaleFactor);
        D.setX(A.getX() + (D.getX() - A.getX()) * scaleFactor);
        D.setY(A.getY() + (D.getY() - A.getY()) * scaleFactor);
        System.out
                .println(String.format(
                        "\nToa do hinh sau khi thu phong: A(%.1f,%.1f), B(%.1f,%.1f), C(%.1f,%.1f), D(%.1f,%.1f)",
                        A.getX(), A.getY(), B.getX(), B.getY(), C.getX(), C.getY(), D.getX(), D.getY()));
        AB = khoangCachHaiDiem(A, B);
        CD = khoangCachHaiDiem(C, D);
        BC = khoangCachHaiDiem(B, C);
        AD = khoangCachHaiDiem(A, D);
    }

    @Override
    public void quay() {
        double x, y, radian;
        System.out.print("\nNhap hoanh do diem de quay hinh xung quanh: ");
        x = scanner.nextDouble();
        System.out.print("Nhap tung do diem de quay hinh xung quanh: ");
        y = scanner.nextDouble();
        System.out.print("Nhap so do goc quay (radian): ");
        radian = scanner.nextDouble();
        double cosTheta = Math.cos(radian);
        double sinTheta = Math.sin(radian);
        double xA = A.getX() - x;
        double yA = A.getY() - y;
        double xB = B.getX() - x;
        double yB = B.getY() - y;
        double xC = C.getX() - x;
        double yC = C.getY() - y;
        double xD = D.getX() - x;
        double yD = D.getY() - y;
        double xAPrime = x + (xA * cosTheta - yA * sinTheta);
        double yAPrime = y + (xA * sinTheta + yA * cosTheta);
        double xBPrime = x + (xB * cosTheta - yB * sinTheta);
        double yBPrime = y + (xB * sinTheta + yB * cosTheta);
        double xCPrime = x + (xC * cosTheta - yC * sinTheta);
        double yCPrime = y + (xC * sinTheta + yC * cosTheta);
        double xDPrime = x + (xD * cosTheta - yD * sinTheta);
        double yDPrime = y + (xD * sinTheta + yD * cosTheta);
        A.setX(xAPrime);
        A.setY(yAPrime);
        B.setX(xBPrime);
        B.setY(yBPrime);
        C.setX(xCPrime);
        C.setY(yCPrime);
        D.setX(xDPrime);
        D.setY(yDPrime);
        System.out
                .println(String.format(
                        "\nToa do hinh sau khi quay: A(%.1f,%.1f), B(%.1f,%.1f), C(%.1f,%.1f), D(%.1f,%.1f)",
                        xAPrime, yAPrime, xBPrime, yBPrime, xCPrime, yCPrime, xDPrime, yDPrime));
    }

    @Override
    public double tinhChuVi() {
        return AB + CD + BC + AD;
    }

    @Override
    public double tinhDienTich() {
        double p = (AB + BC + CD + AD) / 2;
        return Math.sqrt((p - AD) * (p - AB) * (p - CD) * (p - BC));
    }

    public boolean laBaDiemThangHang(ToaDo p1, ToaDo p2, ToaDo p3) {
        return (p2.getY() - p1.getY()) * (p3.getX() - p2.getX()) == (p3.getY() - p2.getY()) * (p2.getX() - p1.getX());
    }

    public boolean laTuGiac(ToaDo p1, ToaDo p2, ToaDo p3, ToaDo p4) {
        if (!laBaDiemThangHang(p1, p2, p3) && !laBaDiemThangHang(p2, p3, p4) &&
                !laBaDiemThangHang(p3, p4, p1) && !laBaDiemThangHang(p4, p1, p2)) {
            return true;
        }
        return false;
    }

}
