/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntOllama.implementacao;

import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllamaChat;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import br.org.coletivoJava.integracoes.ollama.ConfigCoreOllamaTestesRegraNegocio;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author salvio
 */
public class IntegracaoRestIntOllamaConversaObterRespostaIaTest {

    private static final String NOME_MODELO = "CasanovaIA:latest";

    @Test
    public void testeObterResposta() {
        SBCore.configurar(new ConfigCoreOllamaTestesRegraNegocio(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        ItfRespostaWebServiceSimples resposta = FabApiRestOllamaChat.CONVERSA_OBTER_RESPOSTA_IA.getAcao(NOME_MODELO, "Gostei de você, explique-me o que é a formula de ohm").getResposta();
        System.out.println(resposta.getRespostaTexto());
        assertTrue(resposta.isSucesso());
    }
}