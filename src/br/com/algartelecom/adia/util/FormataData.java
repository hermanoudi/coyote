package br.com.algartelecom.adia.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class FormataData {
	
	private static DateFormat yyyyMMddkkmmss = new SimpleDateFormat("yyyyMMddkkmmss", new Locale("pt", "BR"));
	private static DateFormat yyyyMMddkkmm = new SimpleDateFormat("yyyyMMddkkmm", new Locale("pt", "BR"));
	private static DateFormat MMyyyy = new SimpleDateFormat("MMyyyy", new Locale("pt", "BR"));
	private static DateFormat yyyy = new SimpleDateFormat("yyyy", new Locale("pt", "BR"));
	private static DateFormat ddMMyyyy = new SimpleDateFormat("ddMMyyyy", new Locale("pt", "BR"));
	private static DateFormat hifen_dd_MM_yyyy = new SimpleDateFormat("dd-MM-yyyy", new Locale("pt", "BR"));
	private static DateFormat barra_dd_MM_yyyy = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));
	private static DateFormat barra_ddMMyyyykkmmss = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss", new Locale("pt", "BR"));
	
	
	public static String getDataHoraAtual_Americano(){
		Calendar cal = Calendar.getInstance();
		
		return  yyyyMMddkkmmss.format(cal.getTime());
	}
	
	public static String getDataHoraAtualSemSegundos_Americano(){
		Calendar cal = Calendar.getInstance();
		
		return  yyyyMMddkkmm.format(cal.getTime());
	}
	
	public static String getDataHoraAtual(){
		Calendar cal = Calendar.getInstance();
		
		return  barra_ddMMyyyykkmmss.format(cal.getTime());
	}
	
	public static String getDataAtual(){
		Calendar cal = Calendar.getInstance();
		
		return  barra_dd_MM_yyyy.format(cal.getTime());
	}
	
	public static String formataDataPadraoBrasilSemHoras(Date dataIn){
		return new SimpleDateFormat("dd/MM/yyyy").format(dataIn);
	}
	
	public static String formataDataAtualPadraoBrasilSemHoras(){
		LocalDate hoje = LocalDate.now();
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return hoje.format(formatador);
	}
	
	public static String getMesAnoAnteriorEmExtensoComPrimeiraLetraMaiuscula(){
		
		LocalDate hoje = LocalDate.now();
		LocalDate mes = hoje.minusMonths(1L);
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("MMM-yyyy");
		String mesAnterior = mes.format(formatador);
		
		return mesAnterior.substring(0,1).toUpperCase() + mesAnterior.substring(1).toLowerCase();
	}
	
	/**
	 * Retorna no Formato MMyyyy
	 * 
	 * @return
	 */
	public static String getMesAnoAnteriorSemBarra(){
		
		LocalDate hoje = LocalDate.now();
		LocalDate mes = hoje.minusMonths(1L);
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("MMyyyy");
		return mes.format(formatador);
		
	}
	
	/**
	 * Retorna no Formato MM/yyyy
	 * 
	 * @return
	 */
	public static String getMesAnoAnteriorComBarra(){
		
		LocalDate hoje = LocalDate.now();
		LocalDate mes = hoje.minusMonths(1L);
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("MM/yyyy");
		return mes.format(formatador);
		
	}
	
	public static String getPrimeiroDiaDoMesPassadoSemBarraESemHorasFormatoAmericano(){
		
		Calendar c = Calendar.getInstance();
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		d = c.getTime();
		
		c.add(Calendar.MONTH, -1);
		d = c.getTime();
		
		c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
		d = c.getTime();
		
		return sdf.format(d);

	}
	
	public static String getPrimeiroDiaDoMesAtualSemBarraESemHorasFormatoAmericano(){
		
		Calendar c = Calendar.getInstance();
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		d = c.getTime();
		
//		c.add(Calendar.MONTH, -1);
//		d = c.getTime();
		
		c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
		d = c.getTime();
		
		return sdf.format(d);

	}
	
	public static String getUltimoDiaDoMesPassadoComBarraEHoras(){
		
		Calendar c = Calendar.getInstance();
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		d = c.getTime();
		
		c.add(Calendar.MONTH, -1);
		d = c.getTime();
	
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		d = c.getTime();
		return sdf.format(d) + "235959";
	}
	
	
	
	public static String getVencimentoOficialFaturasPosPago(String dataFaturamento){
		
		DateTimeFormatter formatoDataFaturamento = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatoDataVencimento = DateTimeFormatter.ofPattern("ddMMyyyy");
		
		LocalDate faturamento = LocalDate.parse(dataFaturamento, formatoDataFaturamento);
		LocalDate vencimentoFaturas = faturamento.plusDays(18L);
		
		return vencimentoFaturas.format(formatoDataVencimento);
	}

	public static String getDataCorteFaturamentoComHorasFormatoAmericano(String dataFaturamentoOdin) {
		
		DateTimeFormatter formatoDataFaturamento = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatoDataCorte = DateTimeFormatter.ofPattern("yyyyMMdd");
		
		LocalDate faturamento = LocalDate.parse(dataFaturamentoOdin, formatoDataFaturamento);
		LocalDate dataCorte = faturamento.minusDays(1L);
		
		String dataCorteHoras = dataCorte.format(formatoDataCorte) + "235959";
		return dataCorteHoras;
	}
	
	public static String getDataCorteFaturamentoSemHorasFormatoAmericano(String dataFaturamentoOdin) {
		
		DateTimeFormatter formatoDataFaturamento = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatoDataCorte = DateTimeFormatter.ofPattern("yyyyMMdd");
		
		LocalDate faturamento = LocalDate.parse(dataFaturamentoOdin, formatoDataFaturamento);
		LocalDate dataCorte = faturamento.minusDays(1L);
		
		String dataCorteHoras = dataCorte.format(formatoDataCorte);
		return dataCorteHoras;
	}

	public static String formataDataPadraoAmericanoSemHoras(String dataFaturamentoOdin) {
		
		DateTimeFormatter formatoDataBrasil = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter formatoDataFaturamentoAmericano = DateTimeFormatter.ofPattern("yyyyMMdd");
		
		LocalDate faturamentoBrasil = LocalDate.parse(dataFaturamentoOdin, formatoDataBrasil);
		
		return faturamentoBrasil.format(formatoDataFaturamentoAmericano);
	}

	public static String getQtdDiasMesAnterior() {
		
		Calendar c = Calendar.getInstance();
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		d = c.getTime();
		
		c.add(Calendar.MONTH, -1);
		d = c.getTime();
	
		c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
		d = c.getTime();
		return sdf.format(d);
	}

}
