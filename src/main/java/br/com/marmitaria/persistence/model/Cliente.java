package br.com.marmitaria.persistence.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


import br.com.marmitaria.rest.request.ClienteRequest;

@Entity
@Table(name = "CLIENTE")
public class Cliente extends Usuario{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7902429925373569513L;

	
	@Column(name = "ENDERECO")
	@NotNull
	private String endereco;
	
	@Column(name = "TELEFONE")
	private String telefone;
	
	
	
	public Cliente(ClienteRequest request) {
		setNome(request.getNome());
		setEmail(request.getEmail());
		setSenha(request.getSenha());
		setTipo(Tipo.CLIENTE);
		setCadastroPendente(true);
		this.endereco = request.getEndereco();
		this.telefone = request.getTelefone();
	}
	
	public Cliente() {
		
	}

	public String getEndereco() {
		return endereco;
	}
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((endereco == null) ? 0 : endereco.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
		return true;
	}

	

}
