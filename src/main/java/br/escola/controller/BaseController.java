package br.escola.controller;

import br.escola.response.BaseResponse;

public class BaseController {

	public BaseResponse errorBase = new BaseResponse();

	public BaseController() {
		errorBase.message = "Erro inesperado";
		errorBase.statusCode = 500;
	}
}