package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/9
 * Time: 10:33
 * Description: 两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
 *              给出两个整数 x 和 y，计算它们之间的汉明距离。
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        if (x>y){
            return hammingDistance(y,x);
        }
        int count = 0;
        int tmpx = 0;
        int tmpy = 0;
        while (x>0){
            tmpx = x&1;
            tmpy = y&1;
            if (tmpx!=tmpy){
                count++;
            }
            x = x>>1;
            y = y>>1;
        }
        while (y>0){
            tmpy = y&1;
            if (tmpy==1){
                count++;
            }
            y = y>>1;
        }
        return count;
    }

    public static void main(String[] args) {
        HammingDistance hammingDistance = new HammingDistance();
        int i = hammingDistance.hammingDistance(1, 4);
        System.out.println(i);
    }
}
