package es.cifpcarlos3;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Student {
    private int id;
    private String surnames;
    private String name;
    private String city;
    private int age;
    private LocalDate registeredAt;
}
