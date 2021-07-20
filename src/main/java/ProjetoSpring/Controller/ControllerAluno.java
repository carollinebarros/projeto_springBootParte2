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

import ProjetoSpring.Controller.model.Aluno;
import ProjetoSpring.Controller.model.Repository.AlunoRepository;

@RestController
@RequestMapping("/aluno")
public class ControllerAluno {


	@Autowired
	private AlunoRepository alunoRepository;

	@PostMapping("/publicar")
	public Aluno publicar(@RequestBody Aluno aluno) {
		return alunoRepository.save(aluno);
	}

	@GetMapping("/visualizar")
	public List<Aluno> visualizar() {
		return this.alunoRepository.findAll();
	}

	@GetMapping("/procurar/{cpf}")
	public Optional<Aluno> procurar(@PathVariable("cpf") String cpf) {
		return alunoRepository.findById(cpf);
	}

	@PutMapping("/atualizar/{cpf}")
	public String atualizar(@PathVariable("cpf") String cpf, @RequestBody Aluno newAluno) {
		Optional<Aluno> oldAluno = this.alunoRepository.findById(cpf);
		if (oldAluno.isPresent()) {
			Aluno aluno = oldAluno.get();
			aluno.setNome(newAluno.getNome());
			aluno.setCpf(newAluno.getCpf());
			aluno.setIdade(newAluno.getIdade());
			aluno.setCodigocurso(newAluno.getCodigocurso());
			aluno.setNomecurso(newAluno.getNomecurso());
			alunoRepository.save(aluno);
			return "Aluno alterado com sucesso!";
		} else {
			return "Aluno não cadastrado!";
		}

	}

	@DeleteMapping("/remover/{cpf}")
	public String remover(@PathVariable("cpf") String cpf) {
		Optional<Aluno> alunoFind = alunoRepository.findById(cpf);
		if (alunoFind.isPresent()) {
			alunoRepository.delete(alunoFind.get());
			return "-- Aluno excluído com sucesso! --";
		} else {
			return "-- Aluno não cadastrado! --";

		}
	}
}