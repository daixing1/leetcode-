package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/3
 * Time: 12:30
 * Description: 给定M×N矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
 */
public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int col = matrix[0].length-1;
        int row = matrix.length-1;
        for (int i=0;i<Math.min(col,row);i++){
            int left = 0;
            int right = col;
            while (left<right){
                int mid = (left+right)/2;
                if (matrix[0][mid]<target){
                    left = mid+1;
                }else if (matrix[0][mid]>target){
                    right = mid+1;
                }else {
                    return true;
                }
            }
            col = right;
            left = 0;
            right = row;
            while (left<right){
                int mid = (left+right)/2;
                if (matrix[mid][0]<target){
                    left = mid+1;
                }else if (matrix[mid][0]>target){
                    right = mid+1;
                }else {
                    return true;
                }
            }
            row = right;
        }
        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        if (matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i=0;i<n;i++){
            if (matrix[m-1][i]>target){
                int j=m-1;
                while (j>=0&&matrix[j][i]>target){
                    j--;
                }
                if (j>=0&&matrix[j][i]==target){
                    return true;
                }
                continue;
            }
            if (matrix[m-1][i]==target){
                return true;
            }
        }
        return false;
    }
    //对角线遍历
//    public boolean searchMatrix2(int[][] matrix, int target) {
//        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
//            return false;
//        }
//        int m = matrix.length;
//        int n = matrix[0].length;
//        int i=m;
//        int j=n;
//        while (i>=0&&j>=0&&matrix[i][j]>target){
//            i--;
//            j--;
//        }
//        if (i>=0&&j>=0&&matrix[i][j]==target){
//            return true;
//        }
//        if (i+1==0){
//            i++;
//            while (j>=0&&matrix[i][j]>target){
//                j--;
//            }
//            if (j>=0&&matrix[i][j]==target){
//                return true;
//            }
//        }else if (j+1==0){
//            j++;
//            while (i>=0&&matrix[i][j]>target){
//                i--;
//            }
//            if (i>=0&&matrix[i][j]==target){
//                return true;
//            }
//        }else {
//
//        }
//        return false;
//    }

    public static void main(String[] args) {
        SearchMatrix searchMatrix = new SearchMatrix();
        boolean b = searchMatrix.searchMatrix1(new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 5);
        System.out.println(b);
    }
}
