/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.coletivoJava.integracoes.restMavEmail;

import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOlhamaChat;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllhamaAgenteModel;

import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.rocketChat.implementacaoRCRest.ConfigCoreOllhamaTestesRegraNegocio;
import org.junit.Test;
import testes.testesSupers.TestesApiRest;

/**
 *
 * @author sfurbino
 */
public class TesteConformidade extends TestesApiRest {

    @Test
    public void testes() {
        SBCore.configurar(new ConfigCoreOllhamaTestesRegraNegocio(), SBCore.ESTADO_APP.DESENVOLVIMENTO);

        gerarCodigosChamadasEndpoint(FabApiRestOlhamaChat.class);
        gerarCodigosChamadasEndpoint(FabApiRestOllhamaAgenteModel.class);

//        RespostaWebServiceSimples resposta = FabApiRestRokcetChatV1Users.DIRECT_MENSAGENS_CONTADORES.getAcao().getResposta();
        //      System.out.println(resposta);
        //     System.out.println(resposta.getRespostaTexto());
    }
}
