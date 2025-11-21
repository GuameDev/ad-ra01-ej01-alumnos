package es.cifpcarlos3.file.writers;

import es.cifpcarlos3.file.helpers.FileHelper;

import java.io.*;
import java.nio.file.Path;

public class BinaryFileWriter<T> implements FileWriter<T> {
    @Override
    public void write(T data, Path filePath) {
        FileHelper.createIfNotExists(filePath);
        System.out.println("Escribiendo en el fichero " + filePath.getFileName() + "...");

        try (FileOutputStream fileOutputStream = new FileOutputStream(filePath.toFile());
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {

            objectOutputStream.writeObject(data);
            System.out.println("Se ha terminado de escribir en el fichero: " + filePath.getFileName());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
