package es.cifpcarlos3.models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Student {
    private String id;
    private String surnames;
    private String name;
    private String city;
    private int age;
    private LocalDate registeredAt;
}
