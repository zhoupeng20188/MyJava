package algorithm.calc;

/**
 * 数值的整数次方
 */
public class MyPower {
    public static void main(String[] args) {
        System.out.println(myPow(2.0, 4));
    }

    public static double myPow(double x, int n) {
        if (x == 0) return 0;
        if (x == 1) return 1;
        long l = n;
        if(l > 0) return calc(x,l);
        double calc = calc(x, -l);
        return 1.0/calc;

    }

    public static double calc(double x, long n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        double res = calc(x, n >> 1);
        // 偶数的场合，a的n次方 = a的n/2次方 * a的n/2次方
        res *=res;
        if((n & 1) == 1) {
            // 奇数的场合，再乘一个x
            res *= x;
        }
        return res;
    }
}
