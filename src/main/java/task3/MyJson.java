package task3;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Class similar to class Json.
 */
public class MyJson {


    private String result;

    /**
     * Constructor without parameters.
     */
    public MyJson() {
        this.result = "";
    }


    /**
     * <p>Method for object serialization.</p>
     *
     * @param object The object that is need to be serialized.
     * @return {@link String} representing an object in the form of string.
     * @throws IllegalArgumentInputException
     * @throws IllegalAccessException
     * @see {@link MyJson#createJSon(Object)}
     */
    public String serialize(Object object) throws
            IllegalArgumentInputException, IllegalAccessException {

        result += createJSon(object).toString();
        return result;


    }

    /**
     * Create StringBuilder  for serializable  object. It is just an internal method.
     *
     * @param object
     * @return
     * @throws IllegalArgumentInputException if {@param object is null}
     * @throws IllegalAccessException
     *
     */
    private StringBuilder createJSon(Object object) throws IllegalArgumentInputException,
            IllegalAccessException {
        Optional.ofNullable(object).orElseThrow(IllegalArgumentInputException::new);
        Class<?> objClass = object.getClass();
        StringBuilder tempStr = new StringBuilder(objClass.getName() + "[");
        Field fields[] =
                defineAnnotatedFields(objClass.getDeclaredFields());


        for (int i = 0; i < fields.length; i++) {

            fields[i].setAccessible(true);
            tempStr.append(fields[i].getName()).append(":");
            if (fields[i].getAnnotation(Save.class).value() == StateSave.STANDART) {
                if (fields[i].getType().isPrimitive()) {
                    tempStr.append(primitiveAnalizator(fields[i], object));
                } else {
                    tempStr.append(fields[i].get(object).toString());
                }


            } else {

                tempStr.append(createJSon(fields[i].get(object)));

            }
            if (i < fields.length - 1)
                tempStr.append(";");
        }

        tempStr.append("]");
        return tempStr;
    }

    /**
     * <p>Method returns fields that are marked with an annotation {@link Save}</p>
     *
     * @param fields
     * @return
     */
    private Field[] defineAnnotatedFields(Field[] fields) {
        List<Field> fieldList = new ArrayList<>();
        for (Field tempField : fields) {
            if (tempField.isAnnotationPresent(Save.class)) {
                fieldList.add(tempField);
            }
        }
        return fieldList.toArray(new Field[fieldList.size()]);

    }


    /**
     * <p>Returns a value in the format of a string of a primitive type field/
     * Generates {@link IllegalArgumentInputException} if the field's type is not primitive</p>
     *
     * @param field
     * @param object
     * @return
     * @throws IllegalAccessException
     * @throws IllegalArgumentInputException
     */
    private String primitiveAnalizator(Field field, Object object)
            throws IllegalAccessException, IllegalArgumentInputException {
        if (field.getType() == byte.class) {
            return String.valueOf(field.getByte(object));
        }
        if (field.getType() == short.class) {
            return String.valueOf(field.getShort(object));
        }
        if (field.getType() == int.class) {
            return String.valueOf(field.getInt(object));
        }
        if (field.getType() == long.class) {
            return String.valueOf(field.getLong(object));
        }
        if (field.getType() == float.class) {
            return String.valueOf(field.getFloat(object));
        }
        if (field.getType() == double.class) {
            return String.valueOf(field.getDouble(object));
        }
        if (field.getType() == char.class) {
            return String.valueOf(field.getChar(object));
        }
        if (field.getType() == boolean.class) {
            return String.valueOf(field.getBoolean(object));
        }

        throw new IllegalArgumentInputException();
    }

    public Object deserialize(String json)
            throws ClassNotFoundException, IllegalAccessException,
            InstantiationException, NoSuchFieldException {


        String tempSrt[] = json.substring(0, json.length() - 1).split("\\[");
        Class<?> classObj = Class.forName(tempSrt[0]);
        Object obj = classObj.newInstance();
        String fields[] = tempSrt[1].split(";");

        for (String elemet : fields) {
            String nameValue[] = elemet.split(":");
            Field field = classObj.getDeclaredField(nameValue[0]);
            field.setAccessible(true);
            if (field.getType().isPrimitive()) {
                setPrimitive(obj, nameValue[1], field);

            } else {
                field.set(obj, nameValue[1]);
                System.out.println(nameValue[1]);
            }

        }
        return obj;


    }

    private void setPrimitive(Object obj, String value, Field field) throws IllegalAccessException {
        if (field.getType() == byte.class) {
            field.setByte(obj, Byte.parseByte(value));
            return;
        }
        if (field.getType() == short.class) {
            field.setShort(obj, Short.parseShort(value));
            return;
        }

        if (field.getType() == int.class) {
            field.setInt(obj, Integer.parseInt(value));
            return;
        }
        if (field.getType() == long.class) {
            field.setLong(obj, Long.parseLong(value));
            return;
        }
        if (field.getType() == float.class) {
            field.setFloat(obj, Float.parseFloat(value));
            return;
        }
        if (field.getType() == double.class) {
            field.setDouble(obj, Double.parseDouble(value));
            return;
        }
        if (field.getType() == char.class) {
            field.setChar(obj, new Character(value.charAt(0)));
            return;
        }
        if (field.getType() == boolean.class) {
            field.setBoolean(obj, Boolean.parseBoolean(value));
            return;
        }
    }
}

