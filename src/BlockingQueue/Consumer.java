package BlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * User: 兴希
 * Date: 2020/7/10
 * Time: 16:21
 * Description: No Description
 */
public class Consumer implements Runnable{
    private LinkedBlockingQueue<Object> queue;

    public Consumer(LinkedBlockingQueue<Object> linkedBlockingQueue){
        queue = linkedBlockingQueue;
    }

    @Override
    public void run() {
        while (true){
            try {
                System.out.println("消费者资源数："+queue.size());
                Object take = queue.take();
                take(take);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void take(Object o){
        try {
            Thread.sleep(100);
            System.out.println("消费的资源: "+o);
        } catch (InterruptedException e) {
            System.out.println("消费者消费资源失败");
            e.printStackTrace();
        }

    }
}
