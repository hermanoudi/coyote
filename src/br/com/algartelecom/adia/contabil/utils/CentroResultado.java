package br.com.algartelecom.adia.contabil.utils;

public class CentroResultado {

	private static int tamanho = 9;
	
	public static String preencheCR(String codCentroCustos) {
		
		if (codCentroCustos.length() < tamanho){
			for (int i = 0; i < tamanho; i++) {
				codCentroCustos = "0" + codCentroCustos;
			}
		}
		
		return codCentroCustos;
	}
	
	

}
