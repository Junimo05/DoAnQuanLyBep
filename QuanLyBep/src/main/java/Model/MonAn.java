package Model;
import Model.NguyenLieu;
import java.util.HashMap;
import java.util.Map;

public class MonAn{
    private int maMon;
    private String tenMon;
    private int dongia;
    private Map<NguyenLieu, Integer> NLYeuCau; 
    
    //Khoi Tao
    public MonAn(){
    }
    
    public MonAn(int maMon, String tenMon, int dongia) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.dongia = dongia;
        this.NLYeuCau = new HashMap<NguyenLieu, Integer>();
    }
    
    public MonAn(String tenMon){
        this.tenMon = tenMon;
    }
    //Add Del Print
    public void addUpNL(NguyenLieu name, int tieuThu){
        if(this.NLYeuCau.containsKey(name)){
            this.NLYeuCau.remove(name);
        }
        this.NLYeuCau.put(name, tieuThu);
    }
    
    public void delNL(NguyenLieu name, int tieuThu){
        if(this.NLYeuCau.containsKey(name)){
            this.NLYeuCau.remove(name);
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
    public int getMaMon() {
        return maMon;
    }

    public void setmaMon(int maMon) {
        this.maMon = maMon;
    }

    public String getTenMon() {
        return tenMon;
    }

    public void setTenMon(String tenMon) {
        this.tenMon = tenMon;
    }
    
    public int getdongia(){
    	return dongia;
    }
    
    public void setgia(int dongia){
    	this.dongia = dongia;
    }
    
    //HashCode equals toString

    @Override
    public String toString() {
        return "MonAn{" + "tenMon=" + tenMon + ", maSuat=" + maMon + ", dongia=" + dongia + '}';
    }
     
    @Override
    public int hashCode() {
        int hash = 3;
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
        if (this.maMon != other.maMon) {
            return false;
        }
        return (this.tenMon == null) ? (other.tenMon == null) : this.tenMon.equals(other.tenMon);
    }
    
}
   

    
