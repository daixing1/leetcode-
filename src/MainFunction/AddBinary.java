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

    public String addBinary1(String a, String b) {
        if (a.length()*b.length()==0){
            return a.length()==0?b:a;
        }
        if (a.length()>b.length()){
            return addBinary1(b,a);
        }
        int count = 0;
        int i=a.length()-1,j=b.length()-1;
        StringBuilder s = new StringBuilder();
        while (i>=0&&j>=0){
            int m = a.charAt(i)-'0';
            int n = b.charAt(j)-'0';
            if (m+n+count>1){
                s.insert(0,String.valueOf(m+n+count-2));
                count = 1;
            }else {
                s.insert(0,String.valueOf(m+n+count));
                count=0;
            }
            i--;
            j--;
        }
        while (j>=0){
            int n = b.charAt(j)-'0';
            if (n+count>1){
                s.insert(0,String.valueOf(n+count-2));
                count = 1;
            }else {
                s.insert(0,String.valueOf(n+count));
                count=0;
            }
            j--;
        }
        if (count==1){
            s.insert(0,1);
        }
        return s.toString();
    }

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String s1 = addBinary.addBinary1("11", "1");
        String s = addBinary("11", "1");
        System.out.println(s1);
    }
}
