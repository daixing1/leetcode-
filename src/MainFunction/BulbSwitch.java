package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/20
 * Time: 21:22
 * Description: 初始时有 n 个灯泡关闭。 第 1 轮，你打开所有的灯泡。 第 2 轮，每两个灯泡你关闭一次。
 *              第 3 轮，每三个灯泡切换一次开关（如果关闭则开启，如果开启则关闭）。第 i 轮，每 i 个灯
 *              泡切换一次开关。 对于第 n 轮，你只切换最后一个灯泡的开关。 找出 n 轮后有多少个亮着的灯泡
 */
public class BulbSwitch {
    public static int bulbSwitch(int n) {
        int res = 0;
        int[] status = new int[n+1];
        for (int i=1;i<=n;i++){
            for (int j=i;j<=n;j+=i){
                if (status[j]==0){
                    status[j] = 1;
                }else {
                    status[j] = 0;
                }
            }
        }
        for (int s:status){
            if (s==1){
                res++;
            }
        }
        return res;
    }

    public static int bulbSwitch1(int n) {


        return (int)Math.sqrt(n);
    }

    public static void main(String[] args) {
        int i = bulbSwitch1(3);
        System.out.println(i);
    }
}
