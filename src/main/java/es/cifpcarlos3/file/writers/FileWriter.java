package es.cifpcarlos3.file.writers;

import java.nio.file.Path;

public interface FileWriter<T> {
    void saveFile(T data, Path filePath);
}
