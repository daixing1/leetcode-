package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/31
 * Time: 21:27
 * Description: 在《英雄联盟》的世界中，有一个叫 “提莫” 的英雄，他的攻击可以让敌方英雄艾希（编者注：寒冰射手）
 *              进入中毒状态。现在，给出提莫对艾希的攻击时间序列和提莫攻击的中毒持续时间，你需要输出艾希的中毒状态总时长。
 *              你可以认为提莫在给定的时间点进行攻击，并立即使艾希处于中毒状态。
 */
public class FindPoisonedDuration {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        if (timeSeries==null||timeSeries.length==0){
            return 0;
        }
        int endTime = 0;
        int allTime = 0;
        endTime = timeSeries[0]+duration;
        for (int i=1;i<timeSeries.length;i++){
            if (endTime>timeSeries[i]){
                allTime+=duration-(endTime-timeSeries[i]);
            }else {
                allTime+=duration;
            }
            endTime = timeSeries[i]+duration;
        }
        return allTime+duration;
    }

    public static void main(String[] args) {
        FindPoisonedDuration findPoisonedDuration = new FindPoisonedDuration();
        int total = findPoisonedDuration.findPoisonedDuration(new int[]{1,2,3}, 2);
        System.out.println(total);
    }
}
