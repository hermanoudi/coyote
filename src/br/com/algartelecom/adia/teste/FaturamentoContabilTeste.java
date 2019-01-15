package br.com.algartelecom.adia.teste;

import java.util.List;

import br.com.algartelecom.adia.arquivo.Arquivo;
import br.com.algartelecom.adia.contabil.service.ContabilArrecadacaoPosPagoService;
import br.com.algartelecom.adia.contabil.service.ContabilArrecadacaoPrePagoService;
import br.com.algartelecom.adia.contabil.service.ContabilFaturamentoPosPagoService;
import br.com.algartelecom.adia.contabil.service.ContabilFaturamentoPrePagoService;
import br.com.algartelecom.adia.contabil.service.ContabilProvisaoService;
import br.com.algartelecom.adia.contabil.service.ContabilReversaoService;
import br.com.algartelecom.adia.util.FormataData;

public class FaturamentoContabilTeste {
	public static void main(String[] args) {
		
		String dataFaturamentoOdin = "21/05/2017";
		
		geraArquivoFaturamentoPosPago();
		geraArquivoFaturamentoPrePago();
		geraArquivoArrecadacaoPosPago();
		geraArquivoArrecadacaoPrePago();
		geraArquivoProvisao(dataFaturamentoOdin);
		geraArquivoReversao(dataFaturamentoOdin);

  }

	private static void geraArquivoReversao(String dataFaturamentoOdin) {
		
		System.out.println("-- REVERSAO - INICIO --");
		
		String ultimaDataAntesFaturamento = FormataData.getDataCorteFaturamentoComHorasFormatoAmericano(dataFaturamentoOdin);
		String dataFaturamentoFormatado = FormataData.formataDataPadraoAmericanoSemHoras(dataFaturamentoOdin);
		String ultimoDiaMesAnterior = FormataData.getUltimoDiaDoMesPassadoComBarraEHoras();
		String primeiroDiaMesAtual = FormataData.getPrimeiroDiaDoMesAtualSemBarraESemHorasFormatoAmericano();
		String dataCorteFaturamentoSemHoras = FormataData.getDataCorteFaturamentoSemHorasFormatoAmericano(dataFaturamentoOdin);
		int qtdDiasMesAnterior = Integer.parseInt(FormataData.getQtdDiasMesAnterior());
		
		try {
			ContabilReversaoService service = new ContabilReversaoService();
			
			List<String> reversaoToFile = service.getReversao(ultimaDataAntesFaturamento, dataFaturamentoFormatado, 
															  ultimoDiaMesAnterior, primeiroDiaMesAtual, dataCorteFaturamentoSemHoras,
															  qtdDiasMesAnterior);
			
			Arquivo.geraArquivo("Integracoes\\Contabil\\Repositorio\\ODIN_016_ODIN_REVERSAOPROVISAO_016" + FormataData.getDataHoraAtual_Americano(), reversaoToFile, ".dat");
			System.out.println("Arquivo: ODIN_016_ODIN_REVERSAOPROVISAO_016" + FormataData.getDataHoraAtual_Americano() + ".dat"  );
			System.out.println("Gerado em: C:\\projetos\\CLOUD-2.0\\Integracoes\\Contabil\\Repositorio" );
			System.out.println("---------  FIM ---------------");
			System.out.println();
			
		} catch (Exception e) {
			
			System.out.println("Não foi possível a gerar o arquivo PROVISAOMENSAL"  );
			System.out.println("ERROR: " + e.getMessage() );
			System.out.println("---------  ERRO ---------------");
			System.out.println();
			e.printStackTrace();
		}

		
	}

