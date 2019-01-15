package br.com.algartelecom.adia.mastersaf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.conexao.Conexao;
import br.com.algartelecom.adia.mastersaf.to.MestreNFSD_MastersafTO;

import com.mysql.jdbc.Statement;

public class MestreNFSD_MastersafDAO {
	
	public List<MestreNFSD_MastersafTO> getMestreNFSD(String mesAno) throws Exception{
		List<MestreNFSD_MastersafTO> mestreNFSDList = new ArrayList<MestreNFSD_MastersafTO>();
		
		Connection conn = null;
		try {
			conn = Conexao.abreConexao();
			
			String query = " select '10' COD_EMPRESA, " +
					"        '000113' COD_FILIAL, " +
					"        'U' NUM_SERIE_NOTA_FISCAL, "+
					"        num_nfse NUM_NOTA_FISCAL, "+
					"        date_format(dta_emissao_rps, '%d%m%Y') DTA_EMISSAO, "+
					"        'CL' COD_CATEGORIA_PF_PJ, "+
					"        concat('CD', lpad(idt_cliente_odin, 8, 0)) COD_PF_PJ, "+
					"        'NFe' IND_TIPO_DOCUMENTO, "+
					"        cast(count(1) as decimal) NUM_ITENS, "+
					"        rpad(' ', 3, ' ') COD_MODELO_DOCUMENTO, "+
					"        cast(sum(val_item_fatura*100) as decimal) VAL_TOTAL_SERVICO, "+
					"        lpad('0', 17, 0) VAL_DESCONTO, "+
					"        lpad('0', 17, 0) VAL_ALIQ_IRRF, "+
					"        lpad('0', 17, 0) VAL_BASE_CALCULO_IRRF, "+
					"        lpad('0', 17, 0) VAL_IRRF, "+
					"        rpad('N', 1, ' ') IND_CANCELAMENTO, "+
					"        lpad('0', 17, 0) VAL_INSS, "+
					"        lpad('0', 17, 0) VAL_ALIQ_INSS, "+
					"        case c.substituicaointerna when 'Municipal' then cast(sum(val_iss*100) as decimal)  when 'Municipal e Federal' then cast(sum(val_iss*100) as decimal) else '0' end VAL_ISS_RETIDO_PELO_TOMADOR, "+
					"        rpad(' ', 150, ' ') DSC_OBSERVACAO_NFE, "+
					"        lpad('0', 17, 0) VAL_BASE_CALCULO_RET_INSS, "+
					"        'NFS' IND_TIPO_DOCTO_MUNICIPIO, "+
					"           cast(sum(val_item_fatura*100) as decimal) VAL_BASE_CALCULO_ISS, "+
					"        cod_chave_nfse DSC_CHAVE_NFE, "+
					"        date_format(case ind_tipo_chave when 'PGTO' then dta_pagamento_item else dta_criacao_item end, '%d%m%Y') DTA_EXECUCAO_CONCLUSAO, "+
					"        case nom_modalidade_pagto when 'PRE-PAGO' then '0' when 'POS-PAGO' then '1' end IND_TIPO_PAGAMENTO, "+
					"        'CLOUD2.0' DSC_OPENFLEX_01, "+
					"        'FATURAMENTO' DSC_OPENFLEX_02, "+
					"        date_format(sysdate(), '%d%m%Y%H%i%s') DSC_OPENFLEX_03, "+
					"        rpad(' ', 150, ' ') DSC_OPENFLEX_04, "+
					"        rpad(' ', 150, ' ') DSC_OPENFLEX_05, "+
					"        lpad('0', 17, 0) DSC_OPENFLEX_06, "+
					"        lpad('0', 17, 0) DSC_OPENFLEX_07, "+
					"        lpad('0', 17, 0) DSC_OPENFLEX_08 "+
					"   from vw_itemfatura_nfe ife "+
					"      , adia_cliente_odin c "+
					" where date_format(ife.dta_emissao_rps, '%m%Y') = ? "+
					"    and ife.idt_cliente_odin = c.idcliente "+
					" group by idt_cliente_odin, num_nfse ";
									
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, mesAno);
			
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()){
				
				MestreNFSD_MastersafTO mestreNFSD_MastersafTO = new MestreNFSD_MastersafTO();
				
				mestreNFSD_MastersafTO.setCodEmpresa(resultSet.getString("COD_EMPRESA"));
				mestreNFSD_MastersafTO.setCodFilial(resultSet.getString("COD_FILIAL"));
				mestreNFSD_MastersafTO.setNumSerieNotaFiscal(resultSet.getString("NUM_SERIE_NOTA_FISCAL"));
				mestreNFSD_MastersafTO.setNumNotaFiscal(resultSet.getString("NUM_NOTA_FISCAL"));
				mestreNFSD_MastersafTO.setDtaEmissao(resultSet.getString("DTA_EMISSAO"));
				mestreNFSD_MastersafTO.setCodCategoriaPFPJ(resultSet.getString("COD_CATEGORIA_PF_PJ"));
				mestreNFSD_MastersafTO.setCodPFPJ(resultSet.getString("COD_PF_PJ"));
				mestreNFSD_MastersafTO.setIndTipoDocumento(resultSet.getString("IND_TIPO_DOCUMENTO"));
				mestreNFSD_MastersafTO.setNumItens(resultSet.getString("NUM_ITENS"));
				mestreNFSD_MastersafTO.setCodModeloDocumento(resultSet.getString("COD_MODELO_DOCUMENTO"));
				mestreNFSD_MastersafTO.setValTotalServico(resultSet.getString("VAL_TOTAL_SERVICO"));
				mestreNFSD_MastersafTO.setValDesconto(resultSet.getString("VAL_DESCONTO"));
				mestreNFSD_MastersafTO.setValAliqIRRF(resultSet.getString("VAL_ALIQ_IRRF"));
				mestreNFSD_MastersafTO.setValBaseCalculoIRRF(resultSet.getString("VAL_BASE_CALCULO_IRRF"));
				mestreNFSD_MastersafTO.setValIRRF(resultSet.getString("VAL_BASE_CALCULO_IRRF"));
				mestreNFSD_MastersafTO.setIndCancelamento(resultSet.getString("IND_CANCELAMENTO"));
				mestreNFSD_MastersafTO.setValINSS(resultSet.getString("VAL_INSS"));
				mestreNFSD_MastersafTO.setValAliqINSS(resultSet.getString("VAL_ALIQ_INSS"));
				mestreNFSD_MastersafTO.setValISSRetidoPeloTomador(resultSet.getString("VAL_ISS_RETIDO_PELO_TOMADOR"));
				mestreNFSD_MastersafTO.setDscObservacaoNFe(resultSet.getString("DSC_OBSERVACAO_NFE"));
				mestreNFSD_MastersafTO.setValBaseCalculoRetINSS(resultSet.getString("VAL_BASE_CALCULO_RET_INSS"));
				mestreNFSD_MastersafTO.setIndTipoDoctoMunicipio(resultSet.getString("IND_TIPO_DOCTO_MUNICIPIO"));
				mestreNFSD_MastersafTO.setValBaseCalculoISS(resultSet.getString("VAL_BASE_CALCULO_ISS"));
				mestreNFSD_MastersafTO.setDscChaveNFe(resultSet.getString("DSC_CHAVE_NFE"));
				mestreNFSD_MastersafTO.setDtaExecucaoConclusao(resultSet.getString("DTA_EXECUCAO_CONCLUSAO"));
				mestreNFSD_MastersafTO.setIndTipoPagamento(resultSet.getString("IND_TIPO_PAGAMENTO"));
				mestreNFSD_MastersafTO.setDscOpenFlex_01(resultSet.getString("DSC_OPENFLEX_01"));
				mestreNFSD_MastersafTO.setDscOpenFlex_02(resultSet.getString("DSC_OPENFLEX_02"));
				mestreNFSD_MastersafTO.setDscOpenFlex_03(resultSet.getString("DSC_OPENFLEX_03"));
				mestreNFSD_MastersafTO.setDscOpenFlex_04(resultSet.getString("DSC_OPENFLEX_04"));
				mestreNFSD_MastersafTO.setDscOpenFlex_05(resultSet.getString("DSC_OPENFLEX_05"));
				mestreNFSD_MastersafTO.setDscOpenFlex_06(resultSet.getString("DSC_OPENFLEX_06"));
				mestreNFSD_MastersafTO.setDscOpenFlex_07(resultSet.getString("DSC_OPENFLEX_07"));
				mestreNFSD_MastersafTO.setDscOpenFlex_08(resultSet.getString("DSC_OPENFLEX_08"));
				
				mestreNFSDList.add(mestreNFSD_MastersafTO);
			}
			//System.out.println("Retornados "+ mestreNFSDList.size());
			return mestreNFSDList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally{
			Conexao.fechaConexao(conn);
		}
		
	}


}
