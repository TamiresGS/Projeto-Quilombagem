package service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Categorias;
import model.Produtos;
import repository.CategoriasRepository;
import repository.ProdutosRepository;
import repository.UsuarioRepository;

@Service
public class ProdutosService {

	@Autowired
	private  ProdutosRepository repositoryProdutos;
	
	 @Autowired
	private UsuarioRepository repositoryUsuario;
	 
	 @Autowired
	private  CategoriasRepository repositoryCatagorias;
	 
	 /**
		 * Método utilizado para cadastrar um produto novo no banco validando se o
		 * usuario criador é existente. Id do usuario criador e o id do categoria deve
		 * ser passado dentro do objeto produto para que a criação seja efetuada. Caso
		 * id do usuario ou tema não for passado retona um Optiona.empty()
		 * 
		 * @param novoProduto do tipo Produto
		 * @return Optional com Produto
		 */
	 
	 public Optional<?> cadastrarProduto(Produtos novoProduto) {
			Optional<Categorias> objetoExistente = repositoryCatagorias.findById(novoProduto.getCategorias().getId());
			return repositoryUsuario.findById(novoProduto.getEmpreendedor().getId()).map(usuarioExistente -> {
				if (objetoExistente.isPresent()) {
					novoProduto.setEmpreendedor(usuarioExistente);
					novoProduto.setCategorias(objetoExistente.get());
					return Optional.ofNullable(repositoryProdutos.save(novoProduto));
				} else {
					return Optional.empty();
				}
			}).orElseGet(() -> {
				return Optional.empty();
			});
		}

}

