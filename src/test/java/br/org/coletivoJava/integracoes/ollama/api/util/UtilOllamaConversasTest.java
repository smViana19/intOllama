package br.org.coletivoJava.integracoes.ollama.api.util;

import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.rocketChat.implementacaoRCRest.ConfigCoreOllamaTestesRegraNegocio;
import org.junit.Test;

public class UtilOllamaConversasTest  {

    @Test
    public void testeUtilConversas() {
        SBCore.configurar(new ConfigCoreOllamaTestesRegraNegocio(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
//        UtilOllamaConversas.salvarConversa();
//        UtilOllamaConversas.getArquivoConversa("");

    }

}