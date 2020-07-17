package MainFunction;

import java.util.Arrays;
import java.util.Comparator;

/**
 * User: 兴希
 * Date: 2020/5/7
 * Time: 9:25
 * Description: 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，
 *              k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。
 */
public class ReconstructQueue {
    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1]==o2[1]){
                    return o2[0]-o1[0];
                }else {
                    return o1[1] - o2[1];
                }
            }
        });
        int pos = 1;
        for (int i=pos;i<people.length;i++){
            int count = 0;
            int[] tmp = people[i];
            for (int j=0;j<pos;j++){
                if (tmp[1]==0&&tmp[0]<=people[j][0]){
                    for (int k=i-1;k>=j;k--){
                        people[k+1] = people[k];
                    }
                    people[j] = tmp;
                    pos++;
                    break;
                }
                if (tmp[1]!=0&&tmp[0]<=people[j][0]){
                    count++;
                }
                if (tmp[1]!=0&&count==tmp[1]){
                    for (int k=i-1;k>j;k--){
                        people[k+1] = people[k];
                    }
                    people[j+1] = tmp;
                    pos++;
                    break;
                }
            }
        }
        return people;
    }

    public static void main(String[] args) {
//        {{8,2},{4,2},{4,5},{2,0},{7,2},{1,4},{9,1},{3,1},{9,0},{1,0}}
        int[][] ints = reconstructQueue(new int[][]{{2,4},{3,4},{9,0},{0,6},{7,1},{6,0},{7,3},{2,5},{1,1},{8,0}});
        System.out.println(ints);
    }
}
