package br.com.algartelecom.adia.util;

public class CentroDeResultado {
	
	public static String substituiCREmBrancoPorCRdeUberlandia(String cr){
		if (cr == null || cr.equals("") || cr.equals("00")){
			return "42";
		} else {
			return cr;
		}
	}

}
