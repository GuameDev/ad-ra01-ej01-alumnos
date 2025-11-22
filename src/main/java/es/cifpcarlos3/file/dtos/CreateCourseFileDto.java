package es.cifpcarlos3.file.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import es.cifpcarlos3.models.Course;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import tools.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import tools.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@JsonRootName("centro")
@NoArgsConstructor
@AllArgsConstructor
@ToString(
        includeFieldNames = false,
        doNotUseGetters = true
)
public class CreateCourseFileDto implements Serializable {
    @JsonProperty("cursos")
    @JacksonXmlElementWrapper(localName = "cursos")
    @JacksonXmlProperty(localName = "curso")
    public List<Course> courses = new ArrayList<>();
}
