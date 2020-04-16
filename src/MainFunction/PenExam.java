package MainFunction;

/**
 * User: 兴希
 * Date: 2020/3/23
 * Time: 18:56
 * Description: No Description
 */
public class PenExam {
    public int playGame(int n,int m,char[][] chars){
        int x = 0;
        int y = 0;
        for (int i=0;i<chars.length;i++){
            for (int j=0;j<chars[i].length;j++){
                if (chars[i][j]=='S'){
                    x = i;
                    y = j;
                }
            }
        }
        int time=0;

            oneWalk(x,y,chars);


        return time;
    }

    public int oneWalk(int n,int m,char[][]chars){
        chars[n][m] = 'S';
        int time = 0;
        if (chars[n][m]!='E'){
            if (n+1<chars.length){
                oneWalk(n+1,m,chars);
                time++;
            }
            if (m+1<chars[n].length){
                oneWalk(n+1,m,chars);
                time++;
            }
            if (n-1>=0){
                oneWalk(n+1,m,chars);
                time++;
            }
            if (m-1>=0){
                oneWalk(n+1,m,chars);
                time++;
            }
        }
        return time;
    }

}
