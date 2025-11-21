package es.cifpcarlos3;

import es.cifpcarlos3.file.dtos.CreateCourseJsonFileDto;
import es.cifpcarlos3.file.readers.FileReader;
import es.cifpcarlos3.file.writers.BinaryFileWriter;
import es.cifpcarlos3.file.writers.FileWriter;
import es.cifpcarlos3.file.writers.JsonFileWriter;
import es.cifpcarlos3.file.writers.XmlFileWriter;
import es.cifpcarlos3.models.Course;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;



public class Main {

    //Rutas de los ficheros originales
    private static final String DAM_FILE_NAME = "lista_alumnado_DAM2.txt";
    private static final String DAW_FILE_NAME = "lista_alumnado_DAW1.csv";

    //Nombre de los cursos
    private static final String DAM_COURSE_NAME = "DAM";
    private static final String DAW_COURSE_NAME = "DAW";

    //Separador utilizado en los ficheros originales
    private static final String DAM_FILE_SEPARATOR = ",";
    private static final String DAW_FILE_SEPARATOR = ";";

    //Filtros de los alumnos
    private static final String CITY_FILTER = "Cartagena";

    //Ruta de la carpeta de los ficheros de salida
    private static final String OUTPUT_FOLDER = "salida";

    //Ruta de los ficheros de salida
    private static final String COURSES_DAT = "cursos.dat";
    private static final String COURSES_JSON = "cursos.json";
    public static final String COURSES_XML = "cursos.xml";
    private static final String DAM_JSON = "dam2.json";
    private static final String DAW_JSON = "daw1.json";


    public static void main(String[] args) {
        Path rootProjectPath = Paths.get("").toAbsolutePath();
        Path outputPath = rootProjectPath.resolve(OUTPUT_FOLDER);

        //Binario
        FileWriter<List<Course>> coursesBinaryFileWriter = new BinaryFileWriter<>();

        //JSON
        FileWriter<CreateCourseJsonFileDto> coursesJsonFileWriter = new JsonFileWriter<>();
        FileWriter<Course> courseJsonFileWriter = new JsonFileWriter<>();

        //XML
        FileWriter<CreateCourseJsonFileDto> courseXmlFileWriter = new XmlFileWriter<>();


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

        //Binario conjunto
        coursesBinaryFileWriter.saveFile(courses, outputPath.resolve(COURSES_DAT));

        //JSON conjunto
        CreateCourseJsonFileDto dto = new CreateCourseJsonFileDto();
        dto.courses = courses;

        coursesJsonFileWriter.saveFile(dto, outputPath.resolve(COURSES_JSON));

        //JSON separados
        courseJsonFileWriter.saveFile(damCourse, outputPath.resolve(DAM_JSON));
        courseJsonFileWriter.saveFile(dawCourse, outputPath.resolve(DAW_JSON));

        //XML
        courseXmlFileWriter.saveFile(dto,outputPath.resolve(COURSES_XML));
    }
}