	private static void geraArquivoProvisao(String dataFaturamentoOdin) {
		System.out.println("-- PROVISAO - INICIO --");
		
		String ultimaDataAntesFaturamento = FormataData.getDataCorteFaturamentoComHorasFormatoAmericano(dataFaturamentoOdin);
		String dataFaturamentoFormatado = FormataData.formataDataPadraoAmericanoSemHoras(dataFaturamentoOdin);
		String ultimoDiaMesAnterior = FormataData.getUltimoDiaDoMesPassadoComBarraEHoras();
		String primeiroDiaMesAtual = FormataData.getPrimeiroDiaDoMesAtualSemBarraESemHorasFormatoAmericano();
		String dataCorteFaturamentoSemHoras = FormataData.getDataCorteFaturamentoSemHorasFormatoAmericano(dataFaturamentoOdin);
		int qtdDiasMesAnterior = Integer.parseInt(FormataData.getQtdDiasMesAnterior());
		
		try {
			ContabilProvisaoService service = new ContabilProvisaoService();
			
			
			
			
			List<String> provisaoToFile = service.getProvisao(ultimaDataAntesFaturamento, dataFaturamentoFormatado, 
															  ultimoDiaMesAnterior, primeiroDiaMesAtual, dataCorteFaturamentoSemHoras,
															  qtdDiasMesAnterior);
			
			Arquivo.geraArquivo("Integracoes\\Contabil\\Repositorio\\ODIN_016_ODIN_PROVISAOMENSAL_016" + FormataData.getDataHoraAtual_Americano(), provisaoToFile, ".dat");
			System.out.println("Arquivo: ODIN_016_ODIN_PROVISAOMENSAL_016" + FormataData.getDataHoraAtual_Americano() + ".dat"  );
			System.out.println("Gerado em: C:\\projetos\\CLOUD-2.0\\Integracoes\\Contabil\\Repositorio" );
			System.out.println("---------  FIM ---------------");
			System.out.println();
			
		} catch (Exception e) {
			
			System.out.println("Não foi possível a gerar o arquivo PROVISAOMENSAL"  );
			System.out.println("ERROR: " + e.getMessage() );
			System.out.println("---------  ERRO ---------------");
			System.out.println();
			e.printStackTrace();
		}
		
	}

	private static void geraArquivoArrecadacaoPrePago() {
		System.out.println("-- ARRECADACAO PRE PAGO - INICIO --");
		
		try {
			ContabilArrecadacaoPrePagoService service = new ContabilArrecadacaoPrePagoService();
			List<String> arrecadacaoToFile = service.getArrecadacaoPrePago(FormataData.getPrimeiroDiaDoMesPassadoSemBarraESemHorasFormatoAmericano(), FormataData.getPrimeiroDiaDoMesAtualSemBarraESemHorasFormatoAmericano());
			
			Arquivo.geraArquivo("Integracoes\\Contabil\\Repositorio\\ODIN_016_ODIN_ARRECADACAO_016" + FormataData.getDataHoraAtual_Americano(), arrecadacaoToFile, ".dat");
			System.out.println("Arquivo: ODIN_016_ODIN_ARRECADACAO_016" + FormataData.getDataHoraAtual_Americano() + ".dat"  );
			System.out.println("Gerado em: C:\\projetos\\CLOUD-2.0\\Integracoes\\Contabil\\Repositorio" );
			System.out.println("---------  FIM ---------------");
			System.out.println();
			
		} catch (Exception e) {
			
			System.out.println("Não foi possível a gerar o arquivo ARRECADACAO PRE PAGO"  );
			System.out.println("ERROR: " + e.getMessage() );
			System.out.println("---------  ERRO ---------------");
			System.out.println();
			e.printStackTrace();
		}
	}

