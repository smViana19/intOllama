package br.org.coletivoJava.integracoes.restIntollama.implementacao;

import br.org.coletivoJava.integracoes.restIntollama.api.InfoIntegracaoRestIntollamaChat;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllamaChat;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestIntollamaChat(tipo = FabApiRestOllamaChat.CONVERSA_NOVA_SESSAO)
public class IntegracaoRestIntollamaConversaNovaSessao
		extends
			AcaoApiIntegracaoAbstrato {

	public IntegracaoRestIntollamaConversaNovaSessao(
			final FabTipoAgenteClienteApi pTipoAgente,
			final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
		super(FabApiRestOllamaChat.CONVERSA_NOVA_SESSAO, pTipoAgente, pUsuario,
				pParametro);
	}
}