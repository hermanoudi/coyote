package br.com.algartelecom.adia.contabil.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.algartelecom.adia.conexao.Conexao;
import br.com.algartelecom.adia.contabil.to.FaturaImpostos;

public class ContabilFaturamentoImpostosCreditoeDebitoDAO {

	public List<FaturaImpostos> getContabilFaturamentoImpostosCreditoEDebito(String primeiroDiaMesAnterior, String primeiroDiaMesAtual) {

		Connection conn = null;
		List<FaturaImpostos> faturasImpostos = new ArrayList<FaturaImpostos>();

		try {
			conn = Conexao.abreConexao();

			String query = " select c.SubstituicaoInterna as retencao, ife.*, " +
							"   IFNULL(CASE WHEN ife.nom_vendedor IS NOT NULL AND ife.nom_vendedor <> '' AND c.segmentocliente = 'Corporativo' " +
							" THEN (SELECT cr.num_centro_resultado " +
							" FROM adia_cr_consultor_vantive cr " +
							" WHERE cr.num_documento_consultor = ife.nom_vendedor LIMIT 1) " +
							" WHEN ife.nom_vendedor IS NOT NULL AND ife.nom_vendedor <> '' AND c.segmentocliente <> 'Corporativo' " +
							" THEN (SELECT crl.num_centro_resultado " +
							" FROM adia_cr_localidade_cliente crl " +
							" WHERE crl.nom_localidade = c.endereco_cidade " +
							" AND crl.sgl_uf_localidade = c.endereco_estado LIMIT 1) " +
							" WHEN ife.nom_vendedor IS NULL OR ife.nom_vendedor = '' " +
							" THEN (SELECT crl.num_centro_resultado " +
							" FROM adia_cr_localidade_cliente crl " +
							" WHERE crl.nom_localidade = c.endereco_cidade " +
							" AND crl.sgl_uf_localidade = c.endereco_estado LIMIT 1) " +
							" ELSE '00' " +
							" END, '00') cod_centro_custos " +
							"   from vw_itemfatura_nfe ife " +
							"   inner join adia_cliente_odin c " +
							"   on ife.idt_cliente_odin = c.idcliente " +
							"  where nom_modalidade_pagto = 'POS-PAGO' " + //preencher conforme informa��o sendo tratada
							"  and dta_emissao_rps >= str_to_date(?, '%Y%m%d') "+ //-- trocar o mes e o ano para o mes e o ano do per�odo contabil
							"  and dta_emissao_rps < str_to_date(?, '%Y%m%d')";

			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, primeiroDiaMesAnterior);
			stmt.setString(2, primeiroDiaMesAtual);
			ResultSet resultSet = stmt.executeQuery();
			while (resultSet.next()) {

				FaturaImpostos faturaImpostos = new FaturaImpostos();
				faturaImpostos.setIndTipoChave(resultSet.getString("ind_tipo_chave"));
				faturaImpostos.setIdtChaveFatura(resultSet.getString("idt_chave_fatura"));
				faturaImpostos.setIdtClienteOdin(resultSet.getString("idt_cliente_odin"));
				faturaImpostos.setNomModalidadePagto(resultSet.getString("nom_modalidade_pagto"));
				faturaImpostos.setNomFormaPagamento(resultSet.getString("nom_forma_pagto"));
				faturaImpostos.setNomBandeiraCartao(resultSet.getString("nom_bandeira_cartao"));
				faturaImpostos.setNumContrato(resultSet.getString("num_contrato"));
				faturaImpostos.setCodPlanoServico(resultSet.getString("cod_plano_servico"));
				faturaImpostos.setDscItemFatura(resultSet.getString("dsc_item_fatura"));
				faturaImpostos.setDtaAtivacao(resultSet.getString("dta_ativacao"));
				faturaImpostos.setValItemFatura(resultSet.getString("val_item_fatura"));
				faturaImpostos.setDtaCriacaoItem(resultSet.getString("dta_criacao_item"));
				faturaImpostos.setDtaVencimento(resultSet.getString("dta_vencimento"));
				faturaImpostos.setDtaPagamentoItem(resultSet.getString("dta_pagamento_item"));
				faturaImpostos.setDtaPrevistaCredito(resultSet.getString("dta_prevista_credito"));
				faturaImpostos.setCodFaturaOdin(resultSet.getString("cod_fatura_odin"));
				faturaImpostos.setCodItemFaturaOdin(resultSet.getString("cod_itemfatura_odin"));
				faturaImpostos.setNumPercAliqISS(resultSet.getString("num_perc_aliq_iss"));
				faturaImpostos.setValISS(resultSet.getString("val_iss"));
				faturaImpostos.setNumPercAliqCofins(resultSet.getString("num_perc_aliq_cofins"));
				faturaImpostos.setValCofins(resultSet.getString("val_cofins"));
				faturaImpostos.setNumPercAliqPis(resultSet.getString("num_perc_aliq_pis"));
				faturaImpostos.setValPis(resultSet.getString("val_pis"));
				faturaImpostos.setCodContaContabil(resultSet.getString("cod_conta_contabil"));
				faturaImpostos.setNomVendedor(resultSet.getString("nom_vendedor"));
				faturaImpostos.setCodAtividadeItem(resultSet.getString("cod_atividade_item"));
				faturaImpostos.setCodSkuOdin(resultSet.getString("cod_sku_odin"));
				faturaImpostos.setCodVendedor(resultSet.getString("cod_vendedor"));
				faturaImpostos.setIdtControleNFE(resultSet.getString("idt_controle_nfe"));
				faturaImpostos.setIdtFatura(resultSet.getString("idt_fatura"));
				faturaImpostos.setNumDocumentoCliente(resultSet.getString("num_documento_cliente"));
				faturaImpostos.setNumRPSBatChid(resultSet.getString("num_rpsbatchid"));
				faturaImpostos.setNomSerieRps(resultSet.getString("nom_serie_rps"));
				faturaImpostos.setNumRPS(resultSet.getString("num_rps"));
				faturaImpostos.setDtaEmissaoRPS(resultSet.getDate("dta_emissao_rps"));
				faturaImpostos.setNomStatusLote(resultSet.getString("nom_status_lote"));
				faturaImpostos.setNomStatusRPS(resultSet.getString("nom_status_rps"));
				faturaImpostos.setCodMunicipioSiaf(resultSet.getString("cod_municipio_siaf"));
				faturaImpostos.setDtaPrimeiroEnvio(resultSet.getString("dta_primeiro_envio"));
				faturaImpostos.setDtaPrimeiroRetorno(resultSet.getString("dta_primeiro_retorno"));
				faturaImpostos.setDtaUltimoEnvio(resultSet.getString("dta_ultimo_envio"));
				faturaImpostos.setDtaUltimoRetorno(resultSet.getString("dta_ultimo_retorno"));
				faturaImpostos.setNumNFSe(resultSet.getString("num_nfse"));
				faturaImpostos.setCodChaveNFSe(resultSet.getString("cod_chave_nfse"));
				faturaImpostos.setDtaProcessamentoNFSe(resultSet.getDate("dta_processamento_nfse"));
				faturaImpostos.setDtaCriacao(resultSet.getString("dta_criacao"));
				faturaImpostos.setCodCentroCustos(resultSet.getString("cod_centro_custos"));
				faturaImpostos.setRetencao(resultSet.getString("retencao"));

				faturasImpostos.add(faturaImpostos);

			}

			return faturasImpostos;

		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		} finally{
			Conexao.fechaConexao(conn);
		}

	}

}
