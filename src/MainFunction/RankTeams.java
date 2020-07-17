package MainFunction;

import java.util.*;

/**
 * User: 兴希
 * Date: 2020/6/17
 * Time: 8:45
 * Description: 现在有一个特殊的排名系统，依据参赛团队在投票人心中的次序进行排名，每个投票者都需要按从高到低的顺序对参与排
 *              名的所有团队进行排位。
 *              排名规则如下：
 *                  参赛团队的排名次序依照其所获「排位第一」的票的多少决定。如果存在多个团队并列的情况，
 *                  将继续考虑其「排位第二」的票的数量。以此类推，直到不再存在并列的情况。
 *                  如果在考虑完所有投票情况后仍然出现并列现象，则根据团队字母的字母顺序进行排名。
 *              给你一个字符串数组 votes 代表全体投票者给出的排位情况，请你根据上述排名规则对所有参赛团队进行排名。
 *              请你返回能表示按排名系统 排序后 的所有团队排名的字符串。
 */
public class RankTeams {
    public String rankTeams(String[] votes) {
        if (votes.length==0){
            return "";
        }
        if (votes.length==1){
            return votes[0];
        }
        Map<Character, Integer> map = new TreeMap<>();
        List<List<Character>> tiedlist = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<votes[0].length();i++){
            map.clear();
            List<Character> list = new ArrayList<>();
            for (int j=0;j<votes.length;j++){
                char c = votes[j].charAt(i);
                map.put(c,map.getOrDefault(c,0)+1);
            }
            Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()){

            }
        }
        return "";
    }
}
