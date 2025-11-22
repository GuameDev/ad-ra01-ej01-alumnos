package es.cifpcarlos3.file.writers;

import es.cifpcarlos3.file.helpers.FileHelper;
import tools.jackson.databind.json.JsonMapper;
import java.nio.file.Path;

public class JsonFileWriter<T> implements FileWriter<T> {

    private final JsonMapper mapper;

    public JsonFileWriter(JsonMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void write(T data, Path filePath) {

        FileHelper.createIfNotExists(filePath);
        System.out.println("Escribiendo en el fichero " + filePath.getFileName() + "...");

        mapper.writeValue(filePath, data);
        System.out.println("Se ha terminado de escribir en el fichero: " + filePath.getFileName());
    }
}
