import java.util.Scanner;

public class HinhBinhHanh extends TuGiac {

    HinhBinhHanh() {

    }

    HinhBinhHanh(Scanner sc) {
        super(sc);
    }

    @Override
    public void xuat() {
        if (laHinhBinhHanh()) {
            System.out.println("\nBAN VUA NHAP MOT HINH BINH HANH\n");
        } else {
            System.out.println("\nBAN KHONG VUA NHAP HINH BINH HANH\n");
            System.exit(0);
        }

    }

    public boolean laHinhBinhHanh() {
        return laTuGiac(A, B, C, D) && AB == CD && BC == AD;
    }
}
