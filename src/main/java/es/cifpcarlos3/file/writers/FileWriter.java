package es.cifpcarlos3.file.writers;

import es.cifpcarlos3.models.Course;

import java.nio.file.Path;
import java.util.List;

public interface FileWriter {
    void saveFile(List<Course> course, Path fileName);
}
