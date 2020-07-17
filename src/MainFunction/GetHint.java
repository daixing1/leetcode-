package MainFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/5/8
 * Time: 10:44
 * Description: 你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。
 *              每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），
 *              有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。
 *              请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
 *              请注意秘密数字和朋友的猜测数都可能含有重复数字。
 */
public class GetHint {
    public static String getHint(String secret, String guess) {
        int countA = 0;
        int countB = 0;
        Map<Character,Integer> mapA = new HashMap<>();
        Map<Character,Integer> mapB = new HashMap<>();
        for (int i=0;i<guess.length();i++){
            if (secret.contains(String.valueOf(guess.charAt(i)))){
                if (secret.charAt(i)==guess.charAt(i)){
                    countA++;
                }
            }
            mapA.put(guess.charAt(i),mapA.getOrDefault(guess.charAt(i),0)+1);
            mapB.put(secret.charAt(i),mapB.getOrDefault(secret.charAt(i),0)+1);
        }
        for (char c:mapA.keySet()){
            countB+=Math.min(mapA.getOrDefault(c,0),mapB.getOrDefault(c,0));
        }
        countB-=countA;
        return countA+"A"+countB+"B";
    }

    public static void main(String[] args) {
        String hint = getHint("1122"
                ,"2211");
        System.out.println(hint);
    }
}
