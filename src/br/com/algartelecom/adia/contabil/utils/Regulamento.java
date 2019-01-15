package br.com.algartelecom.adia.contabil.utils;


public class Regulamento {
	
	public static String identificaRegulamento(String contaContabil){
		
		if (ContaContabilUtil.comecadoPor1ou2(contaContabil)){
			return "000";
		}
		
		else{
			return "001";
		}
	}

}
