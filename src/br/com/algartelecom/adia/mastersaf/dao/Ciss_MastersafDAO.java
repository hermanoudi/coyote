package br.com.algartelecom.adia.mastersaf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.conexao.Conexao;
import br.com.algartelecom.adia.mastersaf.to.CISS_MastersafTO;

import com.mysql.jdbc.Statement;

public class Ciss_MastersafDAO {
	public List<CISS_MastersafTO> getCiss(String mesAno) throws Exception{
		
		List<CISS_MastersafTO> cissList = new ArrayList<CISS_MastersafTO>();
		Connection conn = null;

		try {
			conn = Conexao.abreConexao();
			
			String query = " select distinct " +
					"        '10' COD_EMPRESA, "+
					"        '000113' COD_FILIAL, "+
					"        'U' NUM_SERIE_NOTA_FISCAL, "+
					"        num_nfse NUM_NOTA_FISCAL, "+
					"        date_format(dta_emissao_rps, '%d%m%Y') DTA_EMISSAO, "+
					"        sif.num_seq_item NUM_ITEM, "+
					"        cast(val_item_fatura*100 as decimal) VAL_BASE_CALCULO_PIS_COFINS, "+
					"        cast(num_perc_aliq_pis*10000 as decimal) VAL_ALIQ_INCID_PIS, "+
					"        cast(val_pis*100 as decimal) VAL_DEBITO_PIS, "+
					"        cast(num_perc_aliq_cofins*10000 as decimal) VAL_ALIQ_INCID_COFINS, "+
					"        cast(val_cofins*100 as decimal) VAL_DEBITO_COFINS, "+
					"        rpad(' ', 20, ' ') COD_CONTRATO, "+
					"        if(c.SubstituicaoInterna in ('Federal', 'Municipal e Federal') and ife.nom_modalidade_pagto = 'POS-PAGO', cast(val_pis*100 as decimal),'0') VAL_PIS_RETIDO, "+
					"        if(c.SubstituicaoInterna in ('Federal', 'Municipal e Federal') and ife.nom_modalidade_pagto = 'POS-PAGO', cast(val_cofins*100 as decimal),'0') VAL_COFINS_RETIDA, "+
					"        lpad('0', 17, 0) VAL_CSLL_RETIDA, "+
					"        lpad('0', 17, 0) VAL_IR, "+
					"        '01' COD_SITUACAO_TRIBUT_PIS, "+
					"        '01' COD_SITUACAO_TRIBUT_COFINS "+
					"   from vw_itemfatura_nfe ife "+
					"      , adia_cliente_odin c "+
					"      , (SELECT cod_fatura_odin, cod_itemfatura_odin, g.ennum as num_seq_item "+
					"           FROM (SELECT ife1.cod_fatura_odin, ife1.cod_itemfatura_odin, "+
					"                                      @running1:=if(@previous1=concat(ife1.cod_fatura_odin),@running1,0) + 1 as ennum  , "+
					"                        @previous1:=concat(ife1.cod_fatura_odin) "+
					"                   FROM vw_itemfatura_nfe ife1 "+
					"                  ORDER BY ife1.cod_fatura_odin, cast(ife1.cod_itemfatura_odin as decimal) "+
					"                ) AS g) sif "+
					" where ife.idt_cliente_odin = c.idcliente "+
					"    and ife.cod_fatura_odin = sif.cod_fatura_odin "+
					"    and ife.cod_itemfatura_odin = sif.cod_itemfatura_odin "+
					"    and date_format(ife.dta_emissao_rps, '%m%Y') = ? "+
					" order by ife.cod_fatura_odin, cast(ife.cod_itemfatura_odin as decimal) ";
			
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, mesAno);

			ResultSet resultSet = stmt.executeQuery(); 

			while (resultSet.next()){
				
				CISS_MastersafTO ciss_MastersafTO = new CISS_MastersafTO();
				
				ciss_MastersafTO.setCodEmpresa(resultSet.getString("COD_EMPRESA"));
				ciss_MastersafTO.setCodFilial(resultSet.getString("COD_FILIAL"));
				ciss_MastersafTO.setNumSerieNotaFiscal(resultSet.getString("NUM_SERIE_NOTA_FISCAL"));
				ciss_MastersafTO.setNumNotaFiscal(resultSet.getString("NUM_NOTA_FISCAL"));
				ciss_MastersafTO.setDtaEmissao(resultSet.getString("DTA_EMISSAO"));
				ciss_MastersafTO.setNumItem(resultSet.getString("NUM_ITEM"));
				ciss_MastersafTO.setValBaseCalculoPis(resultSet.getString("VAL_BASE_CALCULO_PIS_COFINS"));
				ciss_MastersafTO.setValAliqAltoIncidPis(resultSet.getString("VAL_ALIQ_INCID_PIS"));
				ciss_MastersafTO.setValDebitoPis(resultSet.getString("VAL_DEBITO_PIS"));
				ciss_MastersafTO.setValAliqIncIDCofins(resultSet.getString("VAL_ALIQ_INCID_COFINS"));
				ciss_MastersafTO.setValDebitoCofins(resultSet.getString("VAL_DEBITO_COFINS"));
				ciss_MastersafTO.setCodContato(resultSet.getString("COD_CONTRATO"));
				ciss_MastersafTO.setValPisRetido(resultSet.getString("VAL_PIS_RETIDO"));
				ciss_MastersafTO.setValCofinsRetida(resultSet.getString("VAL_COFINS_RETIDA"));
				ciss_MastersafTO.setValCsllRetida(resultSet.getString("VAL_CSLL_RETIDA"));
				ciss_MastersafTO.setValIR(resultSet.getString("VAL_IR"));
				ciss_MastersafTO.setCodSituacaoTributPis(resultSet.getString("COD_SITUACAO_TRIBUT_PIS"));
				ciss_MastersafTO.setCodSituacaoTributCofins(resultSet.getString("COD_SITUACAO_TRIBUT_COFINS"));
				
				cissList.add(ciss_MastersafTO);
			}

		
		return cissList;
		
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally{
			Conexao.fechaConexao(conn);
		}
	}

}
