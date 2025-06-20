package br.org.coletivoJava.integracoes.ollama.api.chat;

import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.ItfFabricaIntegracaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.FabTipoConexaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.InfoConsumoRestService;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.servicoRegistrado.FabTipoAutenticacaoRest;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.servicoRegistrado.InfoConfigRestClientIntegracao;

/**
 * @author sfurbino
 */
@InfoConfigRestClientIntegracao(enderecosDocumentacao = "https://github.com/ollama/ollama/blob/main/docs/api.md",
        tipoAutenticacao = FabTipoAutenticacaoRest.USUARIO_SENHA_SIMPLES,
        nomeIntegracao = FabConfigOllama.NOME_INTEGRACAO,
        configuracao = FabConfigOllama.class
)
public enum FabApiRestOllamaChat implements ItfFabricaIntegracaoRest {

    @InfoConsumoRestService(getPachServico = "/api/generate",
            tipoConexao = FabTipoConexaoRest.POST,
            parametrosPost = {"model", "prompt", "stream"},
            aceitarCertificadoDeHostNaoConfiavel = true,
            urlDocumentacao = "https://github.com/ollama/ollama/blob/main/docs/api.md")
    CONVERSA_OBTER_RESPOSTA_IA,


    @InfoConsumoRestService(getPachServico = "/api/chat",
            tipoConexao = FabTipoConexaoRest.POST,
            aceitarCertificadoDeHostNaoConfiavel = true,
            urlDocumentacao = "https://github.com/ollama/ollama/blob/main/docs/api.md")
    CONVERSA_SESSAO;
}
