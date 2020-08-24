package Spare;

/**
 * User: 兴希
 * Date: 2020/8/1
 * Time: 15:28
 * Description: No Description
 */
public class Reletive_7 {
    int count = 0;
    public int reletive_7 (int[] digit) {
        // write code here
        if (digit==null||digit.length==0){
            return count;
        }
        dfs(digit,"",new boolean[digit.length]);
        return count;
    }

    private void dfs(int[] digits, String sum, boolean[] flag){
        if (sum.length()==digits.length){
            if (Integer.valueOf(sum)%7==0){
                count++;
            }
            return;
        }
        for (int i=0;i<digits.length;i++){
            if (!flag[i]){
                flag[i] = true;
                sum+=digits[i];
                dfs(digits,sum,flag);
                sum = sum.substring(0,sum.length()-1);
                flag[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Reletive_7 reletive_7 = new Reletive_7();
        int i = reletive_7.reletive_7(new int[]{1, 1, 2});
        System.out.println(i);
    }
}
