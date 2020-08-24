package MainFunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * User: 兴希
 * Date: 2020/8/9
 * Time: 21:37
 * Description: 分子为1的分数称为埃及分数。现输入一个真分数(分子比分母小的分数，叫做真分数)，
 *              请将该分数分解为埃及分数。如：8/11 = 1/2+1/5+1/55+1/110。
 *              接口说明
 *                  功能: 将分数分解为埃及分数序列
 *              输入参数：
 *                  String pcRealFraction:真分数(格式“8/11”)
 *              返回值：
 *                  String pcEgpytFraction:分解后的埃及分数序列(格式“1/2+1/5+1/55+1/100”)
 *              如有多个解，输出任意一个
 */
public class ConvertRealFractToEgpytFract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fract = scanner.next();
        String[] split = fract.split("/");
        int numerator = Integer.valueOf(split[0]);
        int denominator = Integer.valueOf(split[1]);
        String s = convertRealFractToEgpytFract(numerator, denominator);
        System.out.println(s);
    }

    private static String convertRealFractToEgpytFract(int m, int n){
        if (m==1){
            return m+"/"+n;
        }
        if (n%m==0){
            return 1+"/"+n/m;
        }
        int tmp = n/m;
        tmp++;
        int tmpn = tmp*n;
        int tmpm = m*tmp-n;
        return 1+"/"+tmp+"+"+convertRealFractToEgpytFract(tmpm,tmpn);
    }

    public static void main1(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str;
        while ((str = reader.readLine()) != null) {
            String[] split = str.split("/");
            StringBuilder sb = new StringBuilder();
            int s = Integer.parseInt(split[0]);
            for(int  i =0;i<s;i++){
                sb.append("1/").append(split[1]).append("+");
            }

            System.out.println(sb.toString().substring(0,sb.length()-1));
        }


    }
}
