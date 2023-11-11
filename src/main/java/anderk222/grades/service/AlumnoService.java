package anderk222.grades.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anderk222.grades.entity.Alumno;
import anderk222.grades.exception.ResourceNotFoundException;
import anderk222.grades.repository.AlumnoRepository;

@Service
public class AlumnoService {

    @Autowired
    private AlumnoRepository repository;

    public List<Alumno> findAll() {

        return repository.findAll();

    }

    public Alumno find(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id, "id", "alumno"));

    }

    public Alumno save(Alumno alumno) {

        return repository.save(alumno);

    }

    public Alumno update(Alumno alumno){

        return repository.save(alumno);

    }

    public Alumno delete(long id){

        Alumno alumno = this.find(id);

        repository.deleteById(id);

        return alumno;

    }


    public int countByMaestro(long maestroId){

        return repository.countByMaestroId(maestroId);

    }

}