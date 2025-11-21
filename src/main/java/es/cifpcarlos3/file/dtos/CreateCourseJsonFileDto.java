package es.cifpcarlos3.file.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import es.cifpcarlos3.models.Course;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@JsonRootName("centro")
@NoArgsConstructor
@AllArgsConstructor
@ToString(
        includeFieldNames = false,
        doNotUseGetters = true
)
public class CreateCourseJsonFileDto {
    @JsonProperty("cursos")
    public List<Course> courses = new ArrayList<>();
}
