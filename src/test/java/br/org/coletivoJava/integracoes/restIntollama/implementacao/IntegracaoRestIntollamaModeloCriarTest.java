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
        ItfRespostaWebServiceSimples respostaCriacao = FabApiRestOllamaAgenteModel.MODELO_CRIAR.getAcao( "iaSam", "Você é o **iaSam**, assistente virtual especializado em atendimento ao cliente e ecrevera sempre em Portugues-Br").getResposta();
        System.out.println("Resposta: " + respostaCriacao.getRespostaTexto());
        assertTrue(respostaCriacao.isSucesso());
    }
}