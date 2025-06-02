package br.org.coletivoJava.integracoes.restIntollama.implementacao;

import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllamaChat;
import br.org.coletivoJava.integracoes.ollama.api.util.UtilOllamaConversas;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.ItfRespostaWebServiceSimples;
import br.org.coletivoJava.integracoes.ollama.ConfigCoreOllamaTestesRegraNegocio;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import jakarta.json.JsonObject;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class IntegracaoRestIntollamaConversaSessaoAtualTest {

    @Test
    public void testeChat() {
        SBCore.configurar(new ConfigCoreOllamaTestesRegraNegocio(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        ItfRespostaWebServiceSimples respostaCriacao = FabApiRestOllamaChat.CONVERSA_SESSAO.getAcao("Qual é a sua função?").getResposta();
        System.out.println("Resposta: " + respostaCriacao.getRespostaTexto());
        assertTrue(respostaCriacao.isSucesso());
    }

    @Test
    public void testeChatComHistorico() {
        SBCore.configurar(new ConfigCoreOllamaTestesRegraNegocio(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
        String chaveConversa = "suporte";
        String promptPersona =
                "Você é um assistente da empresa Casanova Digital.\n" +
                        "- Sempre responda em português do Brasil.\n" +
                        "- A sede da empresa é em **Belo Horizonte (MG)**. Nunca diga outra localização.\n" +
                        "- Casanova é uma empresa especializada em **campanhas de marketing digital**.\n" +
                        "- Seja sempre educado, objetivo e profissional com o usuário.\n" +
                        "- Não invente informações. Se não souber, diga que não sabe.";

        JsonObject conversa = UtilOllamaConversas.lerConversa(chaveConversa);
        System.out.println(conversa);
        UtilOllamaConversas.adicionarMensagem(chaveConversa, "user", "a casanovadigital é uma empresa de marketing digital?");

        JsonObject conversaAtualizada = UtilOllamaConversas.lerConversa(chaveConversa);
        JsonArray mensagens = conversaAtualizada.getJsonArray("messages");
        System.out.println("Conversa atualizada: " + conversaAtualizada);

        JsonArrayBuilder builder = Json.createArrayBuilder();
        mensagens.forEach(builder::add);

        JsonObject req = Json.createObjectBuilder()
                .add("messages", builder.build())
                .add("messages", builder.build())
                .add("stream", false)
                .add("keep_alive", "10m")
                .build();

        ItfRespostaWebServiceSimples respostaCriacao = FabApiRestOllamaChat.CONVERSA_SESSAO.getAcao(req.toString(), chaveConversa, promptPersona).getResposta();

        if (respostaCriacao.isSucesso()) {
            String respostaIA = respostaCriacao.getRespostaTexto();
            UtilOllamaConversas.adicionarMensagem(chaveConversa, "assistant", respostaIA);
        }
        System.out.println("Resposta: " + respostaCriacao.getRespostaTexto());

        assertTrue(respostaCriacao.isSucesso());
    }

}