package MainFunction;

import java.util.Scanner;

/**
 * User: 兴希
 * Date: 2020/8/22
 * Time: 22:47
 * Description: Redraiment是走梅花桩的高手。Redraiment总是起点不限，从前到后，往高的桩子走，但走的步数最多，
 *              不知道为什么？你能替Redraiment研究他最多走的步数吗？
 *              样例输入
 *                  6
 *                  2 5 1 5 4 5
 *              样例输出
 *                  3
 *              提示
 *              Example:
 *                  6个点的高度各为 2 5 1 5 4 5
 *                  如从第1格开始走,最多为3步, 2 4 5
 *                  从第2格开始走,最多只有1步,5
 *                  而从第3格开始走最多有3步,1 4 5
 *                  从第5格开始走最多有2步,4 5
 *                  所以这个结果是3。
 *
 *              接口说明
 *              方法原型：
 *                  int GetResult(int num, int[] pInput, List  pResult);
 *              输入参数：
 *                  int num：整数，表示数组元素的个数（保证有效）。
 *                  int[] pInput: 数组，存放输入的数字。
 *              输出参数：
 *                  List pResult: 保证传入一个空的List，要求把结果放入第一个位置。
 *              返回值：
 *                  正确返回1，错误返回0
 */
public class LongestUpSeq {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int max = 1;
            for (int i = 0; i < n; i++) {
                int tmp = 1;
                for (int j = i; j < 0; j++) {

                }
            }
        }
    }
}
