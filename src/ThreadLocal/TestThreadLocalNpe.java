package ThreadLocal;

import java.util.Collection;

/**
 * User: 兴希
 * Date: 2020/7/21
 * Time: 16:54
 * Description: No Description
 */
public class TestThreadLocalNpe {

    private static ThreadLocal<Long> threadLocal = new ThreadLocal();

    public static void set() {
        threadLocal.set(1L);
    }

    public static Long get() {
        return threadLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        String s = new String("123");
        new Thread(() -> {
            set();
            System.out.println(get());
        }).start();
        // 目的就是为了让子线程先运行完
        Thread.sleep(100);
        System.out.println(get());
    }
}
