package MainFunction;

import DataStructure.MountainArray;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * User: 兴希
 * Date: 2020/4/29
 * Time: 9:28
 * Description: 给你一个 山脉数组 mountainArr，请你返回能够使得 mountainArr.get(index) 等于 
 *              target 最小 的下标 index 值。
 *              如果不存在这样的下标 index，就请返回 -1。
 *              何为山脉数组？如果数组 A 是一个山脉数组的话，那它满足如下条件：
 *                  首先，A.length >= 3
 *                  其次，在 0 < i < A.length - 1 条件下，存在 i 使得：
 *                  A[0] < A[1] < ... A[i-1] < A[i]
 *                  A[i] > A[i+1] > ... > A[A.length - 1]
 *              你将 不能直接访问该山脉数组，必须通过 MountainArray 接口来获取数据：
 *                  MountainArray.get(k) - 会返回数组中索引为k 的元素（下标从 0 开始）
 *                  MountainArray.length() - 会返回该数组的长度
 */
public class FindInMountainArray {
    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int right = mountainArr.length()-1;
        if (mountainArr.length()==1){
            return mountainArr.get(0)==target?0:-1;
        }
        if (mountainArr.length()==0){
            return -1;
        }
        int h = -1;
        int left = 0;
        while (left!=right){
            int mid = (left+right)/2;
            if (mountainArr.get(mid+1)>mountainArr.get(mid)){
                left = mid+1;
            }else if (mountainArr.get(mid-1)<mountainArr.get(mid)) {
                h = mid;
                break;
            }else {
                right = mid-1;
            }
        }
        if (h==-1){
            h = left;
        }
        if (mountainArr.get(h)<target||(mountainArr.get(0)>target&&mountainArr.get(mountainArr.length()-1)>target)){
            return -1;
        }
        int result = getResult(target, mountainArr, 0, h,'l');
        if (result != -1){
            return result;
        }else {
            return getResult(target, mountainArr, h, mountainArr.length()-1,'r');
        }
    }

    public static int getResult(int target, MountainArray mountainArr,int left,int right,char flag){
        while (left<=right){
            int mid =(left+right)/2;
            if (mountainArr.get(mid)==target){
                return mid;
            }else if (mountainArr.get(mid)<target){
                if (flag=='l'){
                    left = mid+1;
                    return getResult(target, mountainArr,left, right,'l');
                }else if (flag=='r'){
                    right = mid-1;
                    return getResult(target, mountainArr,left, right,'r');
                }

            }else if (mountainArr.get(mid)>target){
                if (flag=='l'){
                    right = mid-1;
                    return getResult(target, mountainArr,left, right,'l');
                }else if (flag=='r'){
                    left = mid+1;
                    return getResult(target, mountainArr,left, right,'r');
                }
            }
        }
        return -1;
    }

//    public static int findInMountainArray(MountainArray mountainArr, int target) {return 0;}

    public static void main(String[] args) {
        int inMountainArray = findInMountainArray(2, new MountainArray(new ArrayList<>(Arrays.asList(1,5,2))));
        System.out.println(inMountainArray);
    }
}
