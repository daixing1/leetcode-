package MainFunction;

import java.util.Arrays;

/**
 * User: 兴希
 * Date: 2020/8/2
 * Time: 18:02
 * Description: 老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。
 *              你需要按照以下要求，帮助老师给这些孩子分发糖果：
 *              每个孩子至少分配到 1 个糖果。
 *              相邻的孩子中，评分高的孩子必须获得更多的糖果。
 *              那么这样下来，老师至少需要准备多少颗糖果呢？
 */
public class Candy {
//    public int candy(int[] ratings) {
//        int min = Arrays.stream(ratings).min().getAsInt();
//        int[] dp = new int[ratings.length+2];
//        Arrays.fill(dp,1);
//        dp[0] = 0;
//        dp[ratings.length+1] = 0;
//        for (int i=0;i<ratings.length;i++){
//            if (i==0){
//                if (ratings[i]>ratings[i+1]){
//                    dp[i] = dp[i+1]+1;
//                }else {
//                    dp[i] = 1;
//                }
//            }
//        }
//    }

    public static void main(String[] args) throws Exception {
        Candy candy = new Candy();
        Candy candy1 = candy.getClass().newInstance();
        Candy candy2 = Candy.class.newInstance();
        Candy o = (Candy) Class.forName("MainFunction.Candy").newInstance();
    }
}
