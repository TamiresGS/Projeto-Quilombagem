package controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.Produtos;
import repository.ProdutosRepository;

@RestController
@RequestMapping("/produto")
@CrossOrigin("*")
public class ProdutosController {

	
	@Autowired
	private ProdutosRepository repository;
	
	
	@GetMapping
	public ResponseEntity<List<Produtos>> buscarTodosProdutos() {
		List<Produtos> listaProdutos = repository.findAll();

		if (listaProdutos.isEmpty()) {
			return ResponseEntity.status(204).build();
		} else {
			return ResponseEntity.status(200).body(listaProdutos);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produtos> bucarPorId(@PathVariable(value = "id") Long id) {
		Optional<Produtos> objetoOptional = repository.findById(id);

		if (objetoOptional.isPresent()) {
			return ResponseEntity.status(200).body(objetoOptional.get());
		} else {
			return ResponseEntity.status(204).build();
		}
	}

	@GetMapping("/nomeProduto/{nomeProduto}")
	public ResponseEntity<List<Produtos>> buscarPorNome(@PathVariable String nome) {
		return ResponseEntity.ok(repository.findAllByNomeProdutoContainingIgnoreCase(nome));
	}
	

	@PostMapping
	public ResponseEntity<Produtos> post (@RequestBody Produtos produto){
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
	}

	
	@PutMapping("/atualizar")
	public ResponseEntity<Produtos> AtualizarProduto(@Valid @RequestBody Produtos produtos) {
		Optional<Produtos> objetoOptional = repository.findById(produtos.getId());

		if (objetoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produtos));
		} else {
			return ResponseEntity.status(400).build();
		}
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}	

}
