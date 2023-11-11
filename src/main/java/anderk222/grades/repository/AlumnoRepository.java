package anderk222.grades.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import anderk222.grades.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {
    
    List<Alumno> findByNombreAndApellido(String nombre, String apellido);

    int countByMaestroId(Long mestroId);

}