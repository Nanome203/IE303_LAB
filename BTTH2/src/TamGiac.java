import java.util.Scanner;

public class TamGiac extends DaGiac {
    private ToaDo A, B, C;
    private double AB, AC, BC;

    TamGiac(Scanner sc) {
        A = new ToaDo();
        B = new ToaDo();
        C = new ToaDo();
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
        AB = khoangCachHaiDiem(A, B);
        AC = khoangCachHaiDiem(A, C);
        BC = khoangCachHaiDiem(B, C);
    }

    @Override
    public void xuat() {
        if (laTamGiac())
            System.out.println("\nBAN VUA NHAP MOT TAM GIAC\n");
        else {
            System.out.println("\nBAN KHONG VUA NHAP MOT TAM GIAC\n");
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
        System.out
                .println(String.format(
                        "\nToa do hinh sau khi thu phong: A(%.1f,%.1f), B(%.1f,%.1f), C(%.1f,%.1f)",
                        A.getX(), A.getY(), B.getX(), B.getY(), C.getX(), C.getY()));
        AB = khoangCachHaiDiem(A, B);
        AC = khoangCachHaiDiem(A, C);
        BC = khoangCachHaiDiem(B, C);
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
        double xAPrime = x + (xA * cosTheta - yA * sinTheta);
        double yAPrime = y + (xA * sinTheta + yA * cosTheta);
        double xBPrime = x + (xB * cosTheta - yB * sinTheta);
        double yBPrime = y + (xB * sinTheta + yB * cosTheta);
        double xCPrime = x + (xC * cosTheta - yC * sinTheta);
        double yCPrime = y + (xC * sinTheta + yC * cosTheta);
        A.setX(xAPrime);
        A.setY(yAPrime);
        B.setX(xBPrime);
        B.setY(yBPrime);
        C.setX(xCPrime);
        C.setY(yCPrime);
        System.out
                .println(String.format("\nToa do hinh sau khi quay: A(%.1f,%.1f), B(%.1f,%.1f), C(%.1f,%.1f)",
                        xAPrime, yAPrime, xBPrime, yBPrime, xCPrime, yCPrime));
    }

    @Override
    public double tinhChuVi() {
        return AB + AC + BC;
    }

    @Override
    public double tinhDienTich() {
        double p = (AB + BC + AC) / 2;
        return Math.sqrt(p * (p - AB) * (p - AC) * (p - BC));
    }

    public boolean laTamGiac() {
        if ((Math.abs(AC - BC) < AB && AB < (AC + BC)) && (Math.abs(AB - AC) < BC && BC < (AB + AC))
                && (Math.abs(AB - BC) < AC && AC < (AB + BC)))
            return true;

        return false;
    }
}
