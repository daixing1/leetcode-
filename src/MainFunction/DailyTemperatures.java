package MainFunction;

import java.util.Stack;

/**
 * User: 兴希
 * Date: 2020/6/11
 * Time: 14:19
 * Description: 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。
 *              如果之后都不会升高，请在该位置用 0 来代替。
 *              例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是
 *              [1, 1, 4, 2, 1, 1, 0, 0]。
 *              提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 */
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        for (int i=0;i<T.length;i++){
            for (int j=i+1;j<T.length;j++){
                if (T[j]>T[i]){
                    res[i] = j-i;
                    break;
                }
            }
        }
        return res;
    }

    public static int[] dailyTemperatures1(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[T.length];
        for (int i=0;i<T.length;i++){
            if (stack.isEmpty()){
                stack.push(i);
                continue;
            }else {
                while (!stack.isEmpty()&&T[stack.peek()]<T[i]){
                    ans[stack.peek()] = i-stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = dailyTemperatures1(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println();
    }
}
