package task1;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by admin on 02.06.2017.
 */
public class Runner {
    public static void main(String[] args) {
        ReflectionUse reflectionUse= new ReflectionUse();
        try {
            reflectionUse.useWithConstructor();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
