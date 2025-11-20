package es.cifpcarlos3;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Course {
    private String name;
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student){
        this.students.add(student);
    }
}
