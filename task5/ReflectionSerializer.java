package JavaTask.task5;

import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ReflectionSerializer {
    public static String serialize(Object object) throws IllegalAccessException, IOException {
        Class<?> clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        StringBuilder stringBuilder = new StringBuilder();
        for (Field field: fields) {
            stringBuilder.append("'");
            stringBuilder.append(field.getName()).append("'='");

            field.setAccessible(true);

            switch (field.get(object).getClass().getCanonicalName()){
                case "java.time.LocalTime": {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                    LocalTime time = (LocalTime) field.get(object);
                    stringBuilder.append(time.format(formatter));
                    break;
                } case "java.time.LocalDate":     {
                        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd.MM.yyyy");
                        LocalDate date = (LocalDate) field.get(object);
                        stringBuilder.append(date.format(formatter1));
                        break;
                } case "java.time.LocalDateTime":{
                        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");
                        LocalDateTime dateTime = (LocalDateTime) field.get(object);
                        stringBuilder.append(dateTime.format(formatter2));
                        break;
                } default:{
                    stringBuilder.append(field.get(object).toString());

                }
            }
            stringBuilder.append("'").append("\n");
        }
        return stringBuilder.toString();

    }

    public static void printFile(String fileName, String text) throws IOException {
        Files.writeString(Path.of(fileName), text, StandardCharsets.UTF_8);
    }

}
