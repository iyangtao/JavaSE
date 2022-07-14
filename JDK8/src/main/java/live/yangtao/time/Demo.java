package live.yangtao.time;

import org.junit.Test;

import java.text.DateFormat;
import java.time.*;
import java.time.chrono.Chronology;
import java.time.chrono.IsoChronology;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.*;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Set;

/**
 * @author yangtao
 * @description
 * @create 2022-06-23 20:49
 */
public class Demo {

    /**
     * 创建
     */
    @Test
    public void test1() {
        // 获取当前时间
        LocalDateTime time1 = LocalDateTime.now();
        LocalDateTime time2 = LocalDateTime.now(ZoneId.systemDefault());
        LocalDateTime time3 = LocalDateTime.now(Clock.systemDefaultZone());

        // 指定时间
        LocalDateTime time4 = LocalDateTime.of(2022, 2, 2, 13, 34, 56, 233);

        // 从字符串解析时间
        LocalDateTime time5 = LocalDateTime.parse("2022-03-21T09:23:55.233");
        LocalDateTime time6 = LocalDateTime.parse("2022-02-23 07:12:45", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // 瞬时点
        LocalDateTime time7 = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());

        // 通过时间戳
        LocalDateTime time8 = Instant.ofEpochMilli(1656866702010L).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    /**
     * 获取年月日时分秒
     */
    public void test4() {
        LocalDateTime localDateTime = LocalDateTime.now();      // 2022-02-15T21:23:54.401
        int year = localDateTime.getYear();                     // 2022
        Month month = localDateTime.getMonth();                 // FEBRUARY，英文
        int monthValue = localDateTime.getMonthValue();         // 2，value为数值
        int dayOfYear = localDateTime.getDayOfYear();           // 46
        int dayOfMonth = localDateTime.getDayOfMonth();         // 15
        DayOfWeek dayOfWeek = localDateTime.getDayOfWeek();     // TUESDAY
        int hour = localDateTime.getHour();                     // 21
        int minute = localDateTime.getMinute();                 // 23
        int second = localDateTime.getSecond();                 // 54
        int nano = localDateTime.getNano();                     // 401000000，纳秒（精度 1/999,999,999）
    }

    /**
     * 通过时间矫正器TemporalAdjusters修改时间，LocalDateTime修改会返回一个新的对象
     */
    @Test
    public void test2() {
        LocalDateTime localDateTime = LocalDateTime.now();
        // 本月第一天
        localDateTime.with(TemporalAdjusters.firstDayOfMonth());
        // 本月最后一天
        localDateTime.with(TemporalAdjusters.lastDayOfMonth());
        // 下个月第一天
        localDateTime.with(TemporalAdjusters.firstDayOfNextMonth());
        // 今年第一天
        localDateTime.with(TemporalAdjusters.firstDayOfYear());
        // 今年最后一天
        localDateTime.with(TemporalAdjusters.lastDayOfYear());
        // 明年第一天
        localDateTime.with(TemporalAdjusters.firstDayOfNextYear());
        // 本月第一个周一
        localDateTime.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));
        // 本月最后一个周一
        localDateTime.with(TemporalAdjusters.lastInMonth(DayOfWeek.MONDAY));
        // 本月开始算起，第n个周几，-1表示本月最后一个
        localDateTime.with(TemporalAdjusters.dayOfWeekInMonth(-1, DayOfWeek.MONDAY));
        // 下一个周一
        localDateTime.with(TemporalAdjusters.next(DayOfWeek.MONDAY));
        // 下一个周二，如果当前是周二则返回当前日期
        localDateTime.with(TemporalAdjusters.nextOrSame(DayOfWeek.TUESDAY));
        // 上一个周一
        localDateTime.with(TemporalAdjusters.previous(DayOfWeek.MONDAY));
        // 上一个周二，如果当前是周二则返回当前日期
        localDateTime.with(TemporalAdjusters.previousOrSame(DayOfWeek.TUESDAY));
        // 自定义矫正器，UnaryOperator<LocalDate>
        LocalDateTime time1 = localDateTime.with(TemporalAdjusters.ofDateAdjuster(date -> date.plusDays(2)));
    }

    /**
     * 修改指定的年月日时分秒
     */
    @Test
    public void test3() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.withYear(2023);
        LocalDateTime localDateTime2 = localDateTime.withMonth(3);
        LocalDateTime localDateTime3 = localDateTime.withDayOfMonth(23);
        LocalDateTime localDateTime4 = localDateTime.withHour(12);
        LocalDateTime localDateTime5 = localDateTime.withMinute(23);
        LocalDateTime localDateTime6 = localDateTime.withSecond(33);
        LocalDateTime localDateTime7 = localDateTime.withNano(233000000);
        LocalDateTime localDateTime8 = localDateTime.withDayOfYear(233);
    }

    /**
     * 时间量
     */
    @Test
    public void test9() {
        /*
        创建
         */
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime future = LocalDateTime.parse("2022-6-30 23:59:59", DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));
        // 比较
        Duration duration1 = Duration.between(now, future);
        // 手动创建
        Duration duration2 = Duration.ofDays(20);
        Duration duration3 = Duration.of(10, ChronoUnit.DAYS);
        // 字符串解析
        Duration duration4 = Duration.parse("PT1089H45M");
        /*
        常用API
         */
        Duration duration5 = Duration.between(future, now);
        Duration duration6 = duration5.abs();               // 取绝对值
        int i = duration6.compareTo(duration5);             // 与其他时间比较
        boolean equals = duration6.equals(duration5);       // 是否相同
        Duration duration7 = duration6.dividedBy(2);// 等份划分
        long nano = duration6.get(ChronoUnit.NANOS);        // 取纳秒，与getNano相同
        long second = duration6.get(ChronoUnit.SECONDS);    // 取秒
        boolean negative = duration6.isNegative();          // 判断是否为负
        boolean isZero = duration6.isZero();                // 是否为0
        Duration duration8 = duration6.minus(duration7);        // 减去特定时间
        Duration duration9 = duration6.minusDays(2);
        Duration duration10 = duration6.minus(3, ChronoUnit.DAYS);
        Duration negated = duration6.negated();             // 返回负数
        Duration duration11 = duration6.plus(2, ChronoUnit.DAYS);   // 增加时间
        Duration duration12 = duration6.plusHours(3);
        Duration duration13 = duration6.plus(duration2);
        long days = duration6.toDays();                     // 转换为天数（去零）
        long nanos = duration6.toNanos();
        Duration duration14 = duration6.withSeconds(20);    // 修改秒数，不修改纳秒数
        Duration duration15 = duration6.withNanos(2333);
        Duration duration16 = Duration.parse("PT47H");
        System.out.println(duration16.toDays());
    }

    /**
     * 日期差
     */
    @Test
    public void test10() {
        /*
        创建
         */
        LocalDate now = LocalDate.now();
        LocalDate future = LocalDate.parse("2022-12-31", DateTimeFormatter.ISO_DATE);
        // 比较
        Period period = now.until(future);  // P6M7D
        // 手动创建
        Period period1 = Period.ofDays(10);
        Period period2 = Period.of(2, 3, 1);
        Period period3 = Period.ofWeeks(2);
        // 字符串解析
        Period period4 = Period.parse("P2M2D");
        /*
        常用API：与Duration有许多类似的方法，如相等判断、取反、加减天数
         */
        boolean equals = period4.equals(period1);   // 是否相等
        Period period5 = period4.plus(period2);     // 相加
        long l = period4.get(ChronoUnit.YEARS);     // 只接受YEARS、MONTHS、DAYS，与getYears等效
        int months = period4.getMonths();           // 获取月份
        int days = period4.getDays();
        boolean negative = period4.isNegative();    // 是否为负数
        boolean zero = period4.isZero();            // 是否为零
        Period minus = period4.minus(period1);      // 相减
        Period period6 = period4.minusMonths(2);    // 减去月数，可选年、日
        Period negated = minus.negated();           // 取反
        Period period7 = period4.normalized();      // 标准化
        Period period8 = period4.plus(period5);     // 相加
        Period period9 = period4.plusDays(2);   // 加若干天
        LocalDate localDate = (LocalDate) period4.subtractFrom(LocalDate.now());      // 从指定的日期中减去次周期
        Period period10 = period4.withMonths(4);    // 修改月数
    }

    /**
     * 时间加减，年月周日时分秒纳秒，或指定数量指定单位，或时间间隔
     */
    @Test
    public void test6() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime1 = now.plusYears(2);
        LocalDateTime localDateTime2 = now.plusMonths(2);
        LocalDateTime localDateTime3 = now.plusWeeks(2);
        LocalDateTime localDateTime4 = now.plusDays(2);
        LocalDateTime localDateTime5 = now.plusHours(2);
        LocalDateTime localDateTime6 = now.plusMinutes(2);
        LocalDateTime localDateTime7 = now.plusSeconds(2);
        LocalDateTime localDateTime8 = now.plusNanos(2);
        LocalDateTime LocalDateTime9 = now.plus(20, ChronoUnit.DAYS);
        LocalDateTime localDateTime0 = now.plus(Duration.ofSeconds(200));

        LocalDateTime localDateTime11 = now.minusYears(2);
        LocalDateTime localDateTime12 = now.minusMonths(2);
        LocalDateTime localDateTime13 = now.minusWeeks(2);
        LocalDateTime localDateTime14 = now.minusDays(2);
        LocalDateTime localDateTime15 = now.minusHours(2);
        LocalDateTime localDateTime16 = now.minusMinutes(2);
        LocalDateTime localDateTime17 = now.minusSeconds(2);
        LocalDateTime localDateTime18 = now.minusNanos(2);
        LocalDateTime LocalDateTime19 = now.minus(20, ChronoUnit.DAYS);
        LocalDateTime localDateTime10 = now.minus(Duration.ofSeconds(200));
    }

    /**
     * 时区
     */
    @Test
    public void test13() {
        // 默认时区
        ZonedDateTime zonedDateTime1 = ZonedDateTime.now();
        ZonedDateTime zonedDateTime2 = ZonedDateTime.now(ZoneId.systemDefault());
        // 指定时区
        ZonedDateTime newYorkTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
        // 时区转换
        ZonedDateTime shanghaiTime = newYorkTime.withZoneSameInstant(ZoneId.of("Asia/Shanghai"));
        // 转换为本地时间
        LocalDateTime localDateTime = newYorkTime.toLocalDateTime();
    }

    /**
     * 时间戳
     */
    @Test
    public void test14() {
        // 中时区的时间
        Instant now = Instant.now();
        // 转为时区时间：东八区
        OffsetDateTime offsetDateTime = now.atOffset(ZoneOffset.ofHours(8));
        // 毫秒时间戳
        long epochMilli = now.toEpochMilli();
        // 秒时间戳
        long epochSecond = now.getEpochSecond();
        // 当前纳秒
        int nano = now.getNano();
        //实例化：通过给定的毫秒数/秒数
        Instant instant = Instant.ofEpochSecond(1675888882);
        // 通过时间戳创建时区时间
        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());
    }

    /**
     * 时间转换
     */
    @Test
    public void test12() {
        LocalDateTime localDateTime = LocalDateTime.now();
        // 转换为时间戳
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        System.out.println(instant.toEpochMilli());
        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();
        LocalDateTime localDateTime1 = localDateTime.truncatedTo(ChronoUnit.DAYS);      // 时间截断至天：2022-06-24T00:00
        LocalDateTime localDateTime2 = localDateTime.truncatedTo(ChronoUnit.HOURS);     // 时间截断至时：2022-06-24T20:00
    }

    /**
     * 时间比较
     */
    @Test
    public void test5() {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime tomorrow = today.with(TemporalAdjusters.ofDateAdjuster(date -> date.plusDays(1)));
        today.isAfter(tomorrow);        // false
        today.isBefore(tomorrow);       // true
        today.isEqual(tomorrow);        // false
    }

    /**
     * 时间格式化
     */
    @Test
    public void test7() {
        LocalDateTime now = LocalDateTime.now();
        //2022-06-23T23:20:54.762
        DateTimeFormatter.ISO_DATE_TIME.format(now);
        //2022-06-23
        DateTimeFormatter.ISO_DATE.format(now);
        //23:20:54.762
        DateTimeFormatter.ISO_TIME.format(now);
        //20220623
        DateTimeFormatter.BASIC_ISO_DATE.format(now);
        //2022-W25-4
        DateTimeFormatter.ISO_WEEK_DATE.format(now);
        //22-6-23 下午11:20
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT).format(now);
        //2022-6-23 23:20:54
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM).format(now);
        //2022年6月23日 下午11时20分54秒
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).format(now);
        //2022年6月23日 星期四 下午11时20分54秒 CT
        DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withZone(ZoneId.systemDefault()).format(now);
        //2022-06-23 23:20:54
        DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").format(now);
        //2022-06-23 星期四 23:20:54
        DateTimeFormatter.ofPattern("yyyy-MM-dd EE HH:mm:ss", Locale.CHINA).format(now);
        //2022-06-23T15:20:54.789Z
        DateTimeFormatter.ISO_INSTANT.format(Instant.now());
    }




}
