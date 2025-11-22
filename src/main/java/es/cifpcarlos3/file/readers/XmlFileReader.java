package es.cifpcarlos3.file.readers;

import tools.jackson.dataformat.xml.XmlMapper;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class XmlFileReader<T> implements FileReader<T> {

    private final Class<T> type;
    private final XmlMapper xmlMapper;

    public XmlFileReader(Class<T> type, XmlMapper mapper) {
        this.type = type;
        this.xmlMapper = mapper;
    }

    @Override
    public T read(Path filePath) {
        System.out.println("Leyendo el fichero " + filePath.getFileName() + "...");

        try (InputStream inputStream = Files.newInputStream(filePath)) {
            return xmlMapper.readValue(inputStream, type);
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo fichero XML " + filePath, e);
        }
    }
}
