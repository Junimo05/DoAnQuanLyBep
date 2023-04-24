package Test;
import Model.MonAn;
import Model.NguyenLieu;
import Model.SuatAn;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
public class Test {
	public static void main(String[] args){
            LocalDate now = LocalDate.now();
            java.sql.Date sqlDate = java.sql.Date.valueOf(now);
            SuatAn sa = new SuatAn(1);
            ArrayList<NguyenLieu> ar = new ArrayList<>();
            NguyenLieu BotMi = new NguyenLieu(1, "BotMi", sqlDate, 99, 1000);
            ar.add(BotMi);
            MonAn ma = new MonAn(01, "Cơm Cháy", 10000);
            ma.addUpNL(BotMi, 100);
            ma.printDs();
            sa.capNhatMonAn(ma, 1);
            System.out.println(sa.make());
	}
}
