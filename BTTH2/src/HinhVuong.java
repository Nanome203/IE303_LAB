import java.util.Scanner;

public class HinhVuong extends HinhChuNhat {
    HinhVuong() {

    }

    HinhVuong(Scanner sc) {
        super(sc);
    }

    @Override
    public void xuat() {
        if (laHinhVuong()) {
            System.out.println("\nBAN VUA NHAP MOT HINH VUONG\n");
        } else {
            System.out.println("\nBAN KHONG VUA NHAP HINH VUONG\n");
            System.exit(0);
        }

    }

    @Override
    public double tinhChuVi() {
        return AB * 4;
    }

    public boolean laHinhVuong() {
        return laHinhChuNhat() && AB == BC;
    }
}
