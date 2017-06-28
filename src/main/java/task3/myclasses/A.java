package task3.myclasses;

import task3.Save;

/**
 * Just class with one own field.
 */
public class A {
    @Save
    private int aInt;
    @Save
    private int bInt;

    // TODO: method creatJson() dasn't work with recuscion.
  // @Save(StateSave.OWN_TYPE)
    private B b;
    @Save
    private String str;

    public A(){}
    /**
     * Constructon with parameters.
     *
     * @param aInt type Integer
     * @param bInt type Integer
     * @param b    {@link B}
     * @param str
     */
    public A(int aInt, int bInt, B b, String str) {
        this.aInt = aInt;
        this.bInt = bInt;
        this.b = b;
        this.str = str;
    }

    public Integer getaInt() {
        return aInt;
    }

    public void setaInt(int aInt) {
        this.aInt = aInt;
    }

    public int getbInt() {
        return bInt;
    }

    public void setbInt(int bInt) {
        this.bInt = bInt;
    }

    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        A a = (A) o;

        if (aInt != a.aInt) return false;
        if (bInt != a.bInt) return false;
        if (b != null ? !b.equals(a.b) : a.b != null) return false;
        return str != null ? str.equals(a.str) : a.str == null;
    }

    @Override
    public int hashCode() {
        int result = aInt;
        result = 31 * result + bInt;
        result = 31 * result + (b != null ? b.hashCode() : 0);
        result = 31 * result + (str != null ? str.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "A{" +
                "aInt=" + aInt +
                ", bInt=" + bInt +
                ", b=" + b +
                ", str='" + str + '\'' +
                '}';
    }
}
