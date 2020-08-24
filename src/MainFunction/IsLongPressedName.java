package MainFunction;

/**
 * User: 兴希
 * Date: 2020/8/1
 * Time: 20:25
 * Description: 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 *              你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 */
public class IsLongPressedName {
    public boolean isLongPressedName(String name, String typed) {
        if (typed.length()<name.length()){
            return false;
        }
        if (name.equals(typed)){
            return true;
        }
        int i=0,j=0;
        for (;i<name.length();i++){
            if (i==0&&name.charAt(i)!=typed.charAt(j)){
                return false;
            }
            if (j<typed.length()&&name.charAt(i)==typed.charAt(j)){
                j++;
                continue;
            }else {
                if (j>=typed.length()){
                    return false;
                }
                char c = name.charAt(i-1);
                while (j<typed.length()&&typed.charAt(j)==c){
                    j++;
                }
                if (j>=typed.length()){
                    return false;
                }
                if (typed.charAt(j)!=name.charAt(i)){
                    return false;
                }
                if (typed.charAt(j)==name.charAt(i)){
                    j++;
                }
            }
        }
        while (j<typed.length()&&typed.charAt(j)==name.charAt(name.length()-1)){
            j++;
        }
        if (j>=typed.length()){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        IsLongPressedName isLongPressedName = new IsLongPressedName();
        boolean flag = isLongPressedName.isLongPressedName("laiden", "laiden");
        System.out.println(flag);
    }
}
