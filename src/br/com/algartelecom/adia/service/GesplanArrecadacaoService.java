package br.com.algartelecom.adia.service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import br.com.algartelecom.adia.arquivo.Arquivo;
import br.com.algartelecom.adia.gesplan.to.ArquivoGesplanTO;
import br.com.algartelecom.adia.util.FormataData;

public class GesplanArrecadacaoService {

	public void agrupaArquivosDeArrecadacaoGerados() throws IOException {
		
		File file = new File("C:\\projetos\\CLOUD-2.0\\Integracoes\\Gesplan\\Repositorio\\ARRECADACAO");
		
		List<String> contentNewfile = new ArrayList<String>();
		
		if (file.isDirectory()){
			String[] nomesArquivos = file.list();
			for (int i = 0; i < nomesArquivos.length; i++){
				if (nomesArquivos[i].startsWith("ODIN_302_ARR")){
					FileReader fr = new FileReader(new File("C:\\projetos\\CLOUD-2.0\\Integracoes\\Gesplan\\Repositorio\\ARRECADACAO\\" + nomesArquivos[i]));
					BufferedReader br = new BufferedReader( fr );
					
					//equanto houver mais linhas
					while( br.ready() ){
					//lê a proxima linha
					String linha = br.readLine();
					//faz algo com a linha
					contentNewfile.add(linha);
					}
				}
			}
			Arquivo.geraArquivo("Integracoes\\Gesplan\\Repositorio\\ARRECADACAO\\temporario\\ODIN_302_ARR_" + FormataData.getDataHoraAtual_Americano() , contentNewfile, ".txt");
		}
	}

	public void geraArquivoAjustado() throws IOException {
		
		File file = new File("C:\\projetos\\CLOUD-2.0\\Integracoes\\Gesplan\\Repositorio\\ARRECADACAO\\temporario");
		List<String> conteudoArquivoTemporario = new ArrayList<String>();
		conteudoArquivoTemporario = ajustaDadosArquivoTemporario(file, conteudoArquivoTemporario);
		Arquivo.geraArquivo("Integracoes\\Gesplan\\Repositorio\\ARRECADACAO\\gerado-arrecadacao\\ODIN_302_ARR_" + FormataData.getDataHoraAtual_Americano() , conteudoArquivoTemporario, ".txt");
	}

	private List<String> ajustaDadosArquivoTemporario(File file, List<String> conteudoArquivoTemporario)
			throws FileNotFoundException, IOException {
		if (file.isDirectory()){
			String[] nomesArquivos = file.list();
			for (int i = 0; i < nomesArquivos.length; i++){
				if (nomesArquivos[i].startsWith("ODIN_302_ARR")){
					File arquivoTemporario = new File("C:\\projetos\\CLOUD-2.0\\Integracoes\\Gesplan\\Repositorio\\ARRECADACAO\\temporario\\" + nomesArquivos[i]);
					FileReader fr = new FileReader(arquivoTemporario);
					BufferedReader br = new BufferedReader( fr );
					
					//equanto houver mais linhas
					while( br.ready() ){
					//lê a proxima linha
					String linha = br.readLine();
					String linhaAjustada = ajustaDadosLinhaArquivo(linha);
					//faz algo com a linha
					conteudoArquivoTemporario.add(linhaAjustada);
					}
					
					//Ler somente um arquivo de arrecadacao
					br.close();
					fr.close();
					arquivoTemporario.delete();
					
					return conteudoArquivoTemporario;
				}
			}
		}
		return conteudoArquivoTemporario;
	}

