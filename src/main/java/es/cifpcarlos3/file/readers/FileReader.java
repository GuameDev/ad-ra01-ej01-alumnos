package es.cifpcarlos3.file.readers;

import java.nio.file.Path;

public interface FileReader<T> {
    T read(Path filePath);
}
