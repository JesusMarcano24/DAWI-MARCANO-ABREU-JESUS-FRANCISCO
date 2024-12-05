package pe.edu.cibertec.DAWI_MARCANO_ABREU_JESUS_FRANCISCO.entity;

import jakarta.persistence.Embeddable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@EqualsAndHashCode
@Embeddable
public class FilmCategoryId implements Serializable {

    private Integer filmId;
    private Integer categoryId;
}
