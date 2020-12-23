package algorithm.dfs;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，
 * 因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 *
 * @Author zp
 * @create 2020/12/23 15:16
 */
public class RobotMove {
    public static void main(String[] args) {
        System.out.println(movingCount(38, 15, 9));
    }

    static int cnt = 0;

    public static int movingCount(int m, int n, int k) {
        final int[][] visited = new int[m][n];
        if (canMove(0, 0, m, n, k, visited)) return cnt;
        return cnt;
    }

    public static boolean canMove(int i, int j, int m, int n, int k, int[][] visited) {
        if (i < 0 || j < 0 || i > m - 1 || j > n - 1 || visited[i][j] == 1) return false;
        int tmpi = i;
        int tmpj = j;
        if (i >= 10) tmpi = i / 10 + i % 10;
        if (j >= 10) tmpj = j / 10 + j % 10;
        if (tmpi + tmpj > k) return false;
        cnt++;

        visited[i][j] = 1;

        canMove(i, j - 1, m, n, k, visited);
        canMove(i, j + 1, m, n, k, visited);
        canMove(i - 1, j, m, n, k, visited);
        canMove(i + 1, j, m, n, k, visited);
        return true;
    }
}
