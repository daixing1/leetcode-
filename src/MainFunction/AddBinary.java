package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/3
 * Time: 11:07
 * Description: 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *              输入为 非空 字符串且只包含数字 1 和 0。
 */
public class AddBinary {
    public static String addBinary(String a, String b) {
        String res = "";
        int count = 0;
        if (a.length()==0||b.length()==0){
            return a.length()==0?b:a;
        }
        char[] chara = a.toCharArray();
        char[] charb = b.toCharArray();
        for (int i=chara.length-1,j=charb.length-1;i>=0&&j>=0;i--,j--){
            if (chara[i]-'0'+charb[j]-'0'+count>=2){
                count=1;
                res = String.valueOf((chara[i]-'0'+charb[j]-'0'+count)%2)+res;
            }else {
                res = String.valueOf(chara[i]-'0'+charb[j]-'0'+count)+res;
                count=0;
            }
        }
        if (chara.length>charb.length){
            for (int i =chara.length-1-b.length();i>=0;i--){
                if (chara[i]-'0'+count==2){
                    count=1;
                    res = "0"+res;
                }else {
                    res = String.valueOf(chara[i]-'0'+count)+res;
                    count=0;
                }
            }
        }else {
            for (int i =charb.length-1-a.length();i>=0;i--){
                if (charb[i]-'0'+count==2){
                    count=1;
                    res = "0"+res;
                }else {
                    res = String.valueOf(charb[i]-'0'+count)+res;
                    count=0;
                }
            }
        }
        if (count==1){
            res = "1"+res;
        }
        return res;
    }

    public static void main(String[] args) {
        String s = addBinary("11", "1");
        System.out.println(s);
    }
}
