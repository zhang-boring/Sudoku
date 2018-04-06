package sudoku;

/**
 * This is Description
 *
 * @author boring
 * @date 2018/04/06
 */
public class Point {
    private int a;
    private int b;

    public Point(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Point() {
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }
}
