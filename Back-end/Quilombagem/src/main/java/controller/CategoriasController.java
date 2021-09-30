package controller;

import java.util.List;

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

import model.Categorias;
import repository.CategoriasRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin("*")
public class CategoriasController {

	@Autowired
	private CategoriasRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Categorias>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Categorias> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id).get());
	}
	
	@GetMapping("/tipoProduto/{tipoProduto}")
	public ResponseEntity<List<Categorias>> buscarPorTipoProduto(@PathVariable String tipoProduto) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAllByTipoProdutoContainingIgnoreCase(tipoProduto));
	}

	@PostMapping("/salvar")
	public ResponseEntity<Categorias> salvarCategoria(@Valid @RequestBody Categorias categorias) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categorias));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Categorias> atualizarCategorias(@Valid @RequestBody Categorias categorias) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(categorias));
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}	
}
