package MainFunction;

/**
 * User: 兴希
 * Date: 2020/2/27
 * Time: 0:22
 * Description: 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *              请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *              你可以假设 nums1 和 nums2 不会同时为空。
 */
public class FindMedianSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length+nums2.length;
        if (nums1.length==0){
            if ((len&1)==0){
                return (nums2[len/2]+nums2[len/2-1])/2.0;
            }else {
                return nums2[len/2];
            }
        }
        if (nums2.length==0){
            if ((len&1)==0){
                return (nums1[len/2]+nums1[len/2-1])/2.0;
            }else {
                return nums1[len/2];
            }
        }
        double mid = 0;
        if ((len&1)==0){
            mid = (getMedian(nums1,nums2,len/2)+getMedian(nums1,nums2,len/2+1))/2;
        }else {
            mid = getMedian(nums1,nums2,(len+1)/2);
        }

        return mid;
    }

    private double getMedian(int[] nums1, int[] nums2, int k){
        int k1=0,k2=0, i=0, j=0;
        int index1 = i,index2 = j;
        while (k>0){
            if (k==1){
                return Math.min(nums1[i],nums2[j]);
            }
            if (k==2&&nums1[i]==nums2[j]){
                return nums1[i];
            }
            k1 = k>>1;
            if ((k&1)==0){
                k2 = k1;
            }else {
                k2 = k-k1;
            }
            while (i<index1+k1&&j<index2+k2&&i<nums1.length&&j<nums2.length){
                if (k==1){
                    return Math.min(nums1[i],nums2[j]);
                }
                if (k==2&&nums1[i]==nums2[j]){
                    return nums1[i];
                }
                if (nums1[i]>nums2[j]){
                    j++;
                    k--;
                    continue;
                }
                if (nums1[i]<nums2[j]){
                    i++;
                    k--;
                    continue;
                }
                if (nums1[i]==nums2[j]){
                    i++;
                    j++;
                    k-=2;
                    continue;
                }
            }
            if (i>=nums1.length){
                return nums2[j+k-1];
            }
            if (j>=nums2.length){
                return nums1[i+k-1];
            }
            index1 = i;
            index2 = j;
        }
        return 0.0;
    }

    public static void main(String[] args) {
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        double mid = findMedianSortedArrays.findMedianSortedArrays(new int[]{1,1,1}, new int[]{1,1,1});
        System.out.println(mid);
    }
}
