package es.cifpcarlos3.file.writers;

import java.nio.file.Path;

public interface FileWriter<T> {
    void write(T data, Path filePath);
}
