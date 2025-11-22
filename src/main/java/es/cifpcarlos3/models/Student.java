package es.cifpcarlos3.models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(
        includeFieldNames = false,
        doNotUseGetters = true
)
public class Student implements Serializable {

    @JsonProperty(value = "id")
    private int id;

    @JsonProperty(value = "apellidos")
    private String surnames;

    @JsonProperty(value = "nombre")
    private String name;

    @JsonProperty(value = "ciudad")
    private String city;

    @JsonProperty(value = "edad")
    private int age;

    @JsonProperty(value = "fechaRegistro")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate registeredAt;

    @Serial
    @JsonIgnore
    private static final long serialVersionUID = 1L;
}
