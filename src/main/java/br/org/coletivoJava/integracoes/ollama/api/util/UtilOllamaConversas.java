/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivoJava.integracoes.ollama.api.util;

import jakarta.json.*;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author salvio
 */
public class UtilOllamaConversas {
    //    private static final String LOCAL_ARQUIVOS_JSON = SBCore.getServicoArquivosDeEntidade().getEndrLocalResources()+"/Ollama/conversasOllama/";
    private static final String LOCAL_ARQUIVOS_JSON = "/home/superBits/projetos/coletivoJava/source/erpColetivoJava/SbErpIAOllama/src/main/resources/";
    private static final String MODELO = "CasanovaIA:latest";


    public static JsonObject lerConversa(String pChave, String pModel) {
        return lerConversa(pChave, pModel, null);
    }

    public static JsonObject lerConversa(String pChave) {
        return lerConversa(pChave, null, null);
    }

    public static JsonObject lerConversa(String pChave, String pPromptPersona, String pModel) {
        File arquivo = getArquivoConversa(pChave);

        if (!arquivo.exists()) {
            JsonArrayBuilder mensagens = Json.createArrayBuilder();
            if (pPromptPersona == null) {
                pPromptPersona = carregarPersona(pChave);
            }

            if (pPromptPersona != null) {
                mensagens.add(Json.createObjectBuilder()
                        .add("role", "system")
                        .add("content", pPromptPersona));
            }
            JsonObject novaConversa = Json.createObjectBuilder()
                    .add("model", pModel)
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

    public static void adicionarMensagem(String pChave, String pRole, String pContent, String pPromptSystem, String pModel) {
        JsonObject conversa = lerConversa(pChave, pPromptSystem, pModel);
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
    }


    public static void adicionarMensagem(String pChave, String pRole, String pContent) {
        adicionarMensagem(pChave, pRole, pContent, null, null);
    }

    public static String carregarPersona(String pConfiguracaoPersona) {
        return pConfiguracaoPersona;
    }
}
