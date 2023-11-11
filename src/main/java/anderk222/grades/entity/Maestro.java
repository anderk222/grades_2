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

@Entity
@SQLDelete(sql = "UPDATE dbo.maestro SET deleted='true' WHERE id=?")
@Where(clause = "deleted=false")
@Data
public class Maestro {
    
    @Expose
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Expose
    @Column(nullable = false, length = 45)
    private String nombre;

    @Expose
    @Column(nullable = false, length = 45)
    private String apellido;

    @Expose
    @Column(nullable = false, length = 75)
    private String titulo;

    private boolean deleted = false;


    public String getFullName(){

        return String.format("%s %s", nombre, apellido);

    }

}
