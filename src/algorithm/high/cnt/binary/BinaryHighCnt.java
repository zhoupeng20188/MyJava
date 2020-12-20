package algorithm.high.cnt.binary;

/**
 * 传统方法为每次将最后一位与1进行&操作，结果为1时即这位为1，然后右移循环
 * 进阶方法为n&(n-1),结果为将数据中的最后一个1变为0，其余不变，即消去最右边的1
 */
public class BinaryHighCnt {
    public static void main(String[] args) {
        System.out.println(binaryHighCnt(16));
    }

    public static int binaryHighCnt(int n){
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n &= n-1;
        }
        return cnt;
    }
}
