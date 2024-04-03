import java.util.Scanner;

public class HinhChuNhat extends HinhBinhHanh {
    HinhChuNhat() {

    }

    HinhChuNhat(Scanner sc) {
        super(sc);
    }

    @Override
    public void xuat() {
        if (laHinhChuNhat()) {
            System.out.println("\nBAN VUA NHAP MOT HINH CHU NHAT\n");
        } else {
            System.out.println("\nBAN KHONG VUA NHAP HINH CHU NHAT\n");
            System.exit(0);
        }

    }

    @Override
    public double tinhDienTich() {
        return AB * BC;
    }

    public boolean laHinhChuNhat() {
        double xAB = B.getX() - A.getX(), xAD = D.getX() - A.getX();
        double yAB = B.getY() - A.getY(), yAD = D.getY() - A.getY();
        double tichVoHuong = xAB * xAD + yAB * yAD;

        return laHinhBinhHanh() && tichVoHuong == 0;
    }
}
