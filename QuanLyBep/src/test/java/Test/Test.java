package Test;
import Model.MonAn;
import Model.NguyenLieu;
import Model.SuatAn;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
public class Test {
	public static void main(String[] args){
            LocalDateTime now = LocalDateTime.now();
            Timestamp timestamp = Timestamp.valueOf(now);
            System.out.println("Ngay thang va thoi gian hien tai: " + timestamp.toLocalDateTime());
	}
}
