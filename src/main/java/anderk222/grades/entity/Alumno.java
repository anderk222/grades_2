package anderk222.grades.entity;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import com.google.gson.annotations.Expose;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
@SQLDelete(sql = "UPDATE dbo.alumno SET deleted='true'")
@Where(clause = "deleted=false")
public class Alumno {

    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Expose
    @Column(length = 45, nullable = false)
    private String nombre;

    @Expose
    @Column(length = 45, nullable = false)
    private String apellido;

    private boolean deleted = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "maestro_id", referencedColumnName = "id")
    private Maestro maestro;

}