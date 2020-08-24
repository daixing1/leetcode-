package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/8/16
 * Time: 22:49
 * Description: No Description
 */
public class Vote {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int m = scanner.nextInt();
            Map<String,Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < m; i++) {
                map.put(scanner.next(),0);
            }
            map.put("Invalid",0);
            int n = scanner.nextInt();
            for (int i = 0; i < n; i++) {
                String s = scanner.next();
                if (map.containsKey(s)){
                    map.put(s,map.get(s)+1);
                }else {
                    map.put("Invalid",map.get("Invalid")+1);
                }
            }
            Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String, Integer> next = iterator.next();
                System.out.println(next.getKey()+":"+next.getValue());
            }
        }
    }
}
