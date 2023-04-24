package Model;
import java.sql.Date;
import java.util.ArrayList;
public class NguyenLieu{
    private int maNL;
    private String tenNL;
    private Date ngay; 
    private int soluongNL;
    private int giaNL;
    
    //Khởi Tạo
    public NguyenLieu() {
    }

    public NguyenLieu(int maNL, String tenNL, Date ngay, int soluongNL, int giaNL) {
        this.maNL = maNL;
        this.tenNL = tenNL;
        this.ngay = ngay;
        this.soluongNL = soluongNL;
        this.giaNL = giaNL;
    }

    public NguyenLieu(String tenNL, int tieuThu) {
        this.tenNL = tenNL;
        this.soluongNL = tieuThu;
    }
    
    //Add use check
    public void add(int soLuong){
        this.soluongNL += soLuong;
    }
    public void use(int soLuong){
        this.soluongNL -= soLuong;
    }
    public boolean check(int soLuong){
        if(this.soluongNL >= soLuong){
            return true;
        }
        return false;
    }
    // Get Set()
    public int getMaNL() {
            return maNL;
    }
    public void setMaNL(int maNL) {
            this.maNL = maNL;
    }
    public String getTenNL() {
            return tenNL;
    }
    public void setTenNL(String tenNL) {
            this.tenNL = tenNL;
    }
    public Date getNgay() {
            return ngay;
    }
    public void setNgay(Date ngay) {
            this.ngay = ngay;
    }
    public int getSoluongNL() {
            return soluongNL;
    }
    public void setSoluongNL(int soluongNL) {
            this.soluongNL = soluongNL;
    }
    public int getGiaNL() {
            return giaNL;
    }
    public void setGiaNL(int giaNL) {
            this.giaNL = giaNL;
    }
    
    //HashCode and equals, toString
    @Override
    public String toString() {
        return "NguyenLieu{" + "maNL=" + maNL + ", tenNL=" + tenNL + ", ngay=" + ngay + ", soluongNL=" + soluongNL + ", giaNL=" + giaNL + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + this.maNL;
        hash = 17 * hash + (this.tenNL != null ? this.tenNL.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final NguyenLieu other = (NguyenLieu) obj;
        if (this.maNL != other.maNL) {
            return false;
        }
        return (this.tenNL == null) ? (other.tenNL == null) : this.tenNL.equals(other.tenNL);
    }
    
}