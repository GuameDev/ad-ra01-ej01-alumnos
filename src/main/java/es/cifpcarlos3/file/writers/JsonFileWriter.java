package es.cifpcarlos3.file.writers;

import es.cifpcarlos3.file.helpers.FileHelper;
import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;
import java.nio.file.Path;

public class JsonFileWriter<T> implements FileWriter<T> {
    @Override
    public void write(T data, Path filePath) {
        FileHelper.createIfNotExists(filePath);
        System.out.println("Escribiendo en el fichero " + filePath.getFileName() + "...");

        var mapper = JsonMapper.builder()
                .enable(SerializationFeature.WRAP_ROOT_VALUE)
                .enable(DeserializationFeature.UNWRAP_ROOT_VALUE)
                .build();

        mapper.writeValue(filePath, data);
        System.out.println("Se ha terminado de escribir en el fichero: " + filePath.getFileName());
    }
}
