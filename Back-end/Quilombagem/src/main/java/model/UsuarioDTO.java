package model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UsuarioDTO {

	private Long id;
	
	private String nomeCompleto;
	
	@Email(message = "Obrigatório email, digite seu email")
	private String email;
	
	@NotBlank(message = "Obrigatório senha, digite seu senhal")
	private String senha;
	
	private String tipoUsuario;

	private String token;

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

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	
}
