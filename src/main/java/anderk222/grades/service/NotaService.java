package anderk222.grades.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import anderk222.grades.entity.Nota;
import anderk222.grades.exception.ResourceNotFoundException;
import anderk222.grades.repository.NotaRepository;

@Service
public class NotaService {

    @Autowired
    private NotaRepository repository;

    public List<Nota> findAll() {

        return repository.findAll();

    }

    public Nota find(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id, "id", "nota"));

    }

    public Nota save(Nota nota) {

        return repository.save(nota);

    }

    public Nota update(Nota nota){

        return repository.save(nota);

    }

    public Nota delete(long id){

        Nota nota = this.find(id);

        repository.deleteById(id);

        return nota;

    }
    
    public int countByEstudiante(long estudianteId){

        return repository.countByAlumnoId(estudianteId);


    }
    

    public int countByMateria(Long materiaId){

        return repository.countByMateriaId(materiaId);

    }


    public List<Nota> findHightGradesByMaestro(Long maestroId, int limit){

        Sort sort = Sort.by(Sort.Direction.DESC, "nota");

        Pageable pageable = PageRequest.of(0, limit, sort);

        return this.repository.findByAlumnoMaestroId(maestroId, pageable);

    }

}