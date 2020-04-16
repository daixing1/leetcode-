package MainFunction;

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
}
