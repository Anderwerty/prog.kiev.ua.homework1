package task3.myclasses;

import task3.Save;

/**
 * Created by admin on 12.06.2017.
 */
public class B {
    @Save
    private int b;

    public B(int b) {
        this.b = b;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        B b1 = (B) o;

        return b == b1.b;
    }

    @Override
    public int hashCode() {
        return b;
    }

    @Override
    public String toString() {
        return "B{" +
                "b=" + b +
                '}';
    }
}
