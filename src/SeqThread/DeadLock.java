package SeqThread;

/**
 * User: 兴希
 * Date: 2020/7/10
 * Time: 16:34
 * Description: No Description
 */
public class DeadLock {

    private static Object o1 = new Object();
    private static Object o2 = new Object();

    public void Method1(){
        System.out.println(Thread.currentThread().getName()+"线程执行Method1");
    }
    public void Method2(){
        System.out.println(Thread.currentThread().getName()+"线程执行Method2");
    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
        Thread thread1 = new Thread(() -> {
            synchronized (o1){
                deadLock.Method1();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2){
                    deadLock.Method2();
                }
            }

        });
        Thread thread2 = new Thread(() -> {
            synchronized (o2){
                deadLock.Method2();
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1){
                    deadLock.Method1();

                }
            }

        });
        thread1.start();
        thread2.start();
    }
}
