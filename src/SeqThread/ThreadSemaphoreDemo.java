package SeqThread;

import java.util.concurrent.Semaphore;

/**
 * User: 兴希
 * Date: 2020/7/7
 * Time: 15:55
 * Description: 使用Sephmore(信号量)实现线程按顺序运行
 *              应用场景:Semaphore可以用来做流量分流，特别是对公共资源有限的场景，比如数据库连接。假设有这个的需求，
 *                      读取几万个文件的数据到数据库中，由于文件读取是IO密集型任务，可以启动几十个线程并发读取，
 *                      但是数据库连接数只有10个，这时就必须控制最多只有10个线程能够拿到数据库连接进行操作。
 *                      这个时候，就可以使用Semaphore做流量控制。
 */
public class ThreadSemaphoreDemo {
    private static Semaphore semaphore1 = new Semaphore(1);
    private static Semaphore semaphore2 = new Semaphore(1);
    public static void main(String[] args) {
        final Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("产品经理规划新需求");
                semaphore1.release();
            }
        });

        final Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore1.acquire();
                    System.out.println("开发人员开发新需求功能");
                    semaphore2.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    semaphore2.acquire();
                    thread2.join();
                    semaphore2.release();
                    System.out.println("测试人员测试新功能");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        System.out.println("早上：");
        System.out.println("测试人员来上班了...");
        thread3.start();
        System.out.println("产品经理来上班了...");
        thread1.start();
        System.out.println("开发人员来上班了...");
        thread2.start();
    }

}
