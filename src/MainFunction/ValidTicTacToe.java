package MainFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2019/12/21
 * Time: 18:39
 * Description: 用字符串数组作为井字游戏的游戏板 board。当且仅当在井字游戏过程中，
 *              玩家有可能将字符放置成游戏板所显示的状态时，才返回 true。
 */
public class ValidTicTacToe {
    public static boolean validTicTacToe(String[] board) {
        Map<String, Integer> map = countChar(board);
        int countX = map.get("X");
        int countO = map.get("O");
        int count = map.get(" ");
        Integer result = map.get("result");
        if (countX==0&&countO!=0){
            return false;
        }
        if (countX-countO>1 || countX-countO<0){
            return false;
        }
        if (result==1){
            return true;
        }else {
            return false;
        }
    }

    public static Map<String,Integer> countChar(String[] board){
        Map<String,Integer> map = new HashMap<>();
        map.put("X",0);
        map.put("O",0);
        map.put(" ",0);
        char[][] boardChar = new char[3][3];
        for (int i=0;i<board.length;i++){
            char[] chars = board[i].toCharArray();
            for (int j=0;j<chars.length;j++){
                boardChar[i][j] = chars[j];
                if (chars[j]=='X'){
                    map.put("X",map.get("X")+1);
                }
                if (chars[j]=='O'){
                    map.put("O",map.get("O")+1);
                }
                if (chars[j]==' '){
                    map.put(" ",map.get(" ")+1);
                }
            }
        }
        boolean b = gameOver(boardChar,map);
        if (b){
            map.put("result",1);
        }else {
            map.put("result",0);
        }
        return map;
    }

    public static boolean gameOver(char[][] boardChar,Map<String,Integer> map){
        if (boardChar[0][0]==boardChar[0][1]&&boardChar[0][1]==boardChar[0][2]&&boardChar[0][0]!=' '){
            if (boardChar[1][0]==boardChar[1][1]&&boardChar[1][1]==boardChar[1][2]&&boardChar[1][0]!=' '){
                return false;
            }
            if (boardChar[0][0]=='X'&&map.get("X")==map.get("O")){
                return false;
            }
            if (boardChar[0][0]=='O'&&map.get("X")>map.get("O")){
                return false;
            }
        }
        if (boardChar[1][0]==boardChar[1][1]&&boardChar[1][1]==boardChar[1][2]&&boardChar[1][0]!=' '){
            if (boardChar[2][0]==boardChar[2][1]&&boardChar[2][1]==boardChar[2][2]&&boardChar[2][0]!=' '){
                return false;
            }
            if (boardChar[1][0]=='X'&&map.get("X")==map.get("O")){
                return false;
            }
            if (boardChar[1][0]=='O'&&map.get("X")>map.get("O")){
                return false;
            }
        }
        if (boardChar[2][0]==boardChar[2][1]&&boardChar[2][1]==boardChar[2][2]&&boardChar[2][0]!=' '){
            if (boardChar[0][0]==boardChar[0][1]&&boardChar[0][1]==boardChar[0][2]&&boardChar[0][0]!=' '){
                return false;
            }
            if (boardChar[2][0]=='X'&&map.get("X")==map.get("O")){
                return false;
            }
            if (boardChar[2][0]=='O'&&map.get("X")>map.get("O")){
                return false;
            }
        }
        if (boardChar[0][0]==boardChar[1][0]&&boardChar[1][0]==boardChar[2][0]&&boardChar[0][0]!=' '){
            if (boardChar[0][1]==boardChar[1][1]&&boardChar[1][1]==boardChar[2][1]&&boardChar[0][1]!=' '){
                return false;
            }
            if (boardChar[0][0]=='X'&&map.get("X")==map.get("O")){
                return false;
            }
            if (boardChar[0][0]=='O'&&map.get("X")>map.get("O")){
                return false;
            }
        }
        if (boardChar[0][1]==boardChar[1][1]&&boardChar[1][1]==boardChar[2][1]&&boardChar[0][1]!=' '){
            if (boardChar[0][2]==boardChar[1][2]&&boardChar[1][2]==boardChar[2][2]&&boardChar[0][2]!=' '){
                return false;
            }
            if (boardChar[0][1]=='X'&&map.get("X")==map.get("O")){
                return false;
            }
            if (boardChar[0][1]=='O'&&map.get("X")>map.get("O")){
                return false;
            }
        }
        if (boardChar[0][2]==boardChar[1][2]&&boardChar[1][2]==boardChar[2][2]&&boardChar[0][2]!=' '){
            if (boardChar[0][0]==boardChar[1][0]&&boardChar[1][0]==boardChar[2][0]&&boardChar[0][0]!=' '){
                return false;
            }
            if (boardChar[0][2]=='X'&&map.get("X")==map.get("O")){
                return false;
            }
            if (boardChar[0][2]=='O'&&map.get("X")>map.get("O")){
                return false;
            }
        }
        if (boardChar[0][0]==boardChar[1][1]&&boardChar[1][1]==boardChar[2][2]&&boardChar[0][0]!=' '){
            if (boardChar[0][0]=='X'&&map.get("X")==map.get("O")){
                return false;
            }
            if (boardChar[0][0]=='O'&&map.get("X")>map.get("O")){
                return false;
            }
        }
        if (boardChar[2][0]==boardChar[1][1]&&boardChar[1][1]==boardChar[0][2]&&boardChar[0][2]!=' '){
            if (boardChar[0][2]=='X'&&map.get("X")==map.get("O")){
                return false;
            }
            if (boardChar[0][2]=='O'&&map.get("X")>map.get("O")){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] board = new String[]{"OO ","O X","X  "};
        boolean b = validTicTacToe(board);
        System.out.println(b);
    }
}
