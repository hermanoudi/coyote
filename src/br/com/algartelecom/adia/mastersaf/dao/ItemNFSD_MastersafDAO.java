package br.com.algartelecom.adia.mastersaf.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.conexao.Conexao;
import br.com.algartelecom.adia.mastersaf.to.ItemNFSD_MastersafTO;

public class ItemNFSD_MastersafDAO {
	
	public List<ItemNFSD_MastersafTO> getItemNFSD(String mesAno) throws Exception{
		List<ItemNFSD_MastersafTO> itemNFSDList = new ArrayList<ItemNFSD_MastersafTO>();
		
		Connection conn = null;
		try {
			conn = Conexao.abreConexao();
			
			String query = " select distinct "+
					"        '10' COD_EMPRESA, "+
					"        '000113' COD_FILIAL, "+
					"        'U' NUM_SERIE_NOTA_FISCAL, "+
					"        num_nfse NUM_NOTA_FISCAL, "+
					"        date_format(dta_emissao_rps, '%d%m%Y') DTA_EMISSAO, "+
					"        'CL' COD_CATEGORIA_PF_PJ, "+
					"        sif.num_seq_item NUM_ITEM, "+
					"        concat('CD', lpad(idt_cliente_odin, 8, 0)) COD_PF_PJ, "+
					"        'NFe' IND_TIPO_DOCUMENTO, "+
					"        concat('CD', ife.cod_plano_servico) COD_PARA_SERVICO, "+
					"        upper(fc_caracesp_converter(nom_salescategory_odin)) DSC_COMPLEMENTAR, "+
					"        cast(val_item_fatura*100 as decimal)  VAL_SERVICO, "+
					"        lpad('0', 17, 0) VAL_DESCONTO, "+
					"        cast(num_perc_aliq_iss*10000 as decimal) VAL_ALIQ_ISS, "+
					"        cast(val_item_fatura*100 as decimal) VAL_BASE_CALCULO_ISS, "+
					"        cast(val_iss*100 as decimal) VAL_ISS, "+
					"        cast(val_item_fatura*100 as decimal) VAL_TOTAL_DOCUMENTO, "+
					"        ci.cod_item_servico COD_FISCAL_SERVICO, "+
					"        lpad('0', 17, 0) VAL_MATERIAL_APLICADO, "+
					"        lpad('0', 17, 0) VAL_SUBEMPREITADA, "+
					"        '01' IND_TIPO_LOCALIDADE, "+
					"        rpad(' ', 10, ' ') NOM_LOCALIDADE, "+
					"        'NFS' IND_TIPO_DOCTO_MUNICIPIO, "+
					"        cod_conta_contabil NUM_CONTA_CONTABIL, "+
					"        lpad(IFNULL(CASE WHEN nom_vendedor IS NOT NULL and nom_vendedor <> '' AND c.segmentocliente = 'Corporativo' "+
					"                                 THEN (SELECT cr.num_centro_resultado "+
					"                                           FROM adia_cr_consultor_vantive cr "+
					"                                          WHERE cr.num_documento_consultor = ife.nom_vendedor LIMIT 1) "+
					"                            WHEN ife.nom_vendedor IS NOT NULL and nom_vendedor <> '' AND c.segmentocliente <> 'Corporativo' "+
					"                                 THEN (SELECT crl.num_centro_resultado "+
					"                                           FROM adia_cr_localidade_cliente crl "+
					"                                          WHERE crl.nom_localidade = c.endereco_cidade "+
					"                                          AND crl.sgl_uf_localidade = c.endereco_estado LIMIT 1) "+
					"                            WHEN ife.nom_vendedor IS NULL or nom_vendedor = '' "+
					"                                 THEN (SELECT crl.num_centro_resultado "+
					"                                                              FROM adia_cr_localidade_cliente crl "+
					"                                          WHERE crl.nom_localidade = c.endereco_cidade "+
					"                                          AND crl.sgl_uf_localidade = c.endereco_estado LIMIT 1) "+
					"                            ELSE '00' "+
					"                       END, '00'), 9, '0') COD_CENTRO_CUSTOS, "+
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
					"      , (select * from vw_salescategory_contrato_odin where cod_plano_servico <> 186) scc "+
					"      , (select distinct cod_atividade, cod_item_servico from adia_classificacao_impostos) ci "+
					"      , (SELECT cod_fatura_odin, cod_itemfatura_odin, g.ennum as num_seq_item "+
					"           FROM (SELECT ife1.cod_fatura_odin, ife1.cod_itemfatura_odin, "+
					"                                     @running1:=if(@previous1=concat(ife1.cod_fatura_odin),@running1,0) + 1 as ennum  , "+
					"                        @previous1:=concat(ife1.cod_fatura_odin) "+
					"                   FROM vw_itemfatura_nfe ife1 "+
					"                  ORDER BY cod_fatura_odin, cast(ife1.cod_itemfatura_odin as decimal) "+
					"                ) AS g) sif "+
					" where ife.idt_cliente_odin = c.idcliente "+
					"    and ife.num_contrato = scc.id_contrato_odin "+
					"    and ife.cod_atividade_item = ci.cod_atividade "+
					"    and ife.cod_fatura_odin = sif.cod_fatura_odin "+
					"    and ife.cod_itemfatura_odin = sif.cod_itemfatura_odin "+
					"    and date_format(ife.dta_emissao_rps, '%m%Y') = ? "+
					" order by ife.cod_fatura_odin, cast(ife.cod_itemfatura_odin as decimal) ";;
									
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, mesAno );
			
			ResultSet resultSet = stmt.executeQuery();
			
			while (resultSet.next()){
				ItemNFSD_MastersafTO itemNFSD_MastersafTO = new ItemNFSD_MastersafTO();

				itemNFSD_MastersafTO.setCodEmpresa(resultSet.getString("COD_EMPRESA"));
				itemNFSD_MastersafTO.setCodFilial(resultSet.getString("COD_FILIAL"));
				itemNFSD_MastersafTO.setNumSerieNotaFiscal(resultSet.getString("NUM_SERIE_NOTA_FISCAL"));
				itemNFSD_MastersafTO.setNumNotaFiscal(resultSet.getString("NUM_NOTA_FISCAL"));
				itemNFSD_MastersafTO.setDtaEmissao(resultSet.getString("DTA_EMISSAO"));
				itemNFSD_MastersafTO.setCodCategoriaPF_PJ(resultSet.getString("COD_CATEGORIA_PF_PJ"));
				itemNFSD_MastersafTO.setNumItem(resultSet.getString("NUM_ITEM"));
				itemNFSD_MastersafTO.setCodPF_PJ(resultSet.getString("COD_PF_PJ"));
				itemNFSD_MastersafTO.setIndTiposDocumento(resultSet.getString("IND_TIPO_DOCUMENTO"));
				itemNFSD_MastersafTO.setCodParaServico(resultSet.getString("COD_PARA_SERVICO"));
				itemNFSD_MastersafTO.setDscComplementar(resultSet.getString("DSC_COMPLEMENTAR"));
				itemNFSD_MastersafTO.setValServico(resultSet.getString("VAL_SERVICO"));
				itemNFSD_MastersafTO.setValDesconto(resultSet.getString("VAL_DESCONTO"));
				itemNFSD_MastersafTO.setValAliqISS(resultSet.getString("VAL_ALIQ_ISS"));
				itemNFSD_MastersafTO.setValBaseCalculoISS(resultSet.getString("VAL_BASE_CALCULO_ISS"));
				itemNFSD_MastersafTO.setValISS(resultSet.getString("VAL_ISS"));
				itemNFSD_MastersafTO.setValTotalDocumento(resultSet.getString("VAL_TOTAL_DOCUMENTO"));
				itemNFSD_MastersafTO.setCodFiscalServico(resultSet.getString("COD_FISCAL_SERVICO"));
				itemNFSD_MastersafTO.setValMaterialAplicado(resultSet.getString("VAL_MATERIAL_APLICADO"));
				itemNFSD_MastersafTO.setValSubEmpreitada(resultSet.getString("VAL_SUBEMPREITADA"));
				itemNFSD_MastersafTO.setIndTipoLocalidade(resultSet.getString("IND_TIPO_LOCALIDADE"));
				itemNFSD_MastersafTO.setNomLocalidade(resultSet.getString("NOM_LOCALIDADE"));
				itemNFSD_MastersafTO.setIndTipoDoctoMunicipio(resultSet.getString("IND_TIPO_DOCTO_MUNICIPIO"));
				itemNFSD_MastersafTO.setNumContaContabil(resultSet.getString("NUM_CONTA_CONTABIL"));
				itemNFSD_MastersafTO.setCodCentroCustos(resultSet.getString("COD_CENTRO_CUSTOS"));
				itemNFSD_MastersafTO.setDscOpenFlex_01(resultSet.getString("DSC_OPENFLEX_01"));
				itemNFSD_MastersafTO.setDscOpenFlex_02(resultSet.getString("DSC_OPENFLEX_02"));
				itemNFSD_MastersafTO.setDscOpenFlex_03(resultSet.getString("DSC_OPENFLEX_03"));
				itemNFSD_MastersafTO.setDscOpenFlex_04(resultSet.getString("DSC_OPENFLEX_04"));
				itemNFSD_MastersafTO.setDscOpenFlex_05(resultSet.getString("DSC_OPENFLEX_05"));
				itemNFSD_MastersafTO.setDscOpenFlex_06(resultSet.getString("DSC_OPENFLEX_06"));
				itemNFSD_MastersafTO.setDscOpenFlex_07(resultSet.getString("DSC_OPENFLEX_07"));
				itemNFSD_MastersafTO.setDscOpenFlex_08(resultSet.getString("DSC_OPENFLEX_08"));
				
				itemNFSDList.add(itemNFSD_MastersafTO);
			}
			return itemNFSDList;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally{
			Conexao.fechaConexao(conn);
		}
	}

}
