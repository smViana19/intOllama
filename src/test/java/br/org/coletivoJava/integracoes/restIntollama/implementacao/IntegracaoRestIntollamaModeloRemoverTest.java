package br.org.coletivoJava.integracoes.restIntollama.implementacao;

import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllamaAgenteModel;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import br.org.coletivoJava.integracoes.ollama.ConfigCoreOllamaTestesRegraNegocio;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegracaoRestIntollamaModeloRemoverTest {

    @Test
    public void excluirModelo() {
        SBCore.configurar(new ConfigCoreOllamaTestesRegraNegocio(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        ItfRespostaWebServiceSimples resposta = FabApiRestOllamaAgenteModel.MODELO_REMOVER.getAcao("iaSam:latest").getResposta();
        resposta.getCodigoResposta();
        assertEquals(200, resposta.getCodigoResposta());
    }
}