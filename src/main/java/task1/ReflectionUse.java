package task1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Just class with reflection
 */
public class ReflectionUse {

    /**
     * Number of parameters
     */
    public static final int N=2;

    /**
     * <p>Call the methods of the class {@link MyClass},
     * which are marked with an annotation {@link Test}
     * and have signature <method_name> (int ,int)</p>
     *
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @see MyClass
     * @see Test
     */
    public void useWithConstructor()
            throws InvocationTargetException, IllegalAccessException {

        Class<?> cl = MyClass.class;
        Method[] methods = cl.getDeclaredMethods();

        for (Method method : methods) {
            method.setAccessible(true);
            // Annotation check
            if (method.isAnnotationPresent(Test.class)) {
                Test annotation = method.getAnnotation(Test.class);

                //Check the number and types of parameters
                // method's signature <method_name> (int ,int)
                Class<?>[] parameterTypes=method.getParameterTypes();

                if (parameterTypes.length != N
                        ||!parameterTypes[0].equals(int.class)
                        ||!parameterTypes[1].equals(int.class)) continue;
                method.invoke(new MyClass(), annotation.a(), annotation.b());

            }
        }
    }
}
