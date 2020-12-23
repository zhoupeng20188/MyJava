package algorithm.dfs;

/**
 * @Author zp
 * @create 2020/12/23 14:33
 */
public class Dfs {
    public static void main(String[] args) {
        char[][] board = {{'a','a'}};
        System.out.println(exist(board, "aaa"));
    }

    public static boolean exist(char[][] board, String word) {
        final char[] chars = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, chars, i, j, 0)) return true;
            }
        }
        return false;
    }

    public static boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i < 0 || j < 0 || i > board.length - 1 || j > board[0].length - 1 || board[i][j] != word[k]) return false;
        boolean result = false;
        if (k == word.length - 1) return true;
        // 保存已搜索过的路径
        board[i][j] = '~';
        result = dfs(board, word, i + 1, j, k + 1) ||
                 dfs(board, word, i - 1, j, k + 1) ||
                 dfs(board, word, i, j + 1, k + 1) ||
                 dfs(board, word, i, j - 1, k + 1);
        // 还原
        board[i][j] = word[k];
        return result;
    }
}
