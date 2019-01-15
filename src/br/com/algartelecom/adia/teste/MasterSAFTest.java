package br.com.algartelecom.adia.teste;

import br.com.algartelecom.adia.service.MastersafService;
import br.com.algartelecom.adia.util.FormataData;

public class MasterSAFTest {
	
	public static void main(String[] args) {
		
		//TODO: Ajustar para pegar da tela
		String dataFaturamento = FormataData.getVencimentoOficialFaturasPosPago("21/05/2017");
		
		try{
			geraArquivoServicos();
			geraArquivoCISS();
			geraArquivoMestre();
			geraArquivoItem();
			geraArquivoCliFornecTransp();
			geraArquivoDAuxiliarClienteFaturamento(dataFaturamento);
			geraArquivoDAuxiliarClienteArrecadacao(dataFaturamento);
		} catch(Exception e){
			System.out.println("ERRO AO tentar gerar arquivos do Mastersaf" );
			System.out.println("ERRO: " + e.getMessage());
			e.printStackTrace();
		}
		
	}
	
	private static void geraArquivoDAuxiliarClienteArrecadacao(String dataFaturamento) throws Exception {
		
		System.out.println("---------  Inicio ---------------");
		System.out.println("Arquivo: ODIN_BILLING_D_AUXILIAR_CLIENTE_" + FormataData.getDataHoraAtual_Americano() + ".txt"  );
		
		MastersafService mastersafService = new MastersafService();
		mastersafService.getDAuxiliarClienteArrecadacao(dataFaturamento, FormataData.getMesAnoAnteriorComBarra(), FormataData.getPrimeiroDiaDoMesPassadoSemBarraESemHorasFormatoAmericano(), FormataData.getUltimoDiaDoMesPassadoComBarraEHoras());
		
		System.out.println("Gerado em: C:\\projetos\\CLOUD-2.0\\mastersaf" );
		System.out.println("---------  FIM ---------------");
		System.out.println();
	}

	private static void geraArquivoDAuxiliarClienteFaturamento(String dataFaturamento) throws Exception {

		
		System.out.println("---------  Inicio ---------------");
		System.out.println("Arquivo: ODIN_BILLING_D_AUXILIAR_CLIENTE_" + FormataData.getDataHoraAtual_Americano() + ".txt"  );

		MastersafService mastersafService = new MastersafService();
		
		mastersafService.getDAuxiliarClienteFaturamento(dataFaturamento, FormataData.getMesAnoAnteriorComBarra(), FormataData.getMesAnoAnteriorSemBarra(),
														FormataData.getPrimeiroDiaDoMesPassadoSemBarraESemHorasFormatoAmericano(), 
														FormataData.getUltimoDiaDoMesPassadoComBarraEHoras());
		
		System.out.println("Gerado em: C:\\projetos\\CLOUD-2.0\\mastersaf" );
		System.out.println("---------  FIM ---------------");
		System.out.println();
		
	}

	private static void geraArquivoCliFornecTransp() throws Exception {
		
		System.out.println("---------  Inicio ---------------");
		System.out.println("Arquivo: ODIN_BILLING_CLI_FORNEC_TRANSP_" + FormataData.getDataHoraAtual_Americano() + ".txt"  );

		MastersafService mastersafService = new MastersafService();
		mastersafService.getCliFornecTransp(FormataData.getMesAnoAnteriorSemBarra());
		
		System.out.println("Gerado em: C:\\projetos\\CLOUD-2.0\\mastersaf" );
		System.out.println("---------  FIM ---------------");
		System.out.println();
		
	}

	private static void geraArquivoServicos() throws Exception{
		
		System.out.println("---------  Inicio ---------------");
		System.out.println("Arquivo: ODIN_BILLING_SERVICO_" + FormataData.getDataHoraAtual_Americano() + ".txt"  );
		
		MastersafService mastersafService = new MastersafService();
		mastersafService.getFileService(FormataData.getMesAnoAnteriorSemBarra());
		
		System.out.println("Gerado em: C:\\projetos\\CLOUD-2.0\\mastersaf" );
		System.out.println("---------  FIM ---------------");
		System.out.println();
		
	}
	
	private static void geraArquivoCISS() throws Exception{
		
		System.out.println("---------  Inicio ---------------");
		System.out.println("Arquivo: ODIN_BILLING_CISS_" + FormataData.getDataHoraAtual_Americano() + ".txt"  );
		
		MastersafService mastersafService = new MastersafService();
		mastersafService.getCiss(FormataData.getMesAnoAnteriorSemBarra());
		
		System.out.println("Gerado em: C:\\projetos\\CLOUD-2.0\\mastersaf" );
		System.out.println("---------  FIM ---------------");
		System.out.println();
	}
	
	private static void geraArquivoMestre() throws Exception{
		
		System.out.println("---------  Inicio ---------------");
		System.out.println("Arquivo: ODIN_BILLING_MESTRE_NFSD_SERV_" + FormataData.getDataHoraAtual_Americano() + ".txt"  );
		
		MastersafService mastersafService = new MastersafService();
		mastersafService.getMestreNFSD(FormataData.getMesAnoAnteriorSemBarra());
		
		System.out.println("Gerado em: C:\\projetos\\CLOUD-2.0\\mastersaf" );
		System.out.println("---------  FIM ---------------");
		System.out.println();
				
	}
	
	private static void geraArquivoItem(){
		
		System.out.println("---------  Inicio ---------------");
		System.out.println("Arquivo: ODIN_BILLING_ITEM_NFSD_SERV_" + FormataData.getDataHoraAtual_Americano() + ".txt"  );
		try{
			MastersafService mastersafService = new MastersafService();
			mastersafService.getItemNFSD(FormataData.getMesAnoAnteriorSemBarra());
		
			System.out.println("Gerado em: C:\\projetos\\CLOUD-2.0\\mastersaf" );
			System.out.println("---------  FIM ---------------");
			System.out.println();
		} catch (Exception e){
			System.out.println("Não foi possível gerar o arquivo de Item, pois a query buscou dados nulos ou em branco " );
			System.out.println("ERROR: " + e.getMessage());
		}
	}
	
	

}
