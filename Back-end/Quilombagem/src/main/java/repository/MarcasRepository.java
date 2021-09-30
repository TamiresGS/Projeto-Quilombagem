package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.Marcas;

@Repository
public interface MarcasRepository extends JpaRepository<Marcas, Long>{
	
	public List<Marcas> findAllByNomeMarcaContainingIgnoreCase(String nomeMarca);

}