	private String ajustaDadosLinhaArquivo(String sLinha) {
		String[] linha = sLinha.split(";");
		
		ArquivoGesplanTO arrecadacao = new ArquivoGesplanTO();
		
		for (int i=0; i < linha.length; i++){
			arrecadacao.setDataCriacao((linha[0] == null) ? "" : linha[0]);
			arrecadacao.setDsKeyOrigem((linha[1] == null) ? "" : linha[1]);
			arrecadacao.setDtInterface((linha[2] == null) ? "" : linha[2]);
			arrecadacao.setBlInterface((linha[3] == null) ? "": linha[3]);
			arrecadacao.setIdSistemaOrigem((linha[4] == null) ? "": linha[4]);
			arrecadacao.setBlEntradaSaida((linha[5] == null) ? "": linha[5]);
			
			arrecadacao.setDsAgrupador((linha[6] == null) ? "": linha[6]);
			
			arrecadacao.setIdEmpresa((linha[7] == null) ? "": linha[7]);
			arrecadacao.setIdBanco((linha[8] == null) ? "": linha[8]);
			arrecadacao.setNrAgencia((linha[9] == null) ? "": linha[9]);
			arrecadacao.setNrContaCorrente((linha[10] == null) ? "": linha[10]);
			
			String idFormaPagamento = (linha[11] == null) ? "": linha[11];
			idFormaPagamento = insereBandeiraCartaoCredito(idFormaPagamento, arrecadacao.getDsAgrupador());
			arrecadacao.setIdFormaPagamento(idFormaPagamento);
			
			arrecadacao.setDsFormaPagamento(arrecadacao.getIdFormaPagamento());
			
			arrecadacao.setNrFormaPagamento((linha[13] == null) ? "": linha[13]);
			arrecadacao.setIdTipoResponsavel((linha[14] == null) ? "": linha[14]);
			arrecadacao.setIdResponsavel((linha[15] == null) ? "": linha[15]);
			arrecadacao.setIdCnpjCpfResponsavel((linha[16] == null) ? "": linha[16]);
			arrecadacao.setCdCnpjCpfResponsavel((linha[17] == null) ? "": linha[17]);
			arrecadacao.setDsResponsavel((linha[18] == null) ? "": linha[18]);
			arrecadacao.setDtPagamento((linha[19] == null) ? "": linha[19]);
			arrecadacao.setIdFormaEmissao((linha[20] == null) ? "": linha[20]);
			arrecadacao.setDtVencimento((linha[21] == null) ? "": linha[21]);
			arrecadacao.setIdEmpresaDevedora((linha[22] == null) ? "": linha[22]);
			arrecadacao.setIdUnidadeNegocioDevedor((linha[23] == null) ? "": linha[23]);
			arrecadacao.setVlLancado((linha[24] == null) ? "": linha[24]);
			arrecadacao.setTxImpostoRenda((linha[25] == null) ? "": linha[25]);
			arrecadacao.setVlImpostoRenda((linha[26] == null) ? "": linha[26]);
			arrecadacao.setVlJuros((linha[27] == null) ? "": linha[27]);
			arrecadacao.setVlMulta((linha[28] == null) ? "": linha[28]);
			arrecadacao.setVlDesconto((linha[29] == null) ? "": linha[29]);
			arrecadacao.setVlLiquido((linha[30] == null) ? "": linha[30]);
			arrecadacao.setIdTipoDocto((linha[31] == null) ? "": linha[31]);
			arrecadacao.setDsTipoDocto((linha[32] == null) ? "": linha[32]);
			arrecadacao.setNrDocto((linha[33] == null) ? "": linha[33]);
			arrecadacao.setIdTipoResponsavelReal((linha[34] == null) ? "": linha[34]);
			arrecadacao.setIdResponsavelReal((linha[35] == null) ? "": linha[35]);
			arrecadacao.setIdCnpjCpfResponsavelReal((linha[36] == null) ? "": linha[36]);
			arrecadacao.setCdCnpjCpfResponsavelReal((linha[37] == null) ? "": linha[37]);
			arrecadacao.setDsResponsavelReal((linha[38] == null) ? "": linha[38]);
			arrecadacao.setIdBancoDestinoOrigem((linha[39] == null) ? "": linha[39]);
			arrecadacao.setIdAgenciaDestinoOrigem((linha[40] == null) ? "": linha[40]);
			arrecadacao.setNrContaDestinoOrigem((linha[41] == null) ? "": linha[41]);
			arrecadacao.setIdContaFinanceira((linha[42] == null) ? "": linha[42]);
			arrecadacao.setDsRejeitado((linha[43] == null) ? "": linha[43]);
			arrecadacao.setIdContaContabil((linha[44] == null) ? "": linha[44]);
			arrecadacao.setNrOrdemProcessamento((linha[45] == null) ? "": linha[45]);
			arrecadacao.setDtRegistro((linha[46] == null) ? "": linha[46]);
			arrecadacao.setDsObservacao((linha[47] == null) ? "": linha[47]);
			arrecadacao.setDsCodOrigemCusto((linha[48] == null) ? "": linha[48]);
			arrecadacao.setDsDeParaVencimento((linha[49] == null) ? "": linha[49]);
			arrecadacao.setTxMoeda((linha[50] == null) ? "": linha[50]);
			arrecadacao.setBlTaxaFixa((linha[51] == null) ? "": linha[51]);
			arrecadacao.setIdMoeda((linha[52] == null) ? "": linha[52]);
			arrecadacao.setBlAntecipaVencimento((linha[53] == null) ? "": linha[53]);
			arrecadacao.setBlContabiliza((linha[54] == null) ? "": linha[54]);
			arrecadacao.setBlReserva("");
			arrecadacao.setDtVencimentoOriginal("");
			arrecadacao.setBlAgrupaLancto("");
			arrecadacao.setDsContaContabil("");
			arrecadacao.setBlRecebivel("");
			arrecadacao.setIdClassContaContabil("");
			arrecadacao.setDsCentroCusto("");
			arrecadacao.setIdIndexGerenc("");
		}
			
		return arrecadacao.toString();
	}

	private String insereBandeiraCartaoCredito(String idFormaPagamento, String dsAgrupador) {

		Pattern PATTERN = Pattern.compile("RECBTO CARTAO (\\([A-Za-z ]*+\\)).*");
		
		Matcher matcher = PATTERN.matcher(dsAgrupador);
		
		if (matcher.matches() && matcher.groupCount() == 1){
				String bandeira = matcher.group(1);
				return "CARTAO "+ bandeira;
		} else{
				return idFormaPagamento;
		}
	}
}

