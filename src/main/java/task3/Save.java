package task3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *<p>Annotation for annotating fields that need to be serialized.</p>
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Save {
    /**
     * Characterizes the type of the annotated field.
     * @return {@link StateSave#STANDART} if the field is a primitive or a standard class object
     * else {@link StateSave#OWN_TYPE}
     */
    StateSave value() default StateSave.STANDART;
}
