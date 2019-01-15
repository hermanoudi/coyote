package br.com.algartelecom.adia.service;

import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.arquivo.Arquivo;
import br.com.algartelecom.adia.mastersaf.dao.Ciss_MastersafDAO;
import br.com.algartelecom.adia.mastersaf.dao.CliFornecTransp_MastersafDAO;
import br.com.algartelecom.adia.mastersaf.dao.DAuxiliar_Cliente_ArrDAO;
import br.com.algartelecom.adia.mastersaf.dao.DAuxiliar_Cliente_FatDAO;
import br.com.algartelecom.adia.mastersaf.dao.ItemNFSD_MastersafDAO;
import br.com.algartelecom.adia.mastersaf.dao.MestreNFSD_MastersafDAO;
import br.com.algartelecom.adia.mastersaf.dao.Servico_MastersafDAO;
import br.com.algartelecom.adia.mastersaf.to.CISS_MastersafTO;
import br.com.algartelecom.adia.mastersaf.to.CliFornecTransp_MastersafTO;
import br.com.algartelecom.adia.mastersaf.to.DAuxiliar_MastersafTO;
import br.com.algartelecom.adia.mastersaf.to.ItemNFSD_MastersafTO;
import br.com.algartelecom.adia.mastersaf.to.MestreNFSD_MastersafTO;
import br.com.algartelecom.adia.mastersaf.to.Servico_MastersafTO;
import br.com.algartelecom.adia.util.FormataData;

public class MastersafService {
	
	public void getFileService(String mesAno) throws Exception{
		Servico_MastersafDAO servicosMastersafDAO = new Servico_MastersafDAO();
		List<Servico_MastersafTO> listaMastersaf =  servicosMastersafDAO.getServico(mesAno);
		
		List<String> sConteudoArquivo = new ArrayList<String>();
		for(Servico_MastersafTO linhaConteudo : listaMastersaf){
			sConteudoArquivo.add(linhaConteudo.toString());
		}
		
		//TODO: fazer a conversão para trazer a data dinamicamente.
		Arquivo.geraArquivo("mastersaf\\SERVICOS\\ODIN_BILLING_SERVICO_" + FormataData.getDataHoraAtual_Americano(), sConteudoArquivo, ".txt");
	}
	
	public void getCliFornecTransp(String mesAno) throws Exception{
		CliFornecTransp_MastersafDAO cliFornecTranspMastersafDAO = new CliFornecTransp_MastersafDAO();
		List<CliFornecTransp_MastersafTO> listaMastersaf =  cliFornecTranspMastersafDAO.getCliFornecTransp(mesAno);
		
		List<String> sConteudoArquivo = new ArrayList<String>();
		for(CliFornecTransp_MastersafTO linhaConteudo : listaMastersaf){
			sConteudoArquivo.add(linhaConteudo.toString());
		}
		
		//TODO: fazer a conversão para trazer a data dinamicamente.
		Arquivo.geraArquivo("mastersaf\\CLI_FORNEC\\ODIN_BILLING_CLI_FORNEC_TRANSP_" + FormataData.getDataHoraAtual_Americano(), sConteudoArquivo, ".txt");
	}
	
	public void getMestreNFSD(String mesAno) throws Exception{
		MestreNFSD_MastersafDAO mestreNFSD_MastersafDAO = new MestreNFSD_MastersafDAO();
		List<MestreNFSD_MastersafTO> listaMastersaf =  mestreNFSD_MastersafDAO.getMestreNFSD(mesAno);
		
		List<String> sConteudoArquivo = new ArrayList<String>();
		for(MestreNFSD_MastersafTO linhaConteudo : listaMastersaf){
			sConteudoArquivo.add(linhaConteudo.toString());
		}
		
		//TODO: fazer a conversão para trazer a data dinamicamente.
		Arquivo.geraArquivo("mastersaf\\MESTRE\\ODIN_BILLING_MESTRE_NFSD_SERV_" + FormataData.getDataHoraAtual_Americano(), sConteudoArquivo, ".txt");
		
	}
	
