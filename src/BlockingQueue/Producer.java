package BlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * User: 兴希
 * Date: 2020/7/10
 * Time: 16:20
 * Description: 生产者
 */
public class Producer implements Runnable {

    private LinkedBlockingQueue<Object> queue;

    public Producer(LinkedBlockingQueue<Object> linkedBlockingQueue){
        queue = linkedBlockingQueue;
    }

    @Override
    public void run() {
        while (true){
            Object object = getObject();
            try {
                queue.put(object);
                System.out.println("生产者资源："+queue.size());
            } catch (InterruptedException e) {
                System.out.println("生产者资源入队失败");
                e.printStackTrace();
            }
        }
    }

    private Object getObject(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            System.out.println("生产者生产资源失败");
            e.printStackTrace();
        }
        return new Object();
    }
}
