package dominio;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Pessoa implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	//@Column(name = "nomecompleto")
	private String nome;
	private String emaill;
	
	public Pessoa() {
		
	}

	public Pessoa(Integer id, String nome, String emaill) {
		super();
		this.id = id;
		this.nome = nome;
		this.emaill = emaill;
	}

	@Override
	public String toString() {
		return "pessoa [id=" + id + ", nome=" + nome + ", emaill=" + emaill + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmaill() {
		return emaill;
	}

	public void setEmaill(String emaill) {
		this.emaill = emaill;
	}
}
