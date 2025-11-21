package es.cifpcarlos3.file.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import es.cifpcarlos3.models.Course;

import java.util.ArrayList;
import java.util.List;

@JsonRootName("centro")
public class CreateCourseJsonFileDto {
    @JsonProperty("cursos")
    public List<Course> courses = new ArrayList<>();
}
