package br.org.coletivoJava.integracoes.restIntollama.implementacao;

import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllamaAgenteModel;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import br.org.coletivoJava.integracoes.ollama.ConfigCoreOllamaTestesRegraNegocio;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class IntegracaoRestIntollamaModeloCriarTest {

    @Test
    public void testeCriarModelo() {
        SBCore.configurar(new ConfigCoreOllamaTestesRegraNegocio(), SBCore.ESTADO_APP.DESENVOLVIMENTO);

        String nomeModelo = "testeIa";
        String systemPrompt = "Você é o **testeIa**, assistente virtual especializado em solucionar duvidas de clientes sobre a nossa empresa que se chama Casanova digital";
        String template = "chat"; //instruction, chat, completion, qa
        Double temperature = 0.7;
        Boolean stream = false;
//        String quantize = "q4_0";

        ItfRespostaWebServiceSimples respostaCriacao = FabApiRestOllamaAgenteModel.MODELO_CRIAR.getAcao(nomeModelo, systemPrompt, template, temperature, stream).getResposta();
        System.out.println("Resposta: " + respostaCriacao.getRespostaTexto());
        assertTrue(respostaCriacao.isSucesso());
    }
}