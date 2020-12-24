package algorithm.metrix;

/**
 * 顺时针打印矩阵
 * @Author zp
 * @create 2020/12/24 15:12
 */
public class PrintMetrix {
    public static void main(String[] args) {
//        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        int[][] matrix = {{3},{2}};
        System.out.println(spiralOrder(matrix));
    }

    static int cnt = -1;

    public static int[] spiralOrder(int[][] matrix) {
        if(matrix == null) return null;
        int rows = matrix.length;
        int columns= matrix[0].length;
        int[] result = new int[rows * columns ];

        int start = 0;
        while(rows > start *2 && columns > start *2){
            print(matrix, rows, columns, start, result);
            start++;
        }
        return result;
    }

    public static void print(int[][] matrix, int rows, int columns, int start, int[] result){
        int endX = columns - start -1;
        int endY = rows - start -1;

        for(int i=start; i<=endX; i++){
            // 从左到右打印一行
            cnt++;
            result[cnt] = matrix[start][i];
        }

        // 从上到下打印一列
        // 需要有列才需要此步骤
        if(start < endY){
            for(int i = start+1;i<=endY;i++){
                cnt++;
                result[cnt] = matrix[i][endX];
            }
        }

        // 从右向左打印一行
        // 必须有两行两列才需要此步骤
        if(start < endX && start < endY){
            for(int i=endX-1; i>=start; i--){
                cnt++;
                result[cnt] = matrix[endY][i];
            }
        }


        // 从下向上打印一列
        // 必须有三行两列才需要此步骤
        if(start < endX && start < endY -1){
            for(int i = endY-1;i>=start+1;i--){
                cnt++;
                result[cnt] = matrix[i][start];
            }
        }
    }
}
