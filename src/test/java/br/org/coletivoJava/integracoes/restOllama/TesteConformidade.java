/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.integracoes.restOllama;

import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllamaChat;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllamaAgenteModel;

import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import br.org.coletivoJava.integracoes.ollama.ConfigCoreOllamaTestesRegraNegocio;
import org.junit.Test;
import testes.testesSupers.TestesApiRest;

/**
 *
 * @author sfurbino
 */
public class TesteConformidade extends TestesApiRest {

    @Test
    public void testes() {
        SBCore.configurar(new ConfigCoreOllamaTestesRegraNegocio(), SBCore.ESTADO_APP.DESENVOLVIMENTO);

        gerarCodigosChamadasEndpoint(FabApiRestOllamaChat.class);
        gerarCodigosChamadasEndpoint(FabApiRestOllamaAgenteModel.class);

//        RespostaWebServiceSimples resposta = FabApiRestRokcetChatV1Users.DIRECT_MENSAGENS_CONTADORES.getAcao().getResposta();
        //      System.out.println(resposta);
        //     System.out.println(resposta.getRespostaTexto());
    }
}
