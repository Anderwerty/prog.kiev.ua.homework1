package task1;

/**
 * Just class to show reflection in java.
 */
public class MyClass {

    @Test(a = 1, b = 2)
    private void test1(int a, int b) {
        System.out.println("Method test1: a=" + a + " b=" + b);
    }


    @Test(a = 3, b = 4)
    private void test2(int a, int b) {
        System.out.println("Method test2: a=" + a + " b=" + b);
    }


    @Test(a = 5, b = 6)
    protected void test3(int a, int b, int c) {
        System.out.println("Method test3: a=" + a + " b=" + b);
    }


    public void test4(int a, int b) {
        System.out.println("Method test4: a=" + a + " b=" + b);
    }
}
