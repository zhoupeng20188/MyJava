package algorithm.fibonacci;

/**
 * @Author zp
 * @create 2020/12/23 11:18
 */
public class Fibonacci {
    public static void main(String[] args) {
        System.out.println(find(45));
        System.out.println(find2(45));
    }

    /**
     * 递归实现
     * @param n
     * @return
     */
    public static int find(int n){
        if(n<=0) return 0;
        if(n==1) return 1;
        return find(n-1) + find(n-2);
    }

    /**
     * 非递归实现
     * @param n
     * @return
     */
    public static int find2(int n){
        if(n<=0) return 0;
        if(n==1) return 1;
        int minusTwo =0;
        int minusOne =1;
        int fib = 0;
        for(int i=2; i<=n; i++){
            fib = minusTwo + minusOne;
            minusTwo = minusOne;
            minusOne = fib;
        }
        return fib;
    }
}
