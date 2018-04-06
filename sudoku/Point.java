package sudoku;

/**
 * This is Description
 *
 * @auther boring
 * @date 2018/04/06
 */
public class Point {
    private int a;
    private int b;

    public Point(int var1, int var2) {
        this.a = var1;
        this.b = var2;
    }

    public Point() {
    }

    public int getA() {
        return this.a;
    }

    public void setA(int var1) {
        this.a = var1;
    }

    public int getB() {
        return this.b;
    }

    public void setB(int var1) {
        this.b = var1;
    }
}
