package br.com.fiap.appprodutoteste.produto.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id; 
	@Column(nullable = false)
	private String Nome; 
	private String Documento; 
	private String Endereco;
	
	public Cliente() {
		
	}
	
	public Cliente(Long id, String nome, String documento, String endereco) {
		super();
		Id = id;
		Nome = nome;
		Documento = documento;
		Endereco = endereco;
	}


	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getDocumento() {
		return Documento;
	}
	public void setDocumento(String documento) {
		Documento = documento;
	}
	public String getEndereco() {
		return Endereco;
	}
	public void setEndereco(String endereco) {
		Endereco = endereco;
	}
	
	

}
