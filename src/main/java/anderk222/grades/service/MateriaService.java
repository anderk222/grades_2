package anderk222.grades.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import anderk222.grades.entity.Materia;
import anderk222.grades.exception.ResourceNotFoundException;
import anderk222.grades.repository.MateriaRepository;

@Service
public class MateriaService {

    @Autowired
    private MateriaRepository repository;

    public List<Materia> findAll() {

        return repository.findAll();

    }

    public Materia find(Long id) {

        return repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id, "id", "materia"));

    }

    public Materia save(Materia materia) {

        return repository.save(materia);

    }

    public Materia update(Materia materia){

        return repository.save(materia);

    }

    public Materia delete(long id){

        Materia materia = this.find(id);

        repository.deleteById(id);

        return materia;

    }

}