package es.cifpcarlos3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonRootName("curso")
public class Course implements Serializable {
    @JsonProperty("nombre")
    private String name;

    @JsonProperty("alumnos")
    private List<Student> students = new ArrayList<>();

    @Serial
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    public void addStudent(Student student){
        this.students.add(student);
    }
}
