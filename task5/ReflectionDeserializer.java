package JavaTask.task5;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ReflectionDeserializer {
    public static Object deserializer(String serializedData, String className) throws IllegalAccessException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class<?>clazz=Class.forName(className);
        Object object = clazz.getConstructor()
                .newInstance();

        String[] lines = serializedData.split("\n");
        for (String line:lines){
            String[] parts = line.split("=");
            String name = parts[0].replace("'", "");
            String value = parts[1].replace("'", "");

            Field field = clazz.getDeclaredField(name);
            Class<?> typeField = field.getType();
            Object objectValue = getValue(value, typeField);
            field.setAccessible(true);
            field.set(object, objectValue);
        }
        return object;
    }


    private static Object getValue(String value, Class<?> typeField){
            value = value.trim();
        if (typeField == Integer.class || typeField == int.class){
                return Integer.valueOf(value);
            }else if(typeField  == LocalDate.class){
                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                return LocalDate.parse(value, formatter1);
            }else if(typeField  == LocalDateTime.class){
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
                return LocalDateTime.parse(value, formatter2);
            }else if(typeField  == LocalTime.class){
                DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("HH:mm:ss");
                return LocalTime.parse(value, formatter3);
            } else {
                return value;
            }
    }


    public static String readFromFile(String name){
        try (FileReader reader = new FileReader(name)) {
            return reader.readAllAsString();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
        return "";
    }
}
