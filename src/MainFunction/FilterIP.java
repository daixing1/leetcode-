package MainFunction;

import java.util.Scanner;

/**
 * User: 兴希
 * Date: 2020/7/23
 * Time: 8:53
 * Description: 在搜索引擎后端服务中，需要对恶意的抓取进行限制，其中的一个环节即对访问IP进行限制。
 *              请设计一个IP过滤器，实现对访问的IP限制的功能。对IP的限制数据有三种格式：
 *                  1.全IP：如222.205.58.16
 *                  2.前面带 *：如 *.58.16
 *                  3.后面带 *：如 222.205.58.*
 *              带 * 的表示匹配到任意的IP段均可，且 * 可以代表多个ip段，且 * 只能出现在开头或者结尾。
 *              现给出若干条需要过滤的规则，以及若干输入的IP，你需要输出这若干条IP是否会被过滤
 */
public class FilterIP {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m,n;
        n = in.nextInt();
        m = in.nextInt();
        String[] rules = new String[n];
        int[] isValid = new int[m];
        String ip = "";
        int index = 0;
        while (index<n){
            rules[index] = in.next();
            index++;
        }
        index = 0;
        boolean flag = true;
        while (index<m){
            ip = in.next();
            for (int i=0;i<n;i++){
                flag = true;
                String[] split = rules[i].split("\\.");
                String[] split1 = ip.split("\\.");
                if ("*".equals(split[0])){
                    int k = 3;
                    for (int j=split.length-1;j>0;j--){
                        if (!split[j].equals(split1[k--])){
                            flag = false;
                            isValid[index] = 0;
                            break;
                        }
                    }
                    if (flag){
                        isValid[index] = 1;
                        break;
                    }
                }else if ("*".equals(split[split.length-1])){
                    for (int j=0;j<split.length-1;j++){
                        if (!split[j].equals(split1[j])){
                            flag = false;
                            isValid[index] = 0;
                            break;
                        }
                    }
                    if (flag){
                        isValid[index] = 1;
                        break;
                    }
                }else {
                    if (ip.equals(rules[i])){
                        isValid[index] = 1;
                        break;
                    }else {
                        isValid[index] = 0;
                    }
                }
            }
            index++;
        }
        for (int a:isValid){
            System.out.print(a+" ");
        }
    }
}
