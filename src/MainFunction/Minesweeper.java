package MainFunction;

public class Minesweeper {

//    给定一个代表游戏板的二维字符矩阵。 'M' 代表一个未挖出的地雷，'E' 代表一个未挖出的空方块，'B' 代表没有相邻（上，下，左，右，和所有4个对角线）地雷的已挖出的空白方块，数字（'1' 到 '8'）表示有多少地雷与这块已挖出的方块相邻，'X' 则表示一个已挖出的地雷。
//
//    现在给出在所有未挖出的方块中（'M'或者'E'）的下一个点击位置（行和列索引），根据以下规则，返回相应位置被点击后对应的面板：
//
//    如果一个地雷（'M'）被挖出，游戏就结束了- 把它改为 'X'。
//    如果一个没有相邻地雷的空方块（'E'）被挖出，修改它为（'B'），并且所有和其相邻的方块都应该被递归地揭露。
//    如果一个至少与一个地雷相邻的空方块（'E'）被挖出，修改它为数字（'1'到'8'），表示相邻地雷的数量。
//    如果在此次点击中，若无更多方块可被揭露，则返回面板。

    public static void main(String[] args) {
        char[][] a = new char[8][8];
        a[0] = new char[]{'E','E','E','E','E','E','E','E'};
        a[1] = new char[]{'E','E','E','E','E','E','E','M'};
        a[2] = new char[]{'E','E','M','E','E','E','E','E'};
        a[3] = new char[]{'M','E','E','E','E','E','E','E'};
        a[4] = new char[]{'E','E','E','E','E','E','E','E'};
        a[5] = new char[]{'E','E','E','E','E','E','E','E'};
        a[6] = new char[]{'E','E','E','E','E','E','E','E'};
        a[7] = new char[]{'E','E','M','M','E','E','E','E'};
//        for (int i =0; i< a.length; i++){
//            for (int j = 0;j<a[i].length;j++){
//                a[i][j] = i+j+2;
//            }
//        }
        int[] b = new int[]{8247,824};
        updateBoard(a,new int[]{0,0});
    }
    public static char[][] updateBoard(char[][] board, int[] click) {
        int line = click[0];
        int clo = click[1];
        if (board[line][clo] == 'M'){
            board[line][clo] = 'X';
            return board;
        }
        if (board[line][clo] == 'E'){
//            int num = E(line,clo,board);
            board = E(line, clo, board);
            return board;
        }
        return null;
    }

    public static char[][] E(int line,int clo, char[][] board){
        int num = 0;
        if (line-1>=0 && clo-1>=0 && board[line-1][clo-1]=='M'){
            num++;
        }
        if (line-1>=0 && board[line-1][clo]=='M'){
            num++;
        }
        if (line-1>=0 && clo+1<=board[0].length-1 && board[line-1][clo+1]=='M'){
            num++;
        }
        if (clo-1>=0 && board[line][clo-1]=='M'){
            num++;
        }
        if (clo+1<=board[0].length-1 && board[line][clo+1]=='M'){
            num++;
        }
        if (line+1<=board.length-1 && clo-1>=0 && board[line+1][clo-1]=='M'){
            num++;
        }
        if (line+1<=board.length-1 && board[line+1][clo]=='M'){
            num++;
        }
        if (line+1<=board.length-1 && clo+1<=board[0].length-1 && board[line+1][clo+1]=='M'){
            num++;
        }
        if (num >0){
            board[line][clo] = (char)('0'+num);
        }else {
            board[line][clo] = 'B';
            if (line-1>=0 && clo-1>=0 && (board[line-1][clo-1] == 'E')){
                E(line-1,clo-1,board);
            }
            if (line-1>=0 && (board[line-1][clo] == 'E')){
                E(line-1,clo,board);
            }
            if (line-1>=0 && clo+1<=board[0].length-1 && (board[line-1][clo+1] == 'E')){
                E(line-1,clo+1,board);
            }
            if (clo-1>=0 && (board[line][clo-1] == 'E')){
                E(line,clo-1,board);
            }
            if (clo+1<=board[0].length-1 && (board[line][clo+1] == 'E')){
                E(line,clo+1,board);
            }
            if (line+1<=board.length-1 && clo-1>=0 && (board[line+1][clo-1] == 'E')){
                E(line+1,clo-1,board);
            }
            if (line+1<=board.length-1 && (board[line+1][clo] == 'E')){
                E(line+1,clo,board);
            }
            if (line+1<=board.length-1 && clo+1<=board[0].length-1 && (board[line+1][clo+1] == 'E')){
                E(line+1,clo+1,board);
            }
        }
        return board;
    }
}
