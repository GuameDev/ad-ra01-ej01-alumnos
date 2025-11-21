package es.cifpcarlos3.models;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
public class Course implements Serializable {
    private String name;
    private List<Student> students = new ArrayList<>();

    @Serial
    private static final long serialVersionUID = 1L;

    public void addStudent(Student student){
        this.students.add(student);
    }
}
