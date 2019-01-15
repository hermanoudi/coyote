package br.com.algartelecom.adia.teste;

import java.io.IOException;

import br.com.algartelecom.adia.service.GesplanArrecadacaoService;

public class GesplanArrecadacaoTeste {
	
	public static void main(String[] args) throws IOException {
		
		GesplanArrecadacaoService gesplanArrecadacaoService = new GesplanArrecadacaoService();
		gesplanArrecadacaoService.agrupaArquivosDeArrecadacaoGerados();
		
		gesplanArrecadacaoService.geraArquivoAjustado();
		
	}


}
