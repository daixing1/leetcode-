package MainFunction;

import java.util.Arrays;

/**
 * User: 兴希
 * Date: 2020/7/7
 * Time: 9:15
 * Description: 爱丽丝有一手（hand）由整数数组给定的牌。 
 *              现在她想把牌重新排列成组，使得每个组的大小都是 W，且由 W 张连续的牌组成。
 *              如果她可以完成分组就返回 true，否则返回 false。
 */
public class IsNStraightHand {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length%W!=0){
            return false;
        }
        Arrays.sort(hand);
        int count = 1;
        int diff = 0;
        int tmp = hand[0];
        hand[0] = -1;
        for (int i=1;i<hand.length;i++){
            if (hand[i]==-1){
                if (diff!=0){
                    diff++;
                }
                continue;
            }
            if (count==W){
                count = 1;
                i-=diff;
                tmp = hand[i];
                hand[i] = -1;
                diff = 0;
                continue;
            }
            if (hand[i]-tmp==1){
                if (diff!=0){
                    diff++;
                }
                tmp = hand[i];
                hand[i] = -1;
                count++;
                continue;
            } else if (hand[i]==tmp){
                diff++;
                continue;
            } else {
                return false;
            }
        }
        if (diff!=0||(count!=1&&count!=W)){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        IsNStraightHand isNStraightHand = new IsNStraightHand();
        boolean flag = isNStraightHand.isNStraightHand(new int[]{1,2,3,6,2,3,4,7,8},3);
        System.out.println(flag);
    }
}
