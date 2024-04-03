import java.util.Scanner;

public abstract class DaGiac {

    public Scanner scanner;

    public abstract void nhap();

    public abstract void xuat();

    public abstract void tinhTien();

    public abstract void thuPhong();;

    public abstract void quay();

    public abstract double tinhChuVi();

    public abstract double tinhDienTich();

    public double khoangCachHaiDiem(ToaDo A, ToaDo B) {
        return Math.sqrt(Math.pow(B.getX() - A.getX(), 2) + Math.pow(B.getY() - A.getY(), 2));
    }
}
