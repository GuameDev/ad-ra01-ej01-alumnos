package es.cifpcarlos3.file.readers;

import java.io.*;
import java.nio.file.Path;
public class BinaryFileReader<T> implements FileReader<T> {


    private final Class<T> type;

    public BinaryFileReader(Class<T> type) {
        this.type = type;
    }

    @Override
    public T read(Path filePath) {
        System.out.println("Leyendo el fichero " + filePath.getFileName() + "...");

        try (FileInputStream fileInputStream = new FileInputStream(filePath.toFile());
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {

            var data = objectInputStream.readObject();
            return type.cast(data);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException("Error leyendo fichero binario " + filePath, e);
        }
    }
}
