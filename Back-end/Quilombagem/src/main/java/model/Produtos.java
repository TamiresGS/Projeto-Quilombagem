package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Produtos")
public class Produtos {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String fotoProduto;

	@NotBlank
	private String nomeProduto;
	
	@NotBlank
	private String descricaoProduto;

	@NotBlank
	private Double precoProduto;

	private String tamanhoDisponivel;
	
	@NotBlank
	private Integer quantidadeDisponivel;
	

	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categorias categorias;

	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Usuario empreendedor ;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Marcas marcas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFotoProduto() {
		return fotoProduto;
	}

	public void setFotoProduto(String fotoProduto) {
		this.fotoProduto = fotoProduto;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getDescricaoProduto() {
		return descricaoProduto;
	}

	public void setDescricaoProduto(String descricaoProduto) {
		this.descricaoProduto = descricaoProduto;
	}

	public Double getPrecoProduto() {
		return precoProduto;
	}

	public void setPrecoProduto(Double precoProduto) {
		this.precoProduto = precoProduto;
	}

	public String getTamanhoDisponivel() {
		return tamanhoDisponivel;
	}

	public void setTamanhoDisponivel(String tamanhoDisponivel) {
		this.tamanhoDisponivel = tamanhoDisponivel;
	}

	public Integer getQuantidadeDisponivel() {
		return quantidadeDisponivel;
	}

	public void setQuantidadeDisponivel(Integer quantidadeDisponivel) {
		this.quantidadeDisponivel = quantidadeDisponivel;
	}

	public Categorias getCategorias() {
		return categorias;
	}

	public void setCategorias(Categorias categorias) {
		this.categorias = categorias;
	}

	public Usuario getEmpreendedor() {
		return empreendedor;
	}

	public void setEmpreendedor(Usuario empreendedor) {
		this.empreendedor = empreendedor;
	}

	public Marcas getMarcas() {
		return marcas;
	}

	public void setMarcas(Marcas marcas) {
		this.marcas = marcas;
	}
	
	
	
}
	
	