package es.cifpcarlos3.file.writers;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

public class BinaryFileWriter<T> implements FileWriter<T>{
    @Override
    public void saveFile(T courses, Path filePath) {
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
