package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/5/29
 * Time: 8:52
 * Description: 在选举中，第 i 张票是在时间为 times[i] 时投给 persons[i] 的。
 *              现在，我们想要实现下面的查询函数： TopVotedCandidate.q(int t) 将返回在 t 时刻主导选举的候选人的编号。
 *              在 t 时刻投出的选票也将被计入我们的查询之中。在平局的情况下，最近获得投票的候选人将会获胜
 */
public class TopVotedCandidate {

    private int[] persons;
    private int[] times;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
    }

    public int q(int t) {
        Map<Integer,Integer> map = new HashMap<>();
        int i=0;
        while (i<times.length){
            if (times[i]<=t){
                i++;
            }else {
                break;
            }
        }
        for (int j=0;j<i;j++){
            map.put(persons[j],map.getOrDefault(persons[j],0)+1);
        }
        int max = 0;
        List<Integer> list = new ArrayList<>();
        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Integer, Integer> next = iterator.next();
            if (max<next.getValue()){
                max = next.getValue();
                list.clear();
                list.add(next.getKey());
            }
            if (max==next.getValue()){
                list.add(next.getKey());
            }
        }
        if (list.size()==1){
            return list.get(0);
        }
        for (int j=i-1;j>=0;j--){
            if (list.contains(persons[j])){
                return persons[j];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        TopVotedCandidate topVotedCandidate = new TopVotedCandidate(new int[]{0,1,1,0,0,1,0},new int[]{0,5,10,15,20,25,30});
        int q = topVotedCandidate.q(3);
        int q1 = topVotedCandidate.q(12);
        int q2 = topVotedCandidate.q(25);
        int q3 = topVotedCandidate.q(15);
        int q4 = topVotedCandidate.q(24);
        int q5 = topVotedCandidate.q(8);
        System.out.println(q);
        System.out.println(q1);
        System.out.println(q2);
        System.out.println(q3);
        System.out.println(q4);
        System.out.println(q5);
    }
}
