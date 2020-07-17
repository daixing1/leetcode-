package MainFunction;

import java.util.Arrays;

/**
 * User: 兴希
 * Date: 2020/6/7
 * Time: 11:07
 * Description: 传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。
 *              传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。
 *              我们装载的重量不会超过船的最大运载重量。
 *              返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力
 */
public class ShipWithinDays {
    public static int shipWithinDays(int[] weights, int D) {
        if (D==weights.length){
            Arrays.sort(weights);
            return weights[weights.length-1];
        }
        if (D==1){
            return Arrays.stream(weights).boxed().mapToInt(o->o).sum();
        }
        int energy = 0;
        int days = 0;
        int tmp = 0;
        boolean flag = true;
        for (int i=0;i<weights.length;i++){
            //energy递增
            energy+=weights[i];
            days = 1;
            tmp = 0;
            flag = true;
            //遍历energy是否符合
            for (int j=0;j<weights.length;j++){
                if (energy<weights[j]){
                    flag = false;
                    break;
                }
                tmp+=weights[j];
                if (tmp>energy){
                    days++;
                    tmp = weights[j];
                    if (days>D){
                        break;
                    }
                }
            }
            if (flag&&days<=D){
                break;
            }
        }
        //energy递减找到合适的最小的energy
        for (int i=energy;i>=0;i--){
            days = 1;
            tmp = 0;
            flag = true;
            for (int j=0;j<weights.length;j++){
                if (i<weights[j]){
                    flag = false;
                    break;
                }
                tmp+=weights[j];
                if (tmp>i){
                    days++;
                    tmp = weights[j];
                    if (days>D){
                        break;
                    }
                }
            }
            if (flag&&days<=D){
                energy = i;
            }else {
                break;
            }
        }
        return energy;
    }

    public static void main(String[] args) {
        int i = shipWithinDays(new int[]{1,2,3,1,1}, 4);
        System.out.println(i);
    }
}
