package br.com.algartelecom.adia.teste;

import java.io.IOException;
import java.util.List;

import br.com.algartelecom.adia.arquivo.Arquivo;
import br.com.algartelecom.adia.gesplan.to.ArquivoGesplanTO;
import br.com.algartelecom.adia.service.GesplanFaturamentoService;
import br.com.algartelecom.adia.util.FormataData;

public class GesplanFaturamentoTeste {
	
	public static void main(String[] args) {
		
		System.out.println("---------  Inicio ---------------");
		System.out.println("Arquivo: ODIN_302_FAT_" + FormataData.getDataHoraAtual_Americano() + ".txt"  );

		GesplanFaturamentoService gesplanService = new GesplanFaturamentoService();
		
		try {
			List<String> conteudoArquivoOrigem = Arquivo.lerArquivo("C:\\projetos\\CLOUD-2.0\\Integracoes\\Gesplan\\Repositorio\\FATURAMENTO");
			
			
			List<ArquivoGesplanTO> objetosGesplanFaturamento = gesplanService.montaListaObjetosGesplanFaturamento(conteudoArquivoOrigem);
			
			List<String> conteudoArquivoDestino = gesplanService.montaConteudoArquivoDestino(objetosGesplanFaturamento);
		
		
			System.out.println("---------  FIM ---------------");

			
			Arquivo.geraArquivo("Integracoes\\Gesplan\\Repositorio\\FATURAMENTO\\gerado-faturamento\\ODIN_302_FAT_" + FormataData.getDataHoraAtual_Americano() , conteudoArquivoDestino, ".txt");
		
		
		

		
		System.out.println("Gerado em: Integracoes\\Gesplan\\Repositorio\\FATURAMENTO\\gerado-faturamento" );
		System.out.println("---------  FIM ---------------");
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
