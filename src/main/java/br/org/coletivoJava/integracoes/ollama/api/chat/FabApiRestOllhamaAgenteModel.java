/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivoJava.integracoes.ollama.api.chat;

import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.ItfFabricaIntegracaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.FabTipoConexaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.InfoConsumoRestService;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.servicoRegistrado.FabTipoAutenticacaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.servicoRegistrado.InfoConfigRestClientIntegracao;

/**
 *
 * @author salvio
 */
@InfoConfigRestClientIntegracao(enderecosDocumentacao = "https://github.com/ollama/ollama/blob/main/docs/api.md",
        tipoAutenticacao = FabTipoAutenticacaoRest.USUARIO_SENHA_SIMPLES,
        nomeIntegracao = FabConfigOllama.NOME_INTEGRACAO,
        configuracao = FabConfigOllama.class
)
public enum FabApiRestOllhamaAgenteModel implements ItfFabricaIntegracaoRest {
    @InfoConsumoRestService(getPachServico = "/api/create",
            tipoConexao = FabTipoConexaoRest.POST,
            aceitarCertificadoDeHostNaoConfiavel = true,
            urlDocumentacao = "https://github.com/ollama/ollama/blob/main/docs/api.md")
    MODELO_CRIAR,
    @InfoConsumoRestService(getPachServico = "/api/create",
            tipoConexao = FabTipoConexaoRest.PUT,
            aceitarCertificadoDeHostNaoConfiavel = true,
            urlDocumentacao = "https://github.com/ollama/ollama/blob/main/docs/api.md")
    MODELO_ATUALIZAR,
    @InfoConsumoRestService(getPachServico = "/api/create",
            tipoConexao = FabTipoConexaoRest.DELETE,
            aceitarCertificadoDeHostNaoConfiavel = true,
            urlDocumentacao = "https://github.com/ollama/ollama/blob/main/docs/api.md")
    MODELO_REMOVER;

}
