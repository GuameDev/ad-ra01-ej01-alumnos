package es.cifpcarlos3.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tools.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@JsonRootName("curso")
@NoArgsConstructor
@AllArgsConstructor
@ToString(
        includeFieldNames = false,
        doNotUseGetters = true
)
public class Course implements Serializable {
    @JsonProperty("nombre")
    private String name;

    @JsonProperty("alumnos")
    @JacksonXmlElementWrapper(localName = "alumnos")
    @JacksonXmlProperty(localName = "alumno")
    private List<Student> students = new ArrayList<>();

    @Serial
    @JsonIgnore
    private static final long serialVersionUID = 1L;

    public void addStudent(Student student){
        this.students.add(student);
    }
}
