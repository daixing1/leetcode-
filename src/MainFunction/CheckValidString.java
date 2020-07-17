package MainFunction;

import java.util.Stack;

/**
 * User: 兴希
 * Date: 2020/6/13
 * Time: 14:05
 * Description: 给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。
 *              有效字符串具有如下规则：
 *                  任何左括号 ( 必须有相应的右括号 )。
 *                  任何右括号 ) 必须有相应的左括号 ( 。
 *                  左括号 ( 必须在对应的右括号之前 )。
 *                  * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
 *                  一个空字符串也被视为有效字符串。
 */
public class CheckValidString {
    public static boolean checkValidString(String s) {
        return false;
    }

    public static void main(String[] args) {
        boolean b = checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*");
        System.out.println(b);
    }
}
