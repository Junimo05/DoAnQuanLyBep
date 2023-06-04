package Model;
import java.sql.Date;
public class NguyenLieu{
    private int maNL;
    private String tenNL;
    private Date ngay; 
    private Float khoiLuongNL;
    private int giaNL;
    
    //Khởi Tạo
    public NguyenLieu() {
    }

    public NguyenLieu(int maNL, String tenNL ,Date ngay, int giaNL, Float khoiLuongNL ) {
        this.maNL = maNL;
        this.tenNL = tenNL;
        this.ngay = ngay;
        this.khoiLuongNL = khoiLuongNL;
        this.giaNL = giaNL;
    }
    
    public void update(NguyenLieu nl){
        this.maNL = nl.maNL;
        this.tenNL = nl.tenNL;
        this.ngay = nl.ngay;
        this.khoiLuongNL = nl.khoiLuongNL;
        this.giaNL = nl.giaNL;
    }
    
    public void use(Float soLuong){
        this.khoiLuongNL -= soLuong;
    }
    
    public boolean check(Float soLuong){
        if(this.khoiLuongNL >= soLuong){
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
    public Float getSoluongNL() {
            return khoiLuongNL;
    }
    public void setSoluongNL(Float soluongNL) {
            this.khoiLuongNL = soluongNL;
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
        return "NguyenLieu{" + "maNL=" + maNL + ", tenNL=" + tenNL + ", ngay=" + ngay + ", soluongNL=" + khoiLuongNL + ", giaNL=" + giaNL + '}';
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