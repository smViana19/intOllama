package br.org.coletivoJava.integracoes.restIntolhamma.implementacao;

import br.org.coletivoJava.integracoes.restIntolhamma.api.InfoIntegracaoRestIntolhammaChat;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOlhamaChat;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestIntolhammaChat(tipo = FabApiRestOlhamaChat.CONVERSA_NOVA_SESSAO)
public class IntegracaoRestIntolhammaConversaNovaSessao
		extends
			AcaoApiIntegracaoAbstrato {

	public IntegracaoRestIntolhammaConversaNovaSessao(
			final FabTipoAgenteClienteApi pTipoAgente,
			final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
		super(FabApiRestOlhamaChat.CONVERSA_NOVA_SESSAO, pTipoAgente, pUsuario,
				pParametro);
	}
}