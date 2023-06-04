package Model;
import Controller.MainController;
import Controller.NguyenLieuDAO;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MonAn{
    private String maMon;
    private String tenMon;
    private Double dongia;
    private int soLuong;
    private Map<Integer, NguyenLieu> NLYeuCau; 
    
    //Khoi Tao
    public MonAn(){
        NLYeuCau = new HashMap<>();
    }

    public MonAn(String maMon, String tenMon, Double dongia, int soLuong, Map<Integer, NguyenLieu> NLYeuCau) {
        this.maMon = maMon;
        this.tenMon = tenMon;
        this.dongia = dongia;
        this.soLuong = soLuong;
        this.NLYeuCau = NLYeuCau;
    }    
    
    public MonAn(String tenMon){
        this.tenMon = tenMon;
    }
    
    //Add Del Print
    public void addUpNL(NguyenLieu nl){
        for(int key : NLYeuCau.keySet()){
            if(key == nl.getMaNL()){
                this.NLYeuCau.remove(key);
            }
            this.NLYeuCau.put(key, nl);
            break;
        }
    }
    
    public void delNL(NguyenLieu nl){
        for(int key : NLYeuCau.keySet()){
            if(key == nl.getMaNL()){
                this.NLYeuCau.remove(key);
                break;
            }
        }
    }
    
    //Make
    public boolean make(){
        ArrayList<NguyenLieu> ds = new NguyenLieuDAO().getListNL();
        if(!check(ds)){
            return false;
        }
        for (Map.Entry<Integer, NguyenLieu> entry : this.NLYeuCau.entrySet()) {
            int key = entry.getKey();
            NguyenLieu value = entry.getValue();
            for(NguyenLieu tmp : ds){
                if(tmp.getMaNL() == key){
                    tmp.use(value.getSoluongNL()/1000 * this.getSoLuong());
                    break;
                }
            }
        }
        new MainController().UpdateNL(ds);
        return true;
    }
    
    public boolean check(ArrayList<NguyenLieu> ds){
        for (Map.Entry<Integer, NguyenLieu> entry : this.NLYeuCau.entrySet()) {
            int key = entry.getKey();
            NguyenLieu value = entry.getValue();
            for(NguyenLieu tmp : ds){
                if(tmp.getMaNL() == key && !tmp.check(value.getSoluongNL()/1000 * this.getSoLuong())){
                    return false;
                }
            }
        }
        return true;
    }
    //Get Set

    public Double getDongia() {
        return dongia;
    }

    public void setDongia(Double dongia) {
        this.dongia = dongia;
    }

    public Map<Integer, NguyenLieu> getNLYeuCau() {
        return NLYeuCau;
    }

    public void setNLYeuCau(Map<Integer, NguyenLieu> NLYeuCau) {
        this.NLYeuCau = NLYeuCau;
    }

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
   

    
