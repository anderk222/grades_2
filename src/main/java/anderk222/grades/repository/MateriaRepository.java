package anderk222.grades.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import anderk222.grades.entity.Materia;

public interface MateriaRepository extends JpaRepository<Materia, Long> {}