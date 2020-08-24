package MainFunction;

import java.util.HashSet;
import java.util.Set;

/**
 * User: 兴希
 * Date: 2020/8/16
 * Time: 20:27
 * Description: 有一幅以二维整数数组表示的图画，每一个整数表示该图画的像素值大小，数值在 0 到 65535 之间。
 *              给你一个坐标 (sr, sc) 表示图像渲染开始的像素值（行 ，列）和一个新的颜色值 newColor，
 *              让你重新上色这幅图像。
 *              为了完成上色工作，从初始坐标开始，记录初始坐标的上下左右四个方向上像素值与初始坐标相同的相连像
 *              素点，接着再记录这四个方向上符合条件的像素点与他们对应四个方向上像素值与初始坐标相同的相连像素点
 *              ，……，重复该过程。将所有有记录的像素点的颜色值改为新的颜色值。
 *              最后返回经过上色渲染后的图像。
 */
public class FloodFill {
    int[][] direction = new int[][]{{-1,0},{0,-1},{1,0},{0,1}};
    int flag = 0;
    int m,n;
    Set<String> set = new HashSet<>();
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (image==null||image.length==0||image[0].length==0){
            return image;
        }
        m = image.length;
        n = image[0].length;
        flag = image[sr][sc];
        image[sr][sc] = newColor;
        set.add(sr+"#"+sc);
        dfs(image, sr, sc, newColor);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int newColor){
        if (image[sr][sc]==flag){
            image[sr][sc] = newColor;
        }
        for (int i = 0; i < direction.length; i++) {
            int r = sr+direction[i][0];
            int c = sc+direction[i][1];
            if (r<m&&r>=0&&c<n&&c>=0&&!set.contains(r+"#"+c)){
                set.add(r+"#"+c);
                if (image[r][c]==flag){
                    image[r][c] = newColor;
                    dfs(image, r, c, newColor);
                }
            }
        }
    }

    public static void main(String[] args) {
        FloodFill floodFill = new FloodFill();
//        int[][] ints = floodFill.floodFill(new int[][]{}, , , );
//        System.out.println(ints);
    }
}
