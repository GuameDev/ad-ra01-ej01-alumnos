package es.cifpcarlos3.file.helpers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileHelper {
    public static void createIfNotExists(Path filePath) {
        try {
            Path parentDirectory = filePath.getParent();

            if (parentDirectory != null && !parentDirectory.toFile().exists()) {
                System.out.println("Se ha creado la carpeta " + parentDirectory.getFileName() + " porque no existía");
                Files.createDirectories(parentDirectory);
            }

            if (!Files.exists(filePath)) {
                System.out.println("Se ha creado el fichero " + filePath.getFileName() + " porque no existía");
                Files.createFile(filePath);
            }

        } catch (IOException e) {
            throw new RuntimeException("Failed to create file: " + filePath, e);
        }
    }
}
