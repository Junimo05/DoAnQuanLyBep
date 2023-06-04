package Model;
import java.util.Objects;

public class NhanVien {
    private String maNV;
    private String tenNV;
    private boolean gioiTinh;
    private int tuoi;
    private String sodienThoai;
    
    public NhanVien(){
        
    }
    
    public NhanVien(String maNV, String tenNV, boolean gioiTinh, int tuoi , double luong, String sodienThoai) {
            this.maNV = maNV;
            this.tenNV = tenNV;
            this.tuoi = tuoi;
            this.gioiTinh = gioiTinh;
    }
    // Get Set()	

    public int getTuoi() {
        return tuoi;
    }
    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }
    public String getTenNV() {
            return tenNV;
    }
    public void setTenNV(String tenNV) {
            this.tenNV = tenNV;
    }
    public String getMaNV() {
            return maNV;
    }
    public void setMaNV(String maNV) {
            this.maNV = maNV;
    }
    public boolean getGioiTinh() {
            return gioiTinh;
    }
    public void setGioiTinh(boolean gioiTinh) {
            this.gioiTinh = gioiTinh;
    }
    public String getsodienThoai(){
            return sodienThoai;
    }
    public void setsodienThoai(String sodienThoai){
            this.sodienThoai = sodienThoai;
    }
    
    //Hashcode and equals
    
    @Override
    public String toString() {
        return "NhanVien{" + "maNV=" + maNV + ", tenNV=" + tenNV + ", gioiTinh=" + gioiTinh + ", tuoi=" + tuoi + ", sodienThoai=" + sodienThoai + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.maNV);
        hash = 19 * hash + Objects.hashCode(this.tenNV);
        hash = 19 * hash + (this.gioiTinh ? 1 : 0);
        hash = 19 * hash + this.tuoi;
        hash = 19 * hash + Objects.hashCode(this.sodienThoai);
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
        final NhanVien other = (NhanVien) obj;
        if (this.gioiTinh != other.gioiTinh) {
            return false;
        }
        if (this.tuoi != other.tuoi) {
            return false;
        }
        if (!Objects.equals(this.maNV, other.maNV)) {
            return false;
        }
        if (!Objects.equals(this.tenNV, other.tenNV)) {
            return false;
        }
        return Objects.equals(this.sodienThoai, other.sodienThoai);
    }
    
}
	