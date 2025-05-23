/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package br.org.coletivoJava.integracoes.restIntolhamma.implementacao;

import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOlhamaChat;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.ItfTokenGestao;
import com.super_bits.modulosSB.SBCore.integracao.rocketChat.implementacaoRCRest.ConfigCoreOllhamaTestesRegraNegocio;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author salvio
 */
public class IntegracaoRestIntolhammaConversaObterRespostaIaTest {

    @Test
    public void testSomeMethod() {
        SBCore.configurar(new ConfigCoreOllhamaTestesRegraNegocio(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        //  ItfTokenGestao gestaoTokenDoSistema = FabApiRestOlhamaChat.CONVERSA_OBTER_RESPOSTA_IA.getGestaoToken();
        //  gestaoTokenDoSistema.gerarNovoToken();
        //  assertTrue(gestaoTokenDoSistema.isTemTokemAtivo());
        ItfRespostaWebServiceSimples resposta = FabApiRestOlhamaChat.CONVERSA_OBTER_RESPOSTA_IA.getAcao("NomeAgenteModel",
                SBCore.getUsuarioLogado(), "Olá, mundo, como funciona essa consulta via ollhama?").getResposta();
        assertTrue(resposta.isSucesso());
        System.out.println(resposta.getRespostaTexto());
    }

}
