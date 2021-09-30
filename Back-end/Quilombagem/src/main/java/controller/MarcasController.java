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

import model.Marcas;
import repository.MarcasRepository;

@RestController
@RequestMapping("/marcas")
@CrossOrigin("*")
public class MarcasController {

	@Autowired
	private MarcasRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Marcas>> GetAll() {
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Marcas> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findById(id).get());
	}
	
	@GetMapping("/tipoProduto/{tipoProduto}")
	public ResponseEntity<List<Marcas>> buscarPorTipoProduto(@PathVariable String descricao) {
		return ResponseEntity.status(HttpStatus.OK).body(repository.findAllByNomeMarcaContainingIgnoreCase(descricao));
	}
	
	@PostMapping("/salvar")
	public ResponseEntity<Marcas> salvarCategoria(@Valid @RequestBody Marcas marcas) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(marcas));
	}
	
	@PutMapping("/atualizar")
	public ResponseEntity<Marcas> atualizarMarcas(@Valid @RequestBody Marcas marcas) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(marcas));
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	}	
}


