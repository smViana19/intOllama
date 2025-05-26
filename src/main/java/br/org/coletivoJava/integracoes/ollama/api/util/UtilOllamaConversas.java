/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivoJava.integracoes.ollama.api.util;

import com.google.gson.GsonBuilder;
import jakarta.json.*;


import java.io.*;

/**
 * @author salvio
 */
public class UtilOllamaConversas {
    //SBCore.getServicoArquivosDeEntidade().getEndrLocalResources()
    private static final String LOCAL_ARQUIVOS_JSON = "/home/superBits/desenvolvedor/configModuloTestes/integracao/modulos/Ollama/conversasOllama/";
    private static final String MODELO = "CasanovaIA:latest";
//    public static void atualizarConversa(String chave, JsonObject pNovaMensagem) {
//        JsonObject conversa = lerConversa(chave);
//        JsonArray mensagens = conversa.getAsJsonArray("messages");
//        mensagens.add(pNovaMensagem);
//        salvarConversa(conversa, chave);
//    }

    public static JsonObject lerConversa(String pChave) {
        File arquivo = getArquivoConversa(pChave);

        if (!arquivo.exists()) {
            JsonArrayBuilder mensagens = Json.createArrayBuilder();
            String promptPersona = carregarPersona(pChave);
            if (promptPersona != null) {
                mensagens.add(Json.createObjectBuilder()
                        .add("role", "system")
                        .add("content", promptPersona));
            }
            JsonObject novaConversa = Json.createObjectBuilder()
                    .add("model", MODELO)
                    .add("messages", mensagens)
                    .build();
            try (JsonWriter escreverJson = Json.createWriter(new FileWriter(arquivo))) {
                escreverJson.writeObject(novaConversa);
            } catch (IOException e) {
                throw new RuntimeException("Erro ao salvar conversa inicial " + e);
            }
            return novaConversa;
        }

        try (JsonReader lerJson = Json.createReader(new FileReader(arquivo))) {
            return lerJson.readObject();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static File getArquivoConversa(String pChave) {
        String endereco = LOCAL_ARQUIVOS_JSON + pChave + ".json";
        return new File(endereco);
    }

    public static void adicionarMensagem(String pChave, String pRole, String pContent) {
        JsonObject conversa = lerConversa(pChave);
        JsonArray mensagensAntigas = conversa.getJsonArray("messages");
        JsonArrayBuilder mensagensNovasBuilder = Json.createArrayBuilder();

        mensagensAntigas.forEach(mensagensNovasBuilder::add);
        mensagensNovasBuilder.add(Json.createObjectBuilder()
                .add("role", pRole)
                .add("content", pContent));

        JsonObject novaConversa = Json.createObjectBuilder()
                .add("model", conversa.getString("model"))
                .add("messages", mensagensNovasBuilder.build())
                .build();

        try (JsonWriter writer = Json.createWriter(new FileWriter(getArquivoConversa(pChave)))) {
            writer.writeObject(novaConversa);
        } catch (IOException e) {
            throw new RuntimeException(" Erro ao salvar conversa" + e);
        }


//        File arquivo = getArquivoConversa(pChave);
//        if (!arquivo.exists()) {
//            arquivo.getParentFile().mkdirs();
//        }
//        try (Writer writer = new FileWriter(arquivo)) {
//            new GsonBuilder().setPrettyPrinting().create().toJson(pConversa, writer);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
    }

    //TODO: COLOCAR PARA RECEBER O SYSTEM DA PERSONA FORA (POR PARAMETRO)

    private static String carregarPersona(String chave) {
        return "1. **Foco Temático**:\n" +
                "   - Responda APENAS sobre:\n" +
                "     • Produtos/Serviços da empresa\n" +
                "     • Status de pedidos\n" +
                "     • Prazo de entrega\n" +
                "     • Dúvidas comerciais\n" +
                "\n" +
                "2. **Tom e Estilo**:\n" +
                "   - Linguagem coloquial BR (sem formalidades)\n" +
                "   - Máximo 3 frases por resposta\n" +
                "   - Use emojis moderadamente (ex: \uD83D\uDC4D, \uD83D\uDE0A)\n" +
                "   - Sempre ofereça ajuda adicional\n" +
                "\n" +
                "3. **Limites**:\n" +
                "   - Nunca sugira produtos não cadastrados\n" +
                "   - Recuse educadamente perguntas off-topic\n" +
                "   - Não cite concorrentes\n" +
                "   - Nunca forneça links externos\n" +
                "4. **Sempre em português**\n" +
                "5. **Sobre empresa**\n" +
                "    - Empresa de marketing digital *BRASILEIRA*\n" +
                "    - Oference serviços de marketing, sites, landing page wordpress, desenvolvimento de sistemas java, crm, erp para sua empresa\n" +
                " " +
                "Prazos de servico dependendo do servico escolhido, para mais informaçoes consulte um gestor";
    }
}
