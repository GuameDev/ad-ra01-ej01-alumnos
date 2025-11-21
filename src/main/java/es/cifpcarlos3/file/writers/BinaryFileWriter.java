package es.cifpcarlos3.file.writers;

import es.cifpcarlos3.models.Course;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class BinaryFileWriter implements FileWriter{
    @Override
    public void saveFile(List<Course> courses, Path filePath) {
        createFile(filePath);

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath.toFile());
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)){

            objectOutputStream.writeObject(courses);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private static void createFile(Path filePath) {
        try {
            Path parentDirectory = filePath.getParent();

            if (parentDirectory != null) {
                Files.createDirectories(parentDirectory);
            }

            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to create file: " + filePath, e);
        }
    }
}
