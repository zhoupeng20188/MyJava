package finalclass;

public final class FinalClassTest {
    private final int a1;
    private final int a2;
    public static final FinalClassTest f1 = new FinalClassTest(10,20);

    public FinalClassTest(int a1, int a2) {
        this.a1 = a1;
        this.a2 = a2;
    }

    public int getA1() {
        return a1;
    }

    public int getA2() {
        return a2;
    }

    public FinalClassTest pingfang(){
        return new FinalClassTest(a1*a1, a2*a2);
    }

    @Override
    public String toString() {
        return "FinalClassTest{" +
                "a1=" + a1 +
                ", a2=" + a2 +
                '}';
    }
}
