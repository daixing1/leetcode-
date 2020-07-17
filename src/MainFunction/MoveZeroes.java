package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/17
 * Time: 9:54
 * Description: 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int i=0;
        Integer j=null;
        int total = 0;
        for (;i<nums.length;i++){
            if (nums[i]==0){
                if (j==null){
                    j=i;
                }
                total++;
                continue;
            }
            if (total==0){
                continue;
            }
            if (total!=0){
                while (nums[j]!=0){
                    j++;
                }
                nums[j] = nums[i];
                nums[i]=0;
            }
        }


    }

    public static void main(String[] args) {
        MoveZeroes moveZeroes = new MoveZeroes();
        moveZeroes.moveZeroes(new int[]{0,1,0,3,12});
        System.out.println();
    }
}
