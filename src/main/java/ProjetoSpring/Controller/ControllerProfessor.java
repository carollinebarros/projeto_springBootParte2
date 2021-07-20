package ProjetoSpring.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ProjetoSpring.Controller.model.Professor;
import ProjetoSpring.Controller.model.Repository.ProfessorRepository;

@RestController
@RequestMapping("/professor")
public class ControllerProfessor {


	@Autowired
	private ProfessorRepository professorRepository;

	@PostMapping("/publicar")
	public Professor publicar(@RequestBody Professor professor) {
		return professorRepository.save(professor);
	}

	@GetMapping("/visualizar")
	public List<Professor> visualizar() {
		return this.professorRepository.findAll();
	}

	@GetMapping("/procurar/{cpf}")
	public Optional<Professor> procurar(@PathVariable("cpf") String cpf) {
		return professorRepository.findById(cpf);
	}

	@PutMapping("/atualizar/{cpf}")
	public String atualizar(@PathVariable("cpf") String cpf, @RequestBody Professor newProfessor) {
		Optional<Professor> oldProfessor = this.professorRepository.findById(cpf);
		if (oldProfessor.isPresent()) {
			Professor professor = oldProfessor.get();
			professor.setNome(newProfessor.getNome());
			professor.setCpf(newProfessor.getCpf());
			professor.setIdade(newProfessor.getIdade());
			professor.setSalario(newProfessor.getSalario());
			professorRepository.save(professor);
			return "Professor alterado com sucesso!";
		} else {
			return "Professor não cadastrado!";
		}

	}

	@DeleteMapping("/remover/{cpf}")
	public String remover(@PathVariable("cpf") String cpf) {
		Optional<Professor> professorFind = professorRepository.findById(cpf);
		if (professorFind.isPresent()) {
			professorRepository.delete(professorFind.get());
			return "-- Professor excluído com sucesso! --";
		} else {
			return "-- Professor não cadastrado! --";

		}
	}
}