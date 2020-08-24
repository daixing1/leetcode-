package ThreadLocal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * User: 兴希
 * Date: 2020/7/21
 * Time: 16:17
 * Description: No Description
 */
public class ThreadLocalTest051 {
    public static String dateToStr(int millisSeconds) {
        Date date = new Date(millisSeconds);
        SimpleDateFormat simpleDateFormat = (SimpleDateFormat)ThreadSafeFormatter.dateFormatThreadLocal.get();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        return simpleDateFormat.format(date);
    }

    private static final ExecutorService executorService = Executors.newFixedThreadPool(100);

    public static void main(String[] args) {
        for (int i = 0; i < 3000; i++) {
            int j = i;
            executorService.execute(() -> {
                String date = dateToStr(j * 1000);
                // 从结果中可以看出是线程安全的，时间没有重复的。
                System.out.println(j+" : "+date);
            });
        }
        executorService.shutdown();
    }
}

class ThreadSafeFormatter {
    public static ThreadLocal dateFormatThreadLocal = ThreadLocal.withInitial(
            () -> new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));

}
