package br.com.algartelecom.adia.util;

public class MontaCamposArquivosPosicionais {
	
	public static String preencherCampo(String campo, int tamanho, boolean zerosAEsquerda) throws Exception {
		
		if (campo == null){
			campo = "";
		} 
		
		if (campo.length() < tamanho){
			int diferencaTamanho = tamanho - campo.length();
			
			if (zerosAEsquerda){
				String zeros = "";
				for (int i=0; i < diferencaTamanho; i++){
					zeros = zeros + "0";
				}
				campo = zeros + campo;
			} else{
				String preenchimento = "";
				for (int i =0; i < diferencaTamanho; i++){
					preenchimento = preenchimento + " ";
				}
				campo = campo + preenchimento;
			}
			
		
		} else if(campo.length() > tamanho){
			campo = campo.substring(0,tamanho);
		}
		return campo;
	}

}
