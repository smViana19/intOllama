package br.org.coletivoJava.integracoes.restIntollama.implementacao;

import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllamaChat;
import br.org.coletivoJava.integracoes.restIntollama.api.InfoIntegracaoRestIntollamaChat;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;
import jakarta.json.Json;
import jakarta.json.JsonObject;

@InfoIntegracaoRestIntollamaChat(tipo = FabApiRestOllamaChat.CONVERSA_OBTER_RESPOSTA_IA)
public class IntegracaoRestIntollamaConversaObterRespostaIa extends AcaoApiIntegracaoAbstrato {

//    private static final String NOME_MODELO = "tinyllama:1.1b";
    private static final String NOME_MODELO = "tinyllama:1.1b";

    public IntegracaoRestIntollamaConversaObterRespostaIa(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ItfUsuario pUsuario,
            final java.lang.Object... pParametro) {
        super(FabApiRestOllamaChat.CONVERSA_OBTER_RESPOSTA_IA, pTipoAgente,
                pUsuario, pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {
        String mensagem = (String) getParametros()[0];
        JsonObject json = Json.createObjectBuilder()
                .add("model", NOME_MODELO)
                .add("prompt", mensagem)
                .add("stream", false)
                .build();
        return json.toString();
    }
}