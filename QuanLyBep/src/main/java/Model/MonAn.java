package Model;
import Model.NguyenLieu;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MonAn{
    private String maMon;
    private String tenMon;
    private Double dongia;
    private int soLuong;
    private Map<NguyenLieu, Integer> NLYeuCau; 
    
    //Khoi Tao
    public MonAn(){
    }
    
    public MonAn(String maMon, String tenMon, int soLuong, Double dongia) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.dongia = dongia;
        this.soLuong = soLuong;
        this.NLYeuCau = new HashMap<NguyenLieu, Integer>();
    }
    
    public MonAn(String tenMon){
        this.tenMon = tenMon;
    }
    //Add Del Print
    public void addUpNL(int ma, int tieuThu){
        for(NguyenLieu key : NLYeuCau.keySet()){
            if(key.getMaNL() == ma){
                this.NLYeuCau.remove(key);
            }
            this.NLYeuCau.put(key, tieuThu);
            break;
        }
        
    }
    
    public void delNL(int ma){
        for(NguyenLieu key : NLYeuCau.keySet()){
            if(key.getMaNL() == ma){
                this.NLYeuCau.remove(key);
                break;
            }
        }
    }
    
    public void printDs(){
        for (Map.Entry<NguyenLieu, Integer> entry : NLYeuCau.entrySet()) {
            NguyenLieu key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key.getTenNL() + ": " + value + "\n");
        } 
    }
    //Make
    public boolean make(){
        if(check()){
            for (Map.Entry<NguyenLieu, Integer> entry : this.NLYeuCau.entrySet()) {
                NguyenLieu key = entry.getKey();
                Integer value = entry.getValue();
                key.use(value);
            }
            return true;
        }
        return false;
    }
    public boolean check(){
        for (Map.Entry<NguyenLieu, Integer> entry : this.NLYeuCau.entrySet()) {
            NguyenLieu key = entry.getKey();
            Integer value = entry.getValue();
            if(!key.check(value)){
                return false;
            }
        }
        return true;
    }
    //Get Set

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
    
    public String getMaMon() {
        return maMon;
    }

    public void setmaMon(String maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }
    
    public Double getdongia(){
    	return dongia;
    }
    
    public void setgia(Double dongia){
    	this.dongia = dongia;
    }
    
    //HashCode equals toString

    @Override
    public int hashCode() {
        int hash = 7;
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
        final MonAn other = (MonAn) obj;
        return Objects.equals(this.maMon, other.maMon);
    }
   
}
   

    
