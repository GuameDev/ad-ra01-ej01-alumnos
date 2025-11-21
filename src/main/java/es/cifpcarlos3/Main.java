package es.cifpcarlos3;

import es.cifpcarlos3.file.readers.FileReader;
import es.cifpcarlos3.file.writers.BinaryFileWriter;
import es.cifpcarlos3.file.writers.FileWriter;
import es.cifpcarlos3.models.Course;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;



public class Main {

    private static final String DAM_FILE_NAME = "lista_alumnado_DAM2.txt";
    private static final String DAW_FILE_NAME = "lista_alumnado_DAW1.csv";

    private static final String DAM_COURSE_NAME = "DAM";
    private static final String DAW_COURSE_NAME = "DAW";

    private static final String DAM_FILE_SEPARATOR = ",";
    private static final String DAW_FILE_SEPARATOR = ";";

    private static final String CITY_FILTER = "Cartagena";

    private static final String OUTPUT_FOLDER = "salida";
    private static final String STUDENTS_DAT = "cursos.dat";

    public static void main(String[] args) {
        Path rootProjectPath = Paths.get("").toAbsolutePath();
        Path outputPath = rootProjectPath.resolve(OUTPUT_FOLDER);

        FileWriter binaryFileWriter = new BinaryFileWriter();

        System.out.println("---------------------DAM-----------------------");
        Course damCourse = FileReader.createCourseFromFile(
                rootProjectPath.resolve(DAM_FILE_NAME),
                DAM_COURSE_NAME,
                DAM_FILE_SEPARATOR,
                CITY_FILTER);

        System.out.println("---------------------DAW-----------------------");
        Course dawCourse = FileReader.createCourseFromFile(
                rootProjectPath.resolve(DAW_FILE_NAME),
                DAW_COURSE_NAME,
                DAW_FILE_SEPARATOR,
                CITY_FILTER);

        List<Course> courses = List.of(
                damCourse,
                dawCourse);

        binaryFileWriter.saveFile(courses, outputPath.resolve(STUDENTS_DAT));
    }
}
