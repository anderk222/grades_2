package anderk222.grades.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.google.gson.annotations.Expose;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
@SQLDelete(sql="UPDATE dbo.materia SET deleted='true' WHERE id=?")
@Where(clause="deleted=false")
public class Materia {
    
    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Expose
    @Column(length = 45, nullable = false)
    private String descripcion;

    @Expose
    @Column(length = 45)
    private String puntos;

    private boolean deleted =false;

}
