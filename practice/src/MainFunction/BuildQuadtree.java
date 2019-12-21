package MainFunction;

import DataStructure.QuadtreeNode;

/**
 * User: 兴希
 * Date: 2019/12/13
 * Time: 16:06
 * Description: 我们想要使用一棵四叉树来储存一个 N x N 的布尔值网络。网络中每一格的值只会是真或假。
 *              树的根结点代表整个网络。对于每个结点, 它将被分等成四个孩子结点直到这个区域内的值都是相同的.
 *              每个结点还有另外两个布尔变量: isLeaf 和 val。isLeaf 当这个节点是一个叶子结点时为真。
 *              val 变量储存叶子结点所代表的区域的值。
 *
 */
public class BuildQuadtree {
    public static QuadtreeNode construct(int[][] grid) {
        QuadtreeNode quadtreeNode = new QuadtreeNode();
        QuadtreeNode quadtreeNode0 = new QuadtreeNode();
        QuadtreeNode quadtreeNode1 = new QuadtreeNode();
        QuadtreeNode quadtreeNode2 = new QuadtreeNode();
        QuadtreeNode quadtreeNode3 = new QuadtreeNode();
        int num0 = grid[0][0];
        Boolean isLeft0 = true;
        Boolean val0 = null;
        for (int i =0;i<grid.length;i++){
            for (int j=0;j<grid[0].length;j++){
                if (grid[i][j]!=num0){
                    isLeft0 = false;
                }
            }
        }
        if (isLeft0){
            if (num0==0){
                val0 = false;
            }else {
                val0 = true;
            }
            quadtreeNode.isLeaf = isLeft0;
            quadtreeNode.val = val0;
            return quadtreeNode;
        }else {
            quadtreeNode.isLeaf = isLeft0;
            quadtreeNode.val = false;
            int[][] grid0 = new int[grid.length/2][grid[0].length/2];
            int[][] grid1 = new int[grid.length/2][grid[0].length/2];
            int[][] grid2 = new int[grid.length/2][grid[0].length/2];
            int[][] grid3 = new int[grid.length/2][grid[0].length/2];
            for (int i =0;i<grid.length/2;i++){
                for (int j=0;j<grid[0].length/2;j++){
                    grid0[i][j] = grid[i][j];
                }
            }
            for (int i =0;i<grid.length/2;i++){
                for (int j=grid[0].length/2;j<grid[0].length;j++){
                    grid1[i][j-grid[0].length/2] = grid[i][j];
                }
            }
            for (int i =grid.length/2;i<grid.length;i++){
                for (int j=0;j<grid[0].length/2;j++){
                    grid2[i-grid.length/2][j] = grid[i][j];
                }
            }
            for (int i =grid.length/2;i<grid.length;i++){
                for (int j=grid[0].length/2;j<grid[0].length;j++){
                    grid3[i-grid.length/2][j-grid[0].length/2] = grid[i][j];
                }
            }
            quadtreeNode0 = construct(grid0);
            quadtreeNode1 = construct(grid1);
            quadtreeNode2 = construct(grid2);
            quadtreeNode3 = construct(grid3);
            quadtreeNode.topLeft = quadtreeNode0;
            quadtreeNode.topRight = quadtreeNode1;
            quadtreeNode.bottomLeft = quadtreeNode2;
            quadtreeNode.bottomRight = quadtreeNode3;
            return quadtreeNode;
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[8][8];
        a[0] = new int[]{1,1,1,1,0,0,0,0};
        a[1] = new int[]{1,1,1,1,0,0,0,0};
        a[2] = new int[]{1,1,1,1,1,1,1,1};
        a[3] = new int[]{1,1,1,1,1,1,1,1};
        a[4] = new int[]{1,1,1,1,0,0,0,0};
        a[5] = new int[]{1,1,1,1,0,0,0,0};
        a[6] = new int[]{1,1,1,1,0,0,0,0};
        a[7] = new int[]{1,1,1,1,0,0,0,0};
        QuadtreeNode construct = construct(a);
        System.out.println(construct);
    }
}
