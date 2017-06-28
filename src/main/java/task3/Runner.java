package task3;

import task3.myclasses.A;
import task3.myclasses.B;

/**
 * Created by admin on 08.06.2017.
 */
public class Runner {

    public static void main(String[] args)  {
        A a = new A(1,2,new B(1),"A");
        MyJson myJson= new MyJson();
        String str= null;
        try {
            str = myJson.serialize(a);
        } catch (IllegalArgumentInputException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        System.out.println(str);
        try {
            System.out.println(myJson.deserialize(str));
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (IllegalAccessException e) {
            System.out.println(e);
        } catch (InstantiationException e) {
            System.out.println(e);
        } catch (NoSuchFieldException e) {
            System.out.println(e);
        }
    }
}
