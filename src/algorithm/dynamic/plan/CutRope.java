package algorithm.dynamic.plan;

/**
 * 剪绳子，动态归化解法，从下到上，中间用数组记录中间结果。
 * @Author zp
 * @create 2020/12/23 16:44
 */
public class CutRope {
    public static void main(String[] args) {
        System.out.println(cuttingRope(4));
    }
    public static int cuttingRope(int n) {
        if(n == 1) return 0;
        if(n == 2) return 1;
        if(n == 3) return 2;
        int[] arr = new int[n+1];
        // 当剪完后的小长度为1/2/3时，乘积最大就是它们本身
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        int max =0;
        for(int i=4; i<=n;i++){
            // 这里是i/2的原因是，超过一半后后面的计算重复了
            for(int j=1; j<= i/2; j++) {
                int val = arr[j] * arr[i-j];
                if(max < val){
                    max =val;
                }
            }
            arr[i] = max;
        }
        return max;
    }
}
