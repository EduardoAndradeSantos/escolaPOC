package br.escola.response;

public class AlunoResponse extends BaseResponse {
	private Long id;
	private String nome;
	private Double av1;
	private Double av2;
	private String situacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getAv1() {
		return av1;
	}

	public void setAv1(Double av1) {
		this.av1 = av1;
	}

	public Double getAv2() {
		return av2;
	}

	public void setAv2(Double av2) {
		this.av2 = av2;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}
