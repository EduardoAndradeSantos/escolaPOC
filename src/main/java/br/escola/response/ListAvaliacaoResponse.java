package br.escola.response;

import java.util.List;

import br.escola.model.Avaliacao;

public class ListAvaliacaoResponse extends BaseResponse{

	List<Avaliacao> avaliacoes;

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}

}
