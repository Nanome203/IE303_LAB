import java.text.DecimalFormat;

public class SinhVien {
    private int MSSV;
    private String hoTen;
    private double diemGiaiTich = 0;
    private double diemVatLy = 0;
    private double diemNhapMonLapTrinh = 0;
    private double diemTB = 0;

    public void setMSSV(int mssv) {
        this.MSSV = mssv;
    }

    public int getMSSV() {
        return this.MSSV;
    }

    public void setHoTen(String hoten) {
        this.hoTen = hoten;
    }

    public String getHoTen() {
        return this.hoTen;
    }

    public void setDiemGiaiTich(double score) {
        this.diemGiaiTich = score;
        this.diemTB = (this.diemGiaiTich + this.diemNhapMonLapTrinh + this.diemVatLy) / 3;
    }

    public double getDiemGiaiTich() {
        return this.diemGiaiTich;
    }

    public void setDiemVatLy(double score) {
        this.diemVatLy = score;
        this.diemTB = (this.diemGiaiTich + this.diemNhapMonLapTrinh + this.diemVatLy) / 3;
    }

    public double getDiemVatLy() {
        return this.diemVatLy;
    }

    public void setDiemNhapMonLapTrinh(double score) {
        this.diemNhapMonLapTrinh = score;
        this.diemTB = (this.diemGiaiTich + this.diemNhapMonLapTrinh + this.diemVatLy) / 3;
    }

    public double getDiemNhapMonLapTrinh() {
        return this.diemNhapMonLapTrinh;
    }

    public double getDiemTB() {
        return this.diemTB;
    }

    public void getToanBoThongTinSinhVien() {
        DecimalFormat df = new DecimalFormat(".##");
        System.out.println(
                this.MSSV + "\t" + this.hoTen + "\t" + df.format(this.diemGiaiTich) + "\t" +
                        df.format(this.diemVatLy) + "\t" + df.format(this.diemNhapMonLapTrinh) + "\t"
                        + df.format(this.diemTB) + "\t");
    }
}
