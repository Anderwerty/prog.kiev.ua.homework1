package task3;

import java.lang.reflect.Field;

/**
 * Created by admin on 10.06.2017.
 */
public class MyJson {

    public String serialize(Object object){
        Class<?> objClass=object.getClass();
        Field fields[]=objClass.getDeclaredFields();

    }
}
