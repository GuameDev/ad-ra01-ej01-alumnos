package es.cifpcarlos3.file.readers;

import tools.jackson.databind.json.JsonMapper;

import java.nio.file.Path;

public class JsonFileReader<T> implements FileReader<T> {
    private final JsonMapper mapper;
    private final Class<T> type;

    public JsonFileReader(Class<T> type, JsonMapper mapper) {
        this.type = type;
        this.mapper = mapper;
    }

    @Override
    public T read(Path filePath) {
        System.out.println("Leyendo el fichero " + filePath.getFileName() + "...");

        return mapper.readValue(filePath.toFile(), type);
    }
}
