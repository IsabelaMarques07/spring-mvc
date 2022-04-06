package br.com.fiap.appprodutoteste.produto.dto;

public class ClienteDTO {
	private Long Id; 
	private String Nome; 
	private String Documento; 
	private String Endereco;

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
