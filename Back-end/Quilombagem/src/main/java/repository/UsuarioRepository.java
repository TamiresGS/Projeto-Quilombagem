package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	/**** Metodo utilizado para selecionar apenas um Usuario pelo email (Chave unica)
	*** Metodo utilizado para pesquisar coluna nomeCompleto da tabela Usuario
	
	 * @author Tamires Guimarães*/
	
	Optional<Usuario> findByEmail(String email);

	List<Usuario> findAllByNomeCompletoContainingIgnoreCase(String nomeCompleto);

	
}

