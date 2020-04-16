package MainFunction;

/**
 * User: 兴希
 * Date: 2020/4/10
 * Time: 9:51
 * Description: 给定一个字符串，逐个翻转字符串中的每个单词。
 *              输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 *              如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 */
public class ReverseWords {
    public String reverseWords(String s) {
        String res = "";
        if ("".equals(s)||s.length()<1){
            return s;
        }
        String[] split = s.split(" ");
        for (int i=split.length-1;i>=0;i--){
            if (!"".equals(split[i].trim())){
                res+=split[i]+" ";
            }
        }
        return res.trim();
    }
}
