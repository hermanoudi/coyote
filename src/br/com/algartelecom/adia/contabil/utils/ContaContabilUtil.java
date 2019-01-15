package br.com.algartelecom.adia.contabil.utils;

public class ContaContabilUtil {

	public static boolean comecadoPor1ou2(String contaContabil) {

		if(contaContabil.startsWith("1") || contaContabil.startsWith("2")){
			return true;
		} else {
			return false;
		}
	}
	

}
