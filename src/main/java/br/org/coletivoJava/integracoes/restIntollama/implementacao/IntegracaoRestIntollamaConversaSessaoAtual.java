package br.org.coletivoJava.integracoes.restIntollama.implementacao;

import br.org.coletivoJava.integracoes.ollama.api.util.UtilOllamaConversas;
import br.org.coletivoJava.integracoes.restIntollama.api.InfoIntegracaoRestIntollamaChat;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllamaChat;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;
import jakarta.json.*;

@InfoIntegracaoRestIntollamaChat(tipo = FabApiRestOllamaChat.CONVERSA_SESSAO_ATUAL)
public class IntegracaoRestIntollamaConversaSessaoAtual extends AcaoApiIntegracaoAbstrato {
	private static final String NOME_MODELO = "CasanovaIA:latest";
	public IntegracaoRestIntollamaConversaSessaoAtual(
			final FabTipoAgenteClienteApi pTipoAgente,
			final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
		super(FabApiRestOllamaChat.CONVERSA_SESSAO_ATUAL, pTipoAgente,
				pUsuario, pParametro);
	}

	@Override
	public String gerarCorpoRequisicao() {
		String novaMensagemUsuario = (String) getParametros()[0];

		//TODO: CHAMAR A CHAVE POR PARAMETROS E N HARDCODED(CONFERIR COMO MELHORAR ISSO)

		JsonObject conversa = UtilOllamaConversas.lerConversa("teste123");
		JsonArray mensagensAnteriores = conversa.getJsonArray("messages");

		JsonArrayBuilder mensagensArrayBuilder = Json.createArrayBuilder();
		for(JsonValue mensagem : mensagensAnteriores){
			mensagensArrayBuilder.add(mensagem);
		}
		mensagensArrayBuilder.add(Json.createObjectBuilder()
				.add("role", "user")
				.add("content", novaMensagemUsuario));

		JsonObject jsonPrincipal = Json.createObjectBuilder()
				.add("model", conversa.getString("model"))
				.add("messages", mensagensArrayBuilder.build())
				.add("stream", false)
				.add("keep_alive", "10m")
				.build();

		return jsonPrincipal.toString();

	}
}