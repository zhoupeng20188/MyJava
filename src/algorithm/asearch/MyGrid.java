package algorithm.asearch;

/**
 * @Author zhoupeng
 * @Date 2020-05-14 11:14
 */
public class MyGrid {
    /**
     * x坐标
     */
    private int x;
    /**
     * y坐标
     */
    private int y;
    /**
     * 格子距离起点的距离
     */
    private int g;
    /**
     * 格子距离终点的距离
     */
    private int h;
    /**
     * g+h,即从起点到终点的距离
     */
    private int f;

    /**
     * 父节点
     */
    private MyGrid parent;

    public MyGrid(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public MyGrid(int x, int y, MyGrid parent) {
        this.x = x;
        this.y = y;
        this.parent = parent;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getF() {
        return f;
    }

    public void setF(int f) {
        this.f = f;
    }

    public MyGrid getParent() {
        return parent;
    }

    public void setParent(MyGrid parent) {
        this.parent = parent;
    }

    @Override
    public String toString() {
        return "MyGrid{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
