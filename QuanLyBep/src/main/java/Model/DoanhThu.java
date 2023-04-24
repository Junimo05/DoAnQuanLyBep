package Model;

import Model.NguyenLieu;
import Model.MonAn;

public class DoanhThu {
	private double doanhThu;
	private double loiNhuan;
	public DoanhThu(double doanhThu, double loiNhuan) {
		this.doanhThu = doanhThu;
		this.loiNhuan = loiNhuan;
		
	}
	public double getDoanhThu() {
		return doanhThu;
	}
	public void setDoanhThu(double doanhThu) {
		this.doanhThu = doanhThu;
	}
	public double getLoiNhuan() {
		return loiNhuan;
	}
	public void setLoiNhuan(double loiNhuan) {
		this.loiNhuan = loiNhuan;
	}
//	public double dT(){
//            double result;
//            
//            return result;
//        }
}
