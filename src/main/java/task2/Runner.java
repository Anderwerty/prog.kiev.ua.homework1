package task2;

import task2.annotation.SaveMethod;
import task2.annotation.SaveTo;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by admin on 02.06.2017.
 */
public class Runner {
    public static void main(String[] args) {
        Class<?> classForContainer = TextContainer.class;
        Class<?> classForSave = Saver.class;

        TextContainer textContainer = new TextContainer(" my text");

        Field[] fields = classForContainer.getDeclaredFields();
        Method[] methods = classForSave.getDeclaredMethods();
        Field fieldToSave = findField(fields);

        Method methodSaver = findMethod(methods);

        if (fieldToSave != null && methodSaver != null) {
            fieldToSave.setAccessible(true);
            methodSaver.setAccessible(true);
            try {
                methodSaver.invoke(new Saver(), fieldToSave.getAnnotation(SaveTo.class).value(),
                        fieldToSave.get(textContainer));
                System.out.println("Done!");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * <p> Find method that is annotated by annotation {@link SaveMethod}</p>
     *
     * @param methods array of object of class {@link Method}
     * @return method that is annotated by annotation {@link SaveMethod} or null
     * if in array methods is no element with annotation {@link SaveMethod}
     */
    private static Method findMethod(Method[] methods) {
        for (Method tempMethod : methods) {
            if (tempMethod.isAnnotationPresent(SaveMethod.class)) {
                return tempMethod;
            }

        }
        return null;
    }

    /**
     * <p> Find field that is annotated by annotation {@link SaveTo}</p>
     *
     * @param fields array of object of class {@link Field}
     * @return field that is annotated by annotation {@link SaveTo} or null
     * if in array fields is no element with annotation {@link SaveTo}
     */
    private static Field findField(Field[] fields) {
        for (Field tempField : fields) {
            if (tempField.isAnnotationPresent(SaveTo.class)) {
                return tempField;
            }
        }
        return null;
    }
}
