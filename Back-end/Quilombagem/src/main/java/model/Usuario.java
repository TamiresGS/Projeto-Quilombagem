package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Digite seu nome completo")
	private String nomeCompleto;
	
	@Email(message = "Obrigatório email, digite seu email")
	private String email;
	
	@NotBlank
	private String senha;
	
	@NotBlank (message = "Obrigatório um tipo de usuario, escolha tipo de usuario")
	private String tipoUsuario;

	@OneToMany(mappedBy = "empreendedor", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("empreendedor")
	private List<Produtos> produtos;

	public Usuario() {
		super();
	}

	public Usuario(Long id, String nomeCompleto, String senha, String email, String tipoUsuario) {
		super();
		this.id = id;
		this.nomeCompleto = nomeCompleto;
		this.senha = senha;
		this.email = email;
		this.tipoUsuario = tipoUsuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeCompleto() {
		return nomeCompleto;
	}

	public void setNomeCompleto(String nomeCompleto) {
		this.nomeCompleto = nomeCompleto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public List<Produtos> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produtos> produtos) {
		this.produtos = produtos;
	}

	
}