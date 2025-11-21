package es.cifpcarlos3.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Student implements Serializable {
    private String id;
    private String surnames;
    private String name;
    private String city;
    private int age;
    private LocalDate registeredAt;

    @Serial
    private static final long serialVersionUID = 1L;
}
