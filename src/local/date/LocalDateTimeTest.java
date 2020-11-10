package local.date;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

/**
 * @Author zp
 * @create 2020/11/10 15:44
 */
public class LocalDateTimeTest {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        //下一个星期一
        System.out.println(now.with(TemporalAdjusters.next(DayOfWeek.MONDAY)));
        // 自定义,获取下个工作日
        System.out.println(now.with((a) -> {
            LocalDateTime l = (LocalDateTime) a;
            // 获取是周几
            DayOfWeek dayOfWeek = l.getDayOfWeek();
            if (dayOfWeek.equals(DayOfWeek.FRIDAY)) {
                return l.plusDays(3);
            } else if (dayOfWeek.equals(DayOfWeek.SATURDAY)) {
                return l.plusDays(2);
            } else {
                return l.plusDays(1);
            }
        }));
    }
}