	public void getItemNFSD(String mesAno) throws Exception{
		ItemNFSD_MastersafDAO itemNFSD_MastersafDAO = new ItemNFSD_MastersafDAO();
		List<ItemNFSD_MastersafTO> listaMastersaf =  itemNFSD_MastersafDAO.getItemNFSD(mesAno);
		
		List<String> sConteudoArquivo = new ArrayList<String>();
		for(ItemNFSD_MastersafTO linhaConteudo : listaMastersaf){
			
			//Ajuste de conta contábil pois estava errado no banco de dados.
			//MASTERSAF - ITEM - alterar a conta contabil de 310501007 para 310501006 
			//onde o código do produto for CD777777777 e o sales category ELASTIC CLOUD - POS
			
			if (linhaConteudo.getCodParaServico().startsWith("CD777777777") && linhaConteudo.getDscComplementar().startsWith("ELASTIC CLOUD - POS") ){
				linhaConteudo.setNumContaContabil("310501006");
			}
			
			sConteudoArquivo.add(linhaConteudo.toString());
		}
		
		//TODO: fazer a conversão para trazer a data dinamicamente.
		Arquivo.geraArquivo("mastersaf\\ITEM\\ODIN_BILLING_ITEM_NFSD_SERV_" + FormataData.getDataHoraAtual_Americano(), sConteudoArquivo, ".txt");
	}
	
	public void getCiss(String mesAno) throws Exception{
		
		Ciss_MastersafDAO ciss_MastersafDAO = new Ciss_MastersafDAO();
		List<CISS_MastersafTO> listaMastersaf =  ciss_MastersafDAO.getCiss(mesAno);
		
		List<String> sConteudoArquivo = new ArrayList<String>();
		for(CISS_MastersafTO linhaConteudo : listaMastersaf){
			sConteudoArquivo.add(linhaConteudo.toString());
		}
		
		//TODO: fazer a conversão para trazer a data dinamicamente.
		Arquivo.geraArquivo("mastersaf\\CISS\\ODIN_BILLING_CISS_" + FormataData.getDataHoraAtual_Americano(), sConteudoArquivo, ".txt");
	}
	
	public void getDAuxiliarClienteFaturamento(String vencimentoOficialFaturasPos, String mesFaturamento, String mesFaturamentoSemBarra,
			  String dataInicio, String dataFim) throws Exception {
		DAuxiliar_Cliente_FatDAO dAuxiliarClienteDAO = new DAuxiliar_Cliente_FatDAO();
		List<DAuxiliar_MastersafTO> listaMastersaf =  dAuxiliarClienteDAO.getDAuxiliarClienteFaturamento(vencimentoOficialFaturasPos, mesFaturamento, mesFaturamentoSemBarra,
				  																						 dataInicio, dataFim);
		
		List<String> sConteudoArquivo = new ArrayList<String>();
		for(DAuxiliar_MastersafTO linhaConteudo : listaMastersaf){
			sConteudoArquivo.add(linhaConteudo.toString());
		}
		
		//TODO: fazer a conversão para trazer a data dinamicamente.
		Arquivo.geraArquivo("mastersaf\\D_AUXILIAR_CLIENTE_FAT\\ODIN_BILLING_D_AUXILIAR_CLIENTE_" + FormataData.getDataHoraAtual_Americano(), sConteudoArquivo, ".txt");
	}
	
	public void getDAuxiliarClienteArrecadacao(String vencimentoOficialFaturasPos, String mesFaturamento, String dataInicio, String dataFim) throws Exception {
		DAuxiliar_Cliente_ArrDAO dAuxiliarClienteDAO = new DAuxiliar_Cliente_ArrDAO();
		
		List<DAuxiliar_MastersafTO> listaMastersaf =  dAuxiliarClienteDAO.getDAuxiliarClienteArrecadacao(vencimentoOficialFaturasPos, mesFaturamento, dataInicio, dataFim);
		
		List<String> sConteudoArquivo = new ArrayList<String>();
		for(DAuxiliar_MastersafTO linhaConteudo : listaMastersaf){
			sConteudoArquivo.add(linhaConteudo.toString());
		}
		
		//TODO: fazer a conversão para trazer a data dinamicamente.
		Arquivo.geraArquivo("mastersaf\\D_AUXILIAR_CLIENTE_ARR\\ODIN_BILLING_D_AUXILIAR_CLIENTE_" + FormataData.getDataHoraAtual_Americano(), sConteudoArquivo, ".txt");
	}
	
	//TODO: Fazer os demais arquivos aqui!

}
