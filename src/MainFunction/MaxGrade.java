package MainFunction;

import java.util.Scanner;

/**
 * User: 兴希
 * Date: 2020/8/11
 * Time: 22:27
 * Description: 老师想知道从某某同学当中，分数最高的是多少，现在请你编程模拟老师的询问。当然，老师有时候需要更新某位同学的成绩.
 *              输入描述:
 *                  输入包括多组测试数据。
 *                  每组输入第一行是两个正整数N和M（0 < N <= 30000,0 < M < 5000）,分别代表学生的数目和操作的数目。
 *                  学生ID编号从1编到N。
 *                  第二行包含N个整数，代表这N个学生的初始成绩，其中第i个数代表ID为i的学生的成绩
 *                  接下来又M行，每一行有一个字符C（只取‘Q’或‘U’），和两个正整数A,B,当C为'Q'的时候,
 *                  表示这是一条询问操作，他询问ID从A到B（包括A,B）的学生当中，成绩最高的是多少
 *                  当C为‘U’的时候，表示这是一条更新操作，要求把ID为A的学生的成绩更改为B。
 *
 *              输出描述:
 *                  对于每一次询问操作，在一行里面输出最高成绩.
 */
public class MaxGrade {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] grades = new int[n+1];
            for (int i = 1; i <= n; i++) {
                grades[i] = scanner.nextInt();
            }
            for (int i = 0; i < m; i++) {
                String s = scanner.next();
                int a = scanner.nextInt();
                int b = scanner.nextInt();
                if ("Q".equals(s)){
                    getMaxGrade(grades,a,b);
                }else {
                    grades[a] = b;
                }
            }
        }
    }

    private static void getMaxGrade(int[] grades, int start,int end){
        int max = Integer.MIN_VALUE;
        int begin = Math.min(start,end);
        end = Math.max(start,end);
        for (int i = begin; i <=end ; i++) {
            max = Math.max(max,grades[i]);
        }
        System.out.println(max);
    }
}
