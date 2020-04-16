package MainFunction;

import java.util.HashMap;
import java.util.Hashtable;

/**
 * User: 兴希
 * Date: 2020/3/24
 * Time: 9:26
 * Description: No Description
 */
public class ThreadSafe {
    public static void threadSafe(){
        Hashtable<Integer, String> hashTable = new Hashtable<>();
        Thread t3 = new Thread(){
            public void run(){
                for (int i = 0; i < 20; i++) {
                    hashTable.put(i, String.valueOf(i));
                }
            }
        };
        Thread t4 = new Thread(){
            public void run(){
                for (int i = 20; i < 40; i++) {
                    hashTable.put(i, String.valueOf(i));
                }
            }
        };
        t3.start();
        t4.start();
        //放完数据后，从map中取出数据，如果map是线程安全的，那么取出的entry应该和放进去的一一对应
        for (int i = 0; i < 40; i++) {
            System.out.println(i + "=" + hashTable.get(i));
        }

    }

    public static void threadUnsafe(){
        HashMap<Integer, String> hashTable = new HashMap<>();
        Thread t3 = new Thread(){
            public void run(){
                for (int i = 0; i < 20; i++) {
                    hashTable.put(i, String.valueOf(i));
                }
            }
        };
        Thread t4 = new Thread(){
            public void run(){
                for (int i = 20; i < 40; i++) {
                    hashTable.put(i, String.valueOf(i));
                }
            }
        };
        t3.start();
        t4.start();
        //放完数据后，从map中取出数据，如果map是线程安全的，那么取出的entry应该和放进去的一一对应
        for (int i = 0; i < 40; i++) {
            System.out.println(i + "=" + hashTable.get(i));
        }
    }

    public static void main(String[] args) {
        threadUnsafe();
//        System.out.println(String.valueOf(0));
    }
}
