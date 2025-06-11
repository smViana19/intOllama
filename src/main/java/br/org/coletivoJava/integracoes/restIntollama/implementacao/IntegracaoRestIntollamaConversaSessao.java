package br.org.coletivoJava.integracoes.restIntollama.implementacao;

import br.org.coletivoJava.integracoes.ollama.api.util.UtilOllamaConversas;
import br.org.coletivoJava.integracoes.restIntollama.api.InfoIntegracaoRestIntollamaChat;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllamaChat;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.RespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;
import jakarta.json.*;

@InfoIntegracaoRestIntollamaChat(tipo = FabApiRestOllamaChat.CONVERSA_SESSAO)
public class IntegracaoRestIntollamaConversaSessao
        extends
        AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntollamaConversaSessao(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestOllamaChat.CONVERSA_SESSAO, pTipoAgente, pUsuario,
                pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {
        String nomeModelo = (String) getParametros()[0];
        String novaMensagemUsuario = (String) getParametros()[1];
        String chave = (String) getParametros()[2];
        String configuracaoSystemInicial = (String) getParametros()[3];

        JsonObject conversa = UtilOllamaConversas.lerConversa(chave, configuracaoSystemInicial, nomeModelo);
        JsonArray mensagensAnteriores = conversa.getJsonArray("messages");

        JsonArrayBuilder mensagensArrayBuilder = Json.createArrayBuilder();
        for (JsonValue mensagem : mensagensAnteriores) {
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

    @Override
    protected RespostaWebServiceSimples gerarRespostaTratamentoFino(RespostaWebServiceSimples pRespostaWSSemTratamento) {
        try {
            UtilOlhamaTratamentoErro.gerarRespostaTratamentoFino(pRespostaWSSemTratamento);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pRespostaWSSemTratamento;
    }
}