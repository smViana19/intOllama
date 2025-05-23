package br.org.coletivoJava.integracoes.restIntolhamma.implementacao;

import br.org.coletivoJava.integracoes.restIntolhamma.api.InfoIntegracaoRestIntolhammaChat;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOlhamaChat;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestIntolhammaChat(tipo = FabApiRestOlhamaChat.CONVERSA_OBTER_RESPOSTA_IA)
public class IntegracaoRestIntolhammaConversaObterRespostaIa
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntolhammaConversaObterRespostaIa(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestOlhamaChat.CONVERSA_OBTER_RESPOSTA_IA, pTipoAgente,
                pUsuario, pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {
        return "{json: 'teste'}"; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

}
