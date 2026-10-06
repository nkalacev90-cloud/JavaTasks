package JavaTask.task5;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        try {
            String content = ReflectionDeserializer.readFromFile("example1.txt");
            Object object = ReflectionDeserializer.deserializer(content,"JavaTask.task5.Meeting");
            System.out.println(object);
            object.getClass().getDeclaredMethod("setUsersLimit", int.class).invoke(object, 80);
            String newObj = ReflectionSerializer.serialize(object);
            ReflectionSerializer.printFile("new", newObj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
