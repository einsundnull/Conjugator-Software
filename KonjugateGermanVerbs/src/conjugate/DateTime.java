package conjugate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTime {

	public class CurrentDateTimeExample1 {

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		public void printDate() {
			System.out.println("" + dtf.format(now));
		}
	}
}
