package br.com.algartelecom.adia.util;

import java.util.regex.Pattern;

public class FormataValores {

	public static String substituiSeparadorDecimalPontoPorVirgula(String valor) {
		return valor.replaceAll(Pattern.quote("."), ",");
	}
	

}
