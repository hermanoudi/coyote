package br.com.algartelecom.adia.mastersaf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.Enum.Categoria;
import br.com.algartelecom.adia.conexao.Conexao;
import br.com.algartelecom.adia.mastersaf.to.CISS_MastersafTO;
import br.com.algartelecom.adia.mastersaf.to.DAuxiliar_MastersafTO;

public class DAuxiliar_Cliente_ArrDAO {
	public List<DAuxiliar_MastersafTO> getDAuxiliarClienteArrecadacao(String vencimentoOficialFaturasPos, String mesFaturamento, String dataInicio, String dataFim) throws Exception{
		
		List<DAuxiliar_MastersafTO> dAuxiliarClienteList = new ArrayList<DAuxiliar_MastersafTO>();
		
		Connection conn = null;

		try {
			conn = Conexao.abreConexao();
			
			String query = " select '10' COD_EMPRESA, "+
					"        '000113' COD_FILIAL, "+
					"        'CL' COD_CATEGORIA_PF_PJ, "+
					"        concat('CD', lpad(cast(idt_cliente_odin as decimal), 8, 0)) COD_PF_PJ, "+
					"        date_format(ife.dta_pagamento_item, '%d%m%Y') DTA_LANCAMENTO, "+
					"        'R' IND_TIPO_OPERACAO, "+
					"        cast(sum(val_item_fatura*100) as decimal) VAL_LANCAMENTO, "+
					"           'C' IND_LANCAMENTO, "+ //-- recebimento credita contas a receber
					"        'FAT' IND_TIPO_DOCUMENTO, "+
					"        num_nfse NUM_DOCUMENTO, "+
					"        'U' NUM_SERIE_DOCUMENTO, "+
					"        date_format(dta_emissao_rps, '%d%m%Y') DTA_EMISSAO, "+
					"        case when ife.nom_modalidade_pagto = 'PRE-PAGO' then date_format(dta_pagamento_item, '%d%m%Y') "+
					"             else ? end DTA_VENCIMENTO, "+ //-- ATENCAO!!! tem que ver o prazo oficial de venc para POS
					"        cast(sum(val_item_fatura*100) as decimal) VAL_TOTAL_DOCTO, "+
					"        cast(cod_fatura_odin as decimal) NUM_ARQUIVAMENTO, "+
					"        '110201007' NUM_CONTA_CONTABIL, "+ //-- contas a receber
					"        'CLOUD2.0' DSC_OPENFLEX_01, "+
					"        '" + Categoria.ARRECADACAO.getNome() + "' DSC_OPENFLEX_02, "+
					"        date_format(sysdate(), '%d%m%Y%H%i%s') DSC_OPENFLEX_03, "+
					"        concat('BAIXA ', upper(fc_caracesp_converter(nom_salescategory_odin)), ?) DSC_OPENFLEX_04, "+ //-- "FATURAMENTO " + nome do produto + " " + Mes/Ano de Referencia (MM/AAAA)
					"        rpad(' ', 150, ' ') DSC_OPENFLEX_05, "+
					"        lpad('0', 17, 0) DSC_OPENFLEX_06, "+
					"        lpad('0', 17, 0) DSC_OPENFLEX_07, "+
					"        lpad('0', 17, 0) DSC_OPENFLEX_08 "+
					"   from vw_itemfatura_nfe ife "+
					"      , vw_salescategory_contrato_odin scc "+
					" where ife.dta_prevista_credito between str_to_date(?, '%Y%m%d') " +
					"    and str_to_date(?, '%Y%m%d%H%i%s') "+  //-- PREENCHER COM O PER�ODO A EXECUTAR
					"    and ife.num_contrato = scc.id_contrato_odin "+
					"    and ife.dta_pagamento_item is not null "+
					"    and ife.dta_pagamento_item <> '' "+
					"    and ife.nom_modalidade_pagto = 'POS-PAGO' "+ //-- conforme email do Cyllfarney, o arquivo de movimenta��o somente trata contas a receber; pre-pago n�o movimenta contas a receber
					" group by idt_cliente_odin, num_nfse ";;
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, vencimentoOficialFaturasPos);
			stmt.setString(2, mesFaturamento);
			stmt.setString(3, dataInicio);
			stmt.setString(4, dataFim);
			
			ResultSet resultSet = stmt.executeQuery(); 
			while (resultSet.next()){
				
				DAuxiliar_MastersafTO dAuxiliarClienteTO = new DAuxiliar_MastersafTO();
				dAuxiliarClienteTO.setCodEmpresa(resultSet.getString("COD_EMPRESA"));
				dAuxiliarClienteTO.setCodFilial(resultSet.getString("COD_FILIAL"));
				dAuxiliarClienteTO.setCodCategoriaPF_PF(resultSet.getString("COD_CATEGORIA_PF_PJ"));
				dAuxiliarClienteTO.setCodPF_PJ(resultSet.getString("COD_PF_PJ"));
				dAuxiliarClienteTO.setDtaLancamento(resultSet.getString("DTA_LANCAMENTO"));
				dAuxiliarClienteTO.setIndTipoOperacao(resultSet.getString("IND_TIPO_OPERACAO"));
				dAuxiliarClienteTO.setValLancamento(resultSet.getString("VAL_LANCAMENTO"));
				dAuxiliarClienteTO.setIndLancamento(resultSet.getString("IND_LANCAMENTO"));
				dAuxiliarClienteTO.setIndTipoDocumento(resultSet.getString("IND_TIPO_DOCUMENTO"));
				dAuxiliarClienteTO.setNumDocumento(resultSet.getString("NUM_DOCUMENTO"));
				dAuxiliarClienteTO.setNumSerieDocumento(resultSet.getString("NUM_SERIE_DOCUMENTO"));
				dAuxiliarClienteTO.setDtaEmissao(resultSet.getString("DTA_EMISSAO"));
				dAuxiliarClienteTO.setDtaVencimento(resultSet.getString("DTA_VENCIMENTO"));
				dAuxiliarClienteTO.setValTotalDocto(resultSet.getString("VAL_TOTAL_DOCTO"));
				dAuxiliarClienteTO.setNumArquivamento(resultSet.getString("NUM_ARQUIVAMENTO"));
				dAuxiliarClienteTO.setNumContaContabil(resultSet.getString("NUM_CONTA_CONTABIL"));
				dAuxiliarClienteTO.setDscOpenFlex_01(resultSet.getString("DSC_OPENFLEX_01"));
				dAuxiliarClienteTO.setDscOpenFlex_02(resultSet.getString("DSC_OPENFLEX_02"));
				dAuxiliarClienteTO.setDscOpenFlex_03(resultSet.getString("DSC_OPENFLEX_03"));
				dAuxiliarClienteTO.setDscOpenFlex_04(resultSet.getString("DSC_OPENFLEX_04"));
				dAuxiliarClienteTO.setDscOpenFlex_05(resultSet.getString("DSC_OPENFLEX_05"));
				dAuxiliarClienteTO.setDscOpenFlex_06(resultSet.getString("DSC_OPENFLEX_06"));
				dAuxiliarClienteTO.setDscOpenFlex_07(resultSet.getString("DSC_OPENFLEX_07"));
				dAuxiliarClienteTO.setDscOpenFlex_08(resultSet.getString("DSC_OPENFLEX_08"));
				
				dAuxiliarClienteList.add(dAuxiliarClienteTO);
			}

		
		return dAuxiliarClienteList;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally{
			Conexao.fechaConexao(conn);
		}
	}

}
