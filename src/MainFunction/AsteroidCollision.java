package MainFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * User: 兴希
 * Date: 2020/6/28
 * Time: 9:54
 * Description: 给定一个整数数组 asteroids，表示在同一行的行星。
 *              对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，
 *              负表示向左移动）。每一颗行星以相同的速度移动。
 *              找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，
 *              则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞。
 */
public class AsteroidCollision {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<asteroids.length;i++){
            if (stack.isEmpty()){
                stack.push(asteroids[i]);
            }else {
                Integer peek = stack.peek();
                if (peek>0&&asteroids[i]<0){
                    if (peek==-asteroids[i]){
                        stack.pop();
                        continue;
                    }else if (peek>-asteroids[i]){
                        continue;
                    }else {
                        stack.pop();
                        i--;
                        continue;
                    }
                }else if (peek<0&&asteroids[i]>0){
                    stack.push(asteroids[i]);
                }else {
                    stack.push(asteroids[i]);
                }

            }
        }
        int[] res = new int[stack.size()];
        for (int i=stack.size()-1;i>=0;i--){
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = asteroidCollision(new int[]{8,-8});
        System.out.println();
    }
}
