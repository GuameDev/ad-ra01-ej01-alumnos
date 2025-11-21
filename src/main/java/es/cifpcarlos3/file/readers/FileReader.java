package es.cifpcarlos3.file.readers;

import es.cifpcarlos3.models.Course;
import es.cifpcarlos3.models.Student;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;

public class FileReader {
    public static Course createCourseFromFile(Path filePath, String courseName, String fileSeparator, String filter) {
        System.out.println("Leyendo fichero: " + filePath.getFileName() + "...");

        Course course = new Course();
        course.setName(courseName);

        try (var reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
            String currentLine;
            while ((currentLine = reader.readLine()) != null) {
                String cleanLine = cleanLine(currentLine);

                String[] studentParts = cleanLine.split(fileSeparator);

                int id = Integer.parseInt(studentParts[0].trim());
                String surnames = studentParts[1].trim();
                String name = studentParts[2].trim();
                String city = studentParts[3].trim();
                int age = Integer.parseInt(studentParts[4].trim());

                Student student = new Student(id,surnames,name,city,age, LocalDate.now());
                if(city.equalsIgnoreCase(filter)){
                    course.addStudent(student);
                    System.out.println("+ El Alumno "+ student +" ha sido añadido");
                }
                else {
                    System.out.println("- El Alumno "+ student +" no se ha añadido porque es de "+ city);
                }
            }
            return course;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String cleanLine(String currentLine) {
        if(!currentLine.isEmpty()  && currentLine.charAt(0) == '\uFEFF'){
            return currentLine.substring(1).trim();
        }
        return  currentLine.trim();
    }
}
