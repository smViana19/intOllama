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
 * Enum que representa os endpoints da API para gerenciamento de modelos no sistema Ollama.
 * <p>
 * Os modelos seguem uma convenção de nomenclatura: {@code model:tag}, onde {@code model} pode incluir
 * um namespace opcional (por exemplo, {@code example/model}) e {@code tag} é usado para especificar
 * uma versão. Se {@code tag} não for fornecido, o padrão será {@code latest}.
 * <p>
 * Exemplos:
 * <ul>
 * <li>{@code orca-mini:3b-q8_0e}</li>
 * <li>{@code llama3:70b}</li>
 * </ul>
 * </p>
 * Cada constante do enum corresponde a uma ação (por exemplo, criar, atualizar ou excluir um modelo)
 * com seu respectivo endpoint da API e método HTTP.
 *
 * @see <a href="https://github.com/ollama/ollama/blob/main/docs/api.md">Documentação da API Ollama</a>
 * @see FabConfigOllama
 */
@InfoConfigRestClientIntegracao(enderecosDocumentacao = "https://github.com/ollama/ollama/blob/main/docs/api.md",
        tipoAutenticacao = FabTipoAutenticacaoRest.USUARIO_SENHA_SIMPLES,
        nomeIntegracao = FabConfigOllama.NOME_INTEGRACAO,
        configuracao = FabConfigOllama.class
)

public enum FabApiRestOllamaAgenteModel implements ItfFabricaIntegracaoRest {

    /**
     * Cria um novo modelo no sistema Ollama.
     * <p>
     * Utiliza a convenção de nomenclatura {@code model:tag} para definir o novo modelo
     * a ser criado, onde {@code tag} é opcional e tem como padrão {@code latest}.
     * </p>
     * Endpoint da API: {@code /api/create}
     */
    @InfoConsumoRestService(getPachServico = "/api/create",
            tipoConexao = FabTipoConexaoRest.POST,
            parametrosPost = {"model", "system"},
            aceitarCertificadoDeHostNaoConfiavel = true,
            urlDocumentacao = "https://github.com/ollama/ollama/blob/main/docs/api.md")
    MODELO_CRIAR,
    /**
     * Exclui um modelo do sistema Ollama.
     * <p>
     * O modelo a ser excluído é identificado pelo seu nome {@code model:tag}.
     * </p>
     * Endpoint da API: {@code /api/delete}.
     */
    @InfoConsumoRestService(getPachServico = "/api/delete",
            tipoConexao = FabTipoConexaoRest.DELETE,
            aceitarCertificadoDeHostNaoConfiavel = true,
            urlDocumentacao = "https://github.com/ollama/ollama/blob/main/docs/api.md")
    MODELO_REMOVER

}
