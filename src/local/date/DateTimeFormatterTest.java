package local.date;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author zp
 * @create 2020/11/10 15:53
 */
public class DateTimeFormatterTest {
    public static void main(String[] args) {
        DateTimeFormatter df = DateTimeFormatter.ISO_DATE_TIME;
        LocalDateTime now = LocalDateTime.now();
        String format = now.format(df);
        System.out.println(format);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
        System.out.println(now.format(dtf));
    }
}
