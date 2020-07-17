package MainFunction;

/**
 * User: 兴希
 * Date: 2020/6/3
 * Time: 8:26
 * Description: 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 */
public class Multiply {
    public static String multiply(String num1, String num2) {
        String res = "";
        String tmp1 = "";
        String tmp2 = "";
        for (int i=num1.length()-1;i>=0;i--){
            tmp1 = oneMultiply(Integer.valueOf(num1.substring(i,i+1)),num2)+"0".repeat(num1.length()-1-i);
            tmp2 = add(tmp1,tmp2);
        }
        for (int i=0;i<tmp2.length();i++){
            if (tmp2.charAt(i)!='0'){
                res = tmp2.substring(i);
                break;
            }
        }
        if (res.length()==0){
            return "0";
        }
        return res;
    }

    public static String oneMultiply(Integer n, String s){
        StringBuilder res = new StringBuilder();
        int count = 0;
        int sum = 0;
        if (s==null||s.length()==0){
            return String.valueOf(s);
        }
        for (int i=s.length()-1;i>=0;i--){
            sum = n*Integer.valueOf(s.substring(i,i+1))+count;
            count = sum/10;
            res.insert(0,sum%10);
        }
        if (count!=0){
            res.insert(0,count);
        }
        return res.toString();
    }

    public static String add(String num1, String num2){
        StringBuilder res = new StringBuilder();
        int count = 0;
        int sum = 0;
        if (num1.length()*num2.length()==0){
            return num1.length()==0?num2:num1;
        }
        if (num1.length()>num2.length()){
            return add(num2,num1);
        }
        for (int i=num1.length()-1,j=num2.length()-1;i>=0&&j>=0;i--,j--){
            sum = Integer.valueOf(num1.substring(i,i+1))+Integer.valueOf(num2.substring(j,j+1))+count;
            if (sum>=10){
                count = 1;
            }else {
                count = 0;
            }
            res.insert(0,sum%10);
        }

        for (int i=num2.length()-num1.length()-1;i>=0;i--){
            sum = Integer.valueOf(num2.substring(i,i+1))+count;
            if (sum>=10){
                count = 1;
            }else {
                count = 0;
            }
            res.insert(0,sum%10);
        }
        if (count==1){
            res.insert(0,count);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String add = multiply("123", "456");
        System.out.println("0".repeat(0));
        System.out.println(add);
    }
}
