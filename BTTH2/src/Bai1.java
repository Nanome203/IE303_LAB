import java.util.Scanner;

public class Bai1 {

    static double timDiemTBLonNhat(SinhVien[] danhSachSinhVien, int soLuongSinhVien) {
        double maxScore = danhSachSinhVien[0].getDiemTB();
        double diemTBDangTro = 0;
        for (int i = 1; i < soLuongSinhVien; ++i) {
            diemTBDangTro = danhSachSinhVien[i].getDiemTB();
            if (maxScore < diemTBDangTro)
                maxScore = diemTBDangTro;
        }
        return maxScore;
    }

    static void sapXepSinhVienGiamDanTB(SinhVien[] danhSachSinhVien, int soLuongSinhVien) {
        double diem_TB_ben_trai = 0, diem_TB_ben_phai = 0;
        for (int i = 0; i < soLuongSinhVien - 1; ++i) {
            diem_TB_ben_trai = danhSachSinhVien[i].getDiemTB();
            for (int j = i + 1; j < soLuongSinhVien; ++j) {
                diem_TB_ben_phai = danhSachSinhVien[j].getDiemTB();
                if (diem_TB_ben_trai < diem_TB_ben_phai) {
                    SinhVien temp = danhSachSinhVien[i];
                    danhSachSinhVien[i] = danhSachSinhVien[j];
                    danhSachSinhVien[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int soLuongSinhVien = 0;
        double diemTBMax = 0;
        do {
            System.out.print("Nhap so luong sinh vien: ");
            soLuongSinhVien = scanner.nextInt();
        } while (soLuongSinhVien < 0);
        if (soLuongSinhVien == 0) {
            scanner.close();
            return;
        }
        SinhVien[] danhSachSinhVien = new SinhVien[soLuongSinhVien];
        for (int i = 0; i < soLuongSinhVien; ++i) {
            danhSachSinhVien[i] = new SinhVien();
            System.out.print("Nhap MSSV thu " + (i + 1) + ": ");
            danhSachSinhVien[i].setMSSV(scanner.nextInt());
            scanner.nextLine();
            System.out.print("Nhap ho ten sinh vien thu " + (i + 1) + ": ");
            danhSachSinhVien[i].setHoTen(scanner.nextLine());
            System.out.print("Nhap diem giai tich: ");
            danhSachSinhVien[i].setDiemGiaiTich(scanner.nextDouble());
            System.out.print("Nhap diem vat ly: ");
            danhSachSinhVien[i].setDiemVatLy(scanner.nextDouble());
            System.out.print("Nhap diem nhap mon lap trinh: ");
            danhSachSinhVien[i].setDiemNhapMonLapTrinh(scanner.nextDouble());
        }
        System.out.println("\nDanh sach sinh vien nhan hoc bong: \n");
        System.out.println("Ho va ten\t\tMSSV\n");
        for (int i = 0; i < soLuongSinhVien; ++i) {
            if (danhSachSinhVien[i].getDiemTB() >= 8.0 && danhSachSinhVien[i].getDiemNhapMonLapTrinh() >= 9.0) {
                System.out.println(danhSachSinhVien[i].getHoTen() + "\t\t" + danhSachSinhVien[i].getMSSV());
            }
        }
        System.out.println("\nDanh sach sinh vien co diem trung binh cao nhat: \n");
        System.out.println("MSSV\tHo Ten\t Diem Giai Tich\t Diem Vat Ly\t Diem Nhap Mon Lap Trinh\t Diem TB \n");

        diemTBMax = timDiemTBLonNhat(danhSachSinhVien, soLuongSinhVien);
        for (int i = 0; i < soLuongSinhVien; ++i) {
            if (danhSachSinhVien[i].getDiemTB() == diemTBMax) {
                danhSachSinhVien[i].getToanBoThongTinSinhVien();
            }
        }
        sapXepSinhVienGiamDanTB(danhSachSinhVien, soLuongSinhVien);
        System.out.println("\nDanh sach top 10 sinh vien co diem trung binh cao nhat: \n");
        System.out.println("MSSV\tHo Ten\t Diem Giai Tich\t Diem Vat Ly\t Diem Nhap Mon Lap Trinh\t Diem TB \n");
        for (int i = 0; i < 10; ++i) {
            if (i == soLuongSinhVien)
                break;
            danhSachSinhVien[i].getToanBoThongTinSinhVien();
        }

        scanner.close();

    }
}
