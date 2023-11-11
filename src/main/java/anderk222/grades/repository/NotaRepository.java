package anderk222.grades.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import anderk222.grades.entity.Nota;

public interface NotaRepository extends JpaRepository<Nota, Long> {

    int countByAlumnoId(Long alumnoId);

    int countByMateriaId(long materiaId);

    List<Nota> findByAlumnoMaestroId(Long maestroId, Pageable pageable);


    
}