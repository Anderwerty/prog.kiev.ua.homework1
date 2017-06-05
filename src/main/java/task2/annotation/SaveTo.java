package task2.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * <p>Specifies the path to save the file.
 * Default path is "C:\\file.txt"</p>
 *
 */
//@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SaveTo {
    String value() default "C:\\file.txt";
}
