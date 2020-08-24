package MainFunction;

import java.util.HashSet;
import java.util.Set;

/**
 * User: 兴希
 * Date: 2020/8/3
 * Time: 20:52
 * Description: 力扣团队买了一个可编程机器人，机器人初始位置在原点(0, 0)。小伙伴事先给机器人输入一串指令command，
 *              机器人就会无限循环这条指令的步骤进行移动。指令有两种：
 *                  U: 向y轴正方向移动一格
 *                  R: 向x轴正方向移动一格。
 *              不幸的是，在 xy 平面上还有一些障碍物，他们的坐标用obstacles表示。机器人一旦碰到障碍物就会被损毁。
 *              给定终点坐标(x, y)，返回机器人能否完好地到达终点。如果能，返回true；否则返回false。
 */
public class Robot {
    public boolean robot(String command, int[][] obstacles, int x, int y) {
        Set<String> set = new HashSet<>();
        for (int[] arr:obstacles){
            set.add(arr[0]+"#"+arr[1]);
        }
        int right = 0;
        int up = 0;
        while (true){
            for (int i=0;i<command.length();i++){
                char c = command.charAt(i);
                if (c=='U'){
                    up+=1;
                }else {
                    right+=1;
                }
                if (set.contains(right+"#"+up)){
                    return false;
                }
                if (up>y||right>x){
                    return false;
                }
                if (up==y&&right==x){
                    return true;
                }
            }
        }
    }
}
