package br.org.coletivoJava.integracoes.restIntollama.implementacao;

import br.org.coletivoJava.integracoes.restIntollama.api.InfoIntegracaoRestIntollamaChat;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllamaChat;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;
import jakarta.json.Json;
import jakarta.json.JsonObject;

@InfoIntegracaoRestIntollamaChat(tipo = FabApiRestOllamaChat.CONVERSA_SESSAO_ATUAL)
public class IntegracaoRestIntollamaConversaSessaoAtual extends AcaoApiIntegracaoAbstrato {
	private static final String NOME_MODELO = "tinyllama:1.1b";
	public IntegracaoRestIntollamaConversaSessaoAtual(
			final FabTipoAgenteClienteApi pTipoAgente,
			final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
		super(FabApiRestOllamaChat.CONVERSA_SESSAO_ATUAL, pTipoAgente,
				pUsuario, pParametro);
	}

	@Override
	public String gerarCorpoRequisicao() {
		String mensagem = (String) getParametros()[0];
		Object[] parametrosMensagens = (Object[]) getParametros()[1];
		//TODO: AJUSTAR OS PARAMETROS
		String role = "";
		JsonObject json = Json.createObjectBuilder()
				.add("model", NOME_MODELO)
				.add("messages", Json.createArrayBuilder().add(role))
				.add("stream", false)
				.build();
		return json.toString();
	}
}