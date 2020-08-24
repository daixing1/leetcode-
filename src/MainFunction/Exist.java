package MainFunction;

/**
 * User: 兴希
 * Date: 2020/7/22
 * Time: 9:07
 * Description: 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *              单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 *              同一个单元格内的字母不允许被重复使用。
 */
public class Exist {
    public boolean exist(char[][] board, String word) {
        boolean flag = false;
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[i].length;j++){
                if (board[i][j]==word.charAt(0)){
                    flag = flag||dfs(board,new boolean[board.length][board[0].length],word,i,j);
                }
            }
        }
        return flag;
    }

    private boolean dfs(char[][] board, boolean flag[][], String word, int r, int c){
        if (word.length()==0){
            return true;
        }else if (!flag[r][c]&&board[r][c]==word.charAt(0)){
            flag[r][c]=true;

            boolean dfs1 = dfs(board, flag, word.substring(1), Math.min(r + 1,board.length-1), c);
            boolean dfs2 = dfs(board, flag, word.substring(1), Math.max(0,r - 1), c);
            boolean dfs3 = dfs(board, flag, word.substring(1), r, Math.min(board[0].length-1,c + 1));
            boolean dfs4 = dfs(board, flag, word.substring(1), r, Math.max(0,c - 1));
            if (dfs1||dfs2||dfs3||dfs4){
                return true;
            }else {
                flag[r][c] = false;
                return false;
            }
//            return dfs1||dfs2||dfs3||dfs4;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        Exist exist = new Exist();
        boolean abceseeefs = exist.exist(new char[][]{
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'E', 'S'},
                        {'A', 'D', 'E', 'E'}},
                "ABCESEEEFS");
        System.out.println(abceseeefs);
    }
}
