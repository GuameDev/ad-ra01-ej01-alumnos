package es.cifpcarlos3.file.readers;

import tools.jackson.databind.DeserializationFeature;
import tools.jackson.databind.SerializationFeature;
import tools.jackson.databind.json.JsonMapper;

import java.nio.file.Path;

public class JsonFileReader<T> implements FileReader<T> {


    private final JsonMapper mapper;
    private final Class<T> type;

    public JsonFileReader(Class<T> type) {
        this.type = type;
        this.mapper = JsonMapper.builder()
                .enable(SerializationFeature.WRAP_ROOT_VALUE)
                .enable(DeserializationFeature.UNWRAP_ROOT_VALUE)
                .build();
    }

    @Override
    public T read(Path filePath) {
        System.out.println("Leyendo el fichero " + filePath.getFileName() + "...");

        return mapper.readValue(filePath.toFile(), type);
    }
}
