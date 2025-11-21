package es.cifpcarlos3.file.writers;

import tools.jackson.databind.SerializationFeature;
import tools.jackson.dataformat.xml.XmlMapper;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class XmlFileWriter<T> implements FileWriter<T>{
    @Override
    public void saveFile(T data, Path filePath) {
        System.out.println("Generando fichero: " + filePath.getFileName() + "...");
        createFile(filePath);
        var xmlMapper = XmlMapper.builder() // Inicio del objeto XmlMapper
                .enable(SerializationFeature.INDENT_OUTPUT) // Salida XML con formato
                .build();

        try ( OutputStream outputStream = Files.newOutputStream(filePath) ) {
            xmlMapper.writeValue(outputStream, data);
            System.out.println("Fichero generado: " + filePath.getFileName());
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
