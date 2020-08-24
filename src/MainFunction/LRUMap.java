package MainFunction;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * User: 兴希
 * Date: 2020/7/23
 * Time: 9:41
 * Description: 关联容器map保存<key, value>数据，能通过key快速存储或查找记录。请设计一个map，能够满足以下要求：
 *                  1. map的容量size是一个固定值N，即map最多保存N个<key, value>记录；
 *                  2. map insert一个<key, value>前，首先判断这个key是否已经在map中存在：
 *                      1) 如果存在：记这个已存在的记录为<key, old_value>，若old_value<value，
 *                      则把old_value更新为value；否则，不做更新。
 *                      2) 如果不存在：
 *                          若size<N，则执行map的insert，保存这个<key, value>，且size+=1；
 *                          若size==N，先淘汰掉一个更新时间最早的记录，再执行map的insert，保存这个<key, value>，
 *                          size保持为N不变。
 *              说明：记录的更新时间默认为其被insert进map的时间，之后的某一时刻T，如果这个记录的value被更新，
 *              那么，该记录的更新时间就变为T。
 */
public class LRUMap {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        Map<String, Node> map = new HashMap<>(size);
        int index = 0;
        while (scanner.hasNext()){
            String s = scanner.next();
            String[] split = s.split(" ");
            String key = split[0];
            Integer value = Integer.valueOf(split[1]);
            Node node = new Node(value);
            if (map.size()<size){
                map.put(key,node);

            }
        }

    }

    public static void removeHead(){

    }

    static class Node{
        int value;
        Node next;
        Node head;
        Node tail;
        public Node(int value){
            this.value = value;
        }
    }
}
