package Spare;

/**
 * User: 兴希
 * Date: 2020/7/28
 * Time: 17:38
 * Description: 农夫john有一群羊，为了便于管理，它给这些羊都编上了号（1~n），然后他按照编号依次将这些羊用绳子连在了一起
 */
public class Sheep {
    public int getAns(int[] A, int n) {
        // write code here
        int count = 0;
        int tmp = 0;
        boolean flag = true;
//        while (flag){
//            flag = false;
            for (int i=0;i<n;i++){
                if (A[i]!=i+1){
                    flag = true;
                    tmp = i+1;
                    int j = i;
                    while (j<n){
                        if (tmp==A[j]){
                            swap(A,i,j);
                            count++;
                            break;
                        }
                        j++;
                    }
                }
            }
//        }
        return count;
    }

    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Sheep sheep = new Sheep();
        int ans = sheep.getAns(new int[]{1, 3, 4, 5,2}, 5);
        System.out.println(ans);
    }
}
