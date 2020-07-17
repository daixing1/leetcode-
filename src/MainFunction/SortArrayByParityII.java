package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/9
 * Time: 10:02
 * Description: 给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 *              对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 *              你可以返回任何满足上述条件的数组作为答案。
 */
public class SortArrayByParityII {
    public static int[] sortArrayByParityII(int[] A) {
        int tmp = 0;
        int j=0;
        int k = 0;
        for (int i=0;i<A.length;){
            if (A[i]%2==i%2){
                i++;
                continue;
            }else {
                tmp = A[i];
                j = i+1;
                while (j<A.length){
                    if (A[j]%2==j%2){
                        j++;
                        continue;
                    }
//                    if (A[j]%2!=j%2&&A[i]%2!=j%2)
                    if (A[j]%2!=j%2&&A[j]%2==i%2){
                        A[i] = A[j];
                        A[j] = tmp;
                        break;
                    }
                    if (A[j]%2!=j%2&&A[j]%2!=i%2){
                        if (k<i){
                            k=j;
                        }
                        j++;
                        continue;
                    }
                }
                if (k<i){
                    i = j;
                }else {
                    i = k;
                }

            }
        }
        return A;
    }

    public int[] sortArrayByParityII1(int[] A) {
        if (A==null||A.length<2){
            return A;
        }
        int[] res = new int[A.length];
        int index1 = 1;
        int index0 = 0;
        for (int i=0;i<A.length;i++){
            if (A[i]%2==0){
                res[index0] = A[i];
                index0+=2;
            }else {
                res[index1] = A[i];
                index1+=2;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = sortArrayByParityII(new int[]{2,0,1,4,0,2,4,2,3,1,1,3,0,1,1,2,2,3,3,3});
        System.out.println(ints);
    }
}
