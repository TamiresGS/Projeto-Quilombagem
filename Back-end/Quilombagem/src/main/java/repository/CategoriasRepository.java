package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Categorias;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long> {

	public List<Categorias> findAllByTipoProdutoContainingIgnoreCase(String tipoProduto);

}
