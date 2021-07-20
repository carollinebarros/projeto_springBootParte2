package ProjetoSpring.Controller.model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjetoSpring.Controller.model.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, String>{

}
