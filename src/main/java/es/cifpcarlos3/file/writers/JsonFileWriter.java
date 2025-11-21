package es.cifpcarlos3.file.writers;

import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JsonFileWriter<T> implements FileWriter<T> {
    @Override
    public void saveFile(T data, Path filePath) {

        createFile(filePath);

        var mapper = JsonMapper.builder()
                .enable(SerializationFeature.WRAP_ROOT_VALUE)
                .enable(DeserializationFeature.UNWRAP_ROOT_VALUE)
                .build();

        mapper.writeValue(filePath, data);
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