	private static void geraArquivoArrecadacaoPosPago() {
		System.out.println("-- ARRECADACAO POS PAGO - INICIO --");
		
		try {
			ContabilArrecadacaoPosPagoService service = new ContabilArrecadacaoPosPagoService();
			
			List<String> arrecadacaoToFile = service.getArrecadacaoPosPago(FormataData.getPrimeiroDiaDoMesPassadoSemBarraESemHorasFormatoAmericano(), FormataData.getPrimeiroDiaDoMesAtualSemBarraESemHorasFormatoAmericano());
			
			//pegar o nome correto com o wilker
			Arquivo.geraArquivo("Integracoes\\Contabil\\Repositorio\\ODIN_016_ODIN_ARRECADACAO_016" + FormataData.getDataHoraAtual_Americano(), arrecadacaoToFile, ".dat");
			System.out.println("Arquivo: ODIN_016_ODIN_ARRECADACAO_016" + FormataData.getDataHoraAtual_Americano() + ".dat"  );
			System.out.println("Gerado em: C:\\projetos\\CLOUD-2.0\\Integracoes\\Contabil\\Repositorio" );
			System.out.println("---------  FIM ---------------");
			System.out.println();
			
		} catch (Exception e) {
			
			System.out.println("Não foi possível a gerar o arquivo ARRECADACAO POS PAGO"  );
			System.out.println("ERROR: " + e.getMessage() );
			System.out.println("---------  ERRO ---------------");
			System.out.println();
			e.printStackTrace();
		}
		
	}

	private static void geraArquivoFaturamentoPrePago() {
		System.out.println("-- FATURAMENTO PRE PAGO - INICIO --");
		
		try {
			ContabilFaturamentoPrePagoService service = new ContabilFaturamentoPrePagoService();
			
			List<String> faturasToFile = service.getFaturamentoEAjustes(FormataData.getPrimeiroDiaDoMesPassadoSemBarraESemHorasFormatoAmericano(), FormataData.getPrimeiroDiaDoMesAtualSemBarraESemHorasFormatoAmericano(),
																		FormataData.getUltimoDiaDoMesPassadoComBarraEHoras());
			
			Arquivo.geraArquivo("Integracoes\\Contabil\\Repositorio\\ODIN_016_ODIN_FATURAMENTO_016" + FormataData.getDataHoraAtual_Americano(), faturasToFile, ".dat");
			System.out.println("Arquivo: ODIN_016_ODIN_FATURAMENTO_016" + FormataData.getDataHoraAtual_Americano() + ".dat"  );
			System.out.println("Gerado em: C:\\projetos\\CLOUD-2.0\\Integracoes\\Contabil\\Repositorio" );
			System.out.println("---------  FIM ---------------");
			System.out.println();
			
		} catch (Exception e) {
			
			System.out.println("Não foi possível a gerar o arquivo FATURAMENTO PRE PAGO"  );
			System.out.println("ERROR: " + e.getMessage() );
			System.out.println("---------  ERRO ---------------");
			System.out.println();
			e.printStackTrace();
		}
		
	}

	private static void geraArquivoFaturamentoPosPago() {
		System.out.println("-- FATURAMENTO POS PAGO - INICIO --");
		
		try {
			ContabilFaturamentoPosPagoService service = new ContabilFaturamentoPosPagoService();
			
			List<String> faturasToFile;
				faturasToFile = service.getFaturamentoEAjustes(FormataData.getPrimeiroDiaDoMesPassadoSemBarraESemHorasFormatoAmericano(), FormataData.getPrimeiroDiaDoMesAtualSemBarraESemHorasFormatoAmericano());
			
			Arquivo.geraArquivo("Integracoes\\Contabil\\Repositorio\\ODIN_016_ODIN_FATURAMENTO_016" + FormataData.getDataHoraAtual_Americano(), faturasToFile, ".dat");
			System.out.println("Arquivo: ODIN_016_ODIN_FATURAMENTO_016" + FormataData.getDataHoraAtual_Americano() + ".dat"  );
			System.out.println("Gerado em: C:\\projetos\\CLOUD-2.0\\Integracoes\\Contabil\\Repositorio" );
			System.out.println("---------  FIM ---------------");
			System.out.println();
			
		} catch (Exception e) {
			
			System.out.println("Não foi possível a gerar o arquivo FATURAMENTO POS PAGO"  );
			System.out.println("ERROR: " + e.getMessage() );
			System.out.println("---------  ERRO ---------------");
			e.printStackTrace();
		}
	}

}
