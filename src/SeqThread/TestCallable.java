package SeqThread;

import java.util.concurrent.*;

/**
 * User: 兴希
 * Date: 2020/7/10
 * Time: 16:49
 * Description: No Description
 */
public class TestCallable {

    static class Call implements Callable{

        @Override
        public String call() throws Exception {
            return "callable返回内容";
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Call call = new Call();
        Callable cal = () -> "fanhuizhi";
        FutureTask<String> future = new FutureTask<String>(cal);
        new Thread(future).start();
        try {
            String s = future.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
//        public static void main(String[] args) throws InterruptedException {
//        long l = System.currentTimeMillis();
//        StringBuffer stringBuilder = new StringBuffer();
//        for (int i = 0; i < 10000; i++){
//            new Thread(() -> {
//                for (int j = 0; j < 1000; j++){
//                    stringBuilder.append("a");
//                }
//            }).start();
//        }
//        long l1 = System.currentTimeMillis();
//        Thread.sleep(100L);
//        System.out.println("len: "+stringBuilder.length());
//        System.out.println(l1-l);

//        }

    }
}
