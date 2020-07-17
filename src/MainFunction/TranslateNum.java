package MainFunction;

import DataStructure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User: 兴希
 * Date: 2020/6/9
 * Time: 9:48
 * Description: 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成
 *              “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法
 */
public class TranslateNum {
    int count = 0;
    public int translateNum(int num) {
        if (num<10){
            return 1;
        }
        TreeNode node = new TreeNode(0);
        genarate(String.valueOf(num).toCharArray(),0,node);
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(node);
//        while (!queue.isEmpty()){
//            for (int i=0)
//        }
        return count;
    }

    public void genarate(char[] chars, int i, TreeNode node){
        if (i>=chars.length){
            count++;
            return;
        }
        node.left = new TreeNode(Integer.valueOf(String.valueOf(chars[i])));
        genarate(chars,i+1,node.left);
        if ((chars[i]<'2'&&i+1<chars.length&&chars[i]>'0')||(chars[i]=='2'&&i+1<chars.length&&chars[i+1]<'6')){
            node.right = new TreeNode(Integer.valueOf(String.valueOf(chars[i])+String.valueOf(chars[i+1])));
            genarate(chars,i+2,node.right);
        }
    }

    private String numStr;

    public int translateNum1(int num) {
        numStr = Integer.valueOf(num).toString();
        return count(0,numStr.length());
    }

    private int count(int start,int end){
        if(end - start <= 1){
            return 1;
        }
        int count =0;
        count = count + count(start+1,end);
        if(Integer.valueOf(numStr.substring(start,start+2))<=25 && numStr.charAt(start)!='0'){
            count = count + count(start+2,end);
        }
        return count;
    }

    public static void main(String[] args) {
        TranslateNum translateNum = new TranslateNum();
        int i1 = translateNum.translateNum1(11);
        System.out.println(i1);
    }
}
