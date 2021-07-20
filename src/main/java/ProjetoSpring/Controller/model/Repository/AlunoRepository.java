package ProjetoSpring.Controller.model.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ProjetoSpring.Controller.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, String>{

}