package MainFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/2/22
 * Time: 12:59
 * Description: No Description
 */
public class NumberOfBoomerangs {
    public int numberOfBoomerangs(int[][] points) {
        Integer count = 0;
        for (int i=0;i<points.length;i++){
            for (int j=0;j<points.length;j++){
                for (int k=0;k<points.length;k++){
                    if (i==j||i==k||j==k){
                        continue;
                    }
                    boolean flag = isBoomerangs(points[i], points[j], points[k]);
                    if (flag){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean isBoomerangs(int[] a,int[] b,int [] c){
        double m = Math.pow((a[0]-b[0]),2)+Math.pow((a[1]-b[1]),2);
        double n = Math.pow((a[0]-c[0]),2)+Math.pow((a[1]-c[1]),2);
        if (m==n){
            return true;
        }else {
            return false;
        }
    }

    public static int numberOfBoomerangs1(int[][] points) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<points.length;i++){
            for (int j=i+1;j<points.length;j++){
                int a = (int) (Math.pow((points[i][0] - points[j][0]), 2) + Math.pow((points[i][1] - points[j][1]), 2));
                map.put(a,map.getOrDefault(a,0)+1);
            }
        }
        int count = 0;
        for (int n:map.values()){
            if (n>1){
                count+=getMul(n);
            }
        }
        return count;
    }

    public static int getMul(int n){
        if (n==1){
            return 1;
        }
        return n*getMul(n-1);
    }

    public static void main(String[] args) {
        int i = numberOfBoomerangs1(new int[][]{{0,0},{1,0},{-1,0},{0,1},{0,-1}});
        System.out.println(i);
    }
}
