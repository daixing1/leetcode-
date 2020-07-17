package MainFunction;

/**
 * User: 兴希
 * Date: 2020/5/18
 * Time: 8:59
 * Description: 从点 (x, y) 可以转换到 (x, x+y)  或者 (x+y, y)。
 *              给定一个起点 (sx, sy) 和一个终点 (tx, ty)，如果通过一系列的转换可以从起点到达终点，
 *              则返回 True ，否则返回 False
 */
public class ReachingPoints {
    public static boolean reachingPoints(int sx, int sy, int tx, int ty) {
        if (sx==tx&&sy==ty){
            return true;
        }
        if (sx>tx||sy>ty){
            return false;
        }
        if (tx>ty){
            return reachingPoints(sx,sy,tx-ty,ty);
        }else {
            return reachingPoints(sx,sy,tx,ty-tx);
        }
//        return reachingPoints(sx,sy,tx,ty)||reachingPoints(sx,sx,tx,ty);
    }

    public static void main(String[] args) {
        boolean b = reachingPoints(1,
                1,
                3,
                5);
        System.out.println(b);
    }
}
