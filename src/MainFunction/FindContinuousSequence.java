package MainFunction;

import java.util.ArrayList;

/**
 * User: 兴希
 * Date: 2020/3/5
 * Time: 1:00
 * Description: 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 *              但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得
 *              到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和
 *              为S的连续正数序列?
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> findContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        for (int i=2;i<(int)Math.sqrt(sum*2);i++){
//            for ()
        }
        return null;
    }
}
