package BlockingQueue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * User: 兴希
 * Date: 2020/7/10
 * Time: 16:21
 * Description: No Description
 */
public class ProducerConsumerExample {
    public static void main(String[] args) {
        LinkedBlockingQueue<Object> queue = new LinkedBlockingQueue<>(5);
        int producerNum = 5;
        int consumerNum = 6;
        for (int i=0;i<producerNum;i++){
            new Thread(new Producer(queue)).start();
        }
        for (int i=0;i<consumerNum;i++){
            new Thread(new Consumer(queue)).start();
        }
    }
}
