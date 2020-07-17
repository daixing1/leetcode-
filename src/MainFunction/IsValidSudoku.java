package MainFunction;

import java.util.HashMap;
import java.util.Map;

/**
 * User: 兴希
 * Date: 2020/6/4
 * Time: 9:58
 * Description: 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
 *                  数字 1-9 在每一行只能出现一次。
 *                  数字 1-9 在每一列只能出现一次。
 *                  数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 */
public class IsValidSudoku {

    public static boolean isValidSudoku(char[][] board) {
        Map<Character, Integer> map = new HashMap<>();
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        Map<Character, Integer> map3 = new HashMap<>();
        for (int i=0;i<board.length;i++){
            boolean validLine = isValidLine(board[i]);
            if (!validLine){
                return false;
            }
            if (i==3){
                map1.clear();
                map2.clear();
                map3.clear();
            }
            if (i==6){
                map1.clear();
                map2.clear();
                map3.clear();
            }
            map.clear();
            for (int j=0;j<board[i].length;j++){
                if (j<3){
                    if (Character.isDigit(board[i][j])) {
                        map1.put(board[i][j], map1.getOrDefault(board[i][j], 0) + 1);
                        if (map1.get(board[i][j]) > 1) {
                            return false;
                        }
                    }
                }else if (j<6){
                    if (Character.isDigit(board[i][j])) {
                        map2.put(board[i][j], map2.getOrDefault(board[i][j], 0) + 1);
                        if (map2.get(board[i][j]) > 1) {
                            return false;
                        }
                    }
                }else {
                    if (Character.isDigit(board[i][j])) {
                        map3.put(board[i][j], map3.getOrDefault(board[i][j], 0) + 1);
                        if (map3.get(board[i][j]) > 1) {
                            return false;
                        }
                    }
                }
                if (Character.isDigit(board[j][i])) {
                    map.put(board[j][i], map.getOrDefault(board[j][i], 0) + 1);
                    if (map.get(board[j][i]) > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean isValidLine(char[] board){
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0;i<board.length;i++){
            if (Character.isDigit(board[i])){
                map.put(board[i],map.getOrDefault(board[i],0)+1);
                if (map.get(board[i])>1){
                    return false;
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {
        boolean validSudoku = isValidSudoku(new char[][]{
                {'.','.','4','.','.','.','6','3','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'5','.','.','.','.','.','.','9','.'},
                {'.','.','.','5','6','.','.','.','.'},
                {'4','.','3','.','.','.','.','.','1'},
                {'.','.','.','7','.','.','.','.','.'},
                {'.','.','.','5','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'},
                {'.','.','.','.','.','.','.','.','.'}});
        System.out.println(validSudoku);
    }
}
