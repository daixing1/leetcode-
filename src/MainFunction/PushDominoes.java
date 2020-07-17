package MainFunction;

import java.util.Stack;

/**
 * User: 兴希
 * Date: 2020/6/24
 * Time: 10:45
 * Description: 一行中有 N 张多米诺骨牌，我们将每张多米诺骨牌垂直竖立。
 *              在开始时，我们同时把一些多米诺骨牌向左或向右推。
 *              每过一秒，倒向左边的多米诺骨牌会推动其左侧相邻的多米诺骨牌。
 *              同样地，倒向右边的多米诺骨牌也会推动竖立在其右侧的相邻多米诺骨牌。
 *              如果同时有多米诺骨牌落在一张垂直竖立的多米诺骨牌的两边，由于受力平衡， 该骨牌仍然保持不变。
 *              就这个问题而言，我们会认为正在下降的多米诺骨牌不会对其它正在下降或已经下降的多米诺骨牌施加额外的力。
 *              给定表示初始状态的字符串 "S" 。如果第 i 张多米诺骨牌被推向左边，则 S[i] = 'L'；
 *              如果第 i 张多米诺骨牌被推向右边，则 S[i] = 'R'；如果第 i 张多米诺骨牌没有被推动，则 S[i] = '.'。
 *              返回表示最终状态的字符串。
 */
public class PushDominoes {
    public String pushDominoes(String dominoes) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int index = 0;
        while (index<dominoes.length()){
            if (dominoes.charAt(index)=='L'){
                boolean flag = true;
                if (stack.isEmpty()){
                    sb.append("L");
                }else {
                    StringBuilder tmp = new StringBuilder();
                    while (!stack.isEmpty()){
                        Character pop = stack.pop();
                        if (pop=='R'&&flag){
                            if (tmp.length()%2==0){
                                tmp = new StringBuilder("R".repeat(tmp.length()/2)+"L".repeat(tmp.length()/2));
                            }else {
                                tmp = new StringBuilder("R".repeat(tmp.length()/2)+"."+"L".repeat(tmp.length()/2));
                            }
                            tmp.append("L");
                            tmp.insert(0,"R");
                            flag = false;
                        }else {
                            tmp.insert(0,pop);
                        }
                    }
                    sb.insert(0,tmp);
                }
            }else {
                stack.push(dominoes.charAt(index));
            }
            index++;
        }
        if (stack.isEmpty()){
            return sb.toString();
        }else {
            StringBuilder tmp = new StringBuilder();
            while (!stack.isEmpty()){
                Character pop = stack.pop();
                if (pop=='R'){

                }else {

                }
            }
        }
        return "";
    }
}
