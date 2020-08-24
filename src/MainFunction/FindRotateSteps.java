package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/31
 * Time: 21:36
 * Description: 视频游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，
 *              并使用表盘拼写特定关键词才能开门。
 *              给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。
 *              您需要算出能够拼写关键词中所有字符的最少步数。
 *              最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在
 *              12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
 *              旋转 ring 拼出 key 字符 key[i] 的阶段中：
 *                  您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与
 *                  12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
 *                  如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。
 *                  按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
 */
public class FindRotateSteps {
//    Lid lid = new Lid(-1);
//    public int findRotateSteps(String ring, String key) {
//
//        for (int i=0;i<key.length();i++){
//            if (i==0){
//                dp[i] = findStep(ring,key.charAt(i));
//            }
//            String ring1 = ring.substring(dp[i-1][0])+ring.substring(0,dp[i-1][0]);
//            int[] step1 = findStep(ring, key.charAt(i));
//            String ring2 = ring.substring(dp[i-1][0])+ring.substring(0,dp[i-1][0]);
//            int[] step2 = findStep(ring, key.charAt(i));
//
//        }
//    }

    private int[] findStep(String ring, char c){
        int[] setp = new int[2];
        for (int j=0;j<ring.length();j++){
            if (ring.charAt(j)==c){
                setp[0] = j;
            }
        }
        for (int j=ring.length()-1;j>=0;j--){
            if (ring.charAt(j)==c){
                setp[1] = ring.length()-j;
            }
        }
        return setp;
    }

    class Lid{
        int num;
        Lid[] next;
        public Lid(int num){
            this.num = num;
            next = new Lid[2];
        }
    }
}
