package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


/**
 * @author Tamires Guimarães
 *@table Tabela com todas as Marcas Empreendedoras
 */


@Entity
@Table( name = "Marcas")
public class Marcas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Insira o nome da sua Marca")
	private String nomeMarca;
	
	@NotBlank(message = "Insira o link do logo da sua Marca")
	private String foto;
	
	@NotBlank(message = "Insira a história da sua Marca")
	private String sobreAMarca;
	
	@NotBlank(message = "Insira o Tipo de produto/serço da Marca")
	private String tipoProduto;
	
	@NotBlank(message = "Insira o link do logo da sua Marca")
	private String linkMarca;

	@OneToMany(mappedBy = "marcas", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("marcas")
	private List<Produtos> produtos;
	
	@OneToMany(mappedBy = "marcas", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("marcas")
	private List<Categorias> categorias;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

	public void setNomeMarca(String nomeMarca) {
		this.nomeMarca = nomeMarca;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getSobreAMarca() {
		return sobreAMarca;
	}

	public void setSobreAMarca(String sobreAMarca) {
		this.sobreAMarca = sobreAMarca;
	}

	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	public String getLinkMarca() {
		return linkMarca;
	}

	public void setLinkMarca(String linkMarca) {
		this.linkMarca = linkMarca;
	}

	public List<Produtos> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}

	public List<Categorias> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categorias> categorias) {
		this.categorias = categorias;
	}
	
	
}