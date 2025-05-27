/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivoJava.integracoes.ollama.api.util;

import com.google.gson.GsonBuilder;
import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreJson;
import jakarta.json.*;


import java.io.*;

/**
 * @author salvio
 */
public class UtilOllamaConversas {
    //SBCore.getServicoArquivosDeEntidade().getEndrLocalResources()
    private static final String LOCAL_ARQUIVOS_JSON = SBCore.getServicoArquivosDeEntidade().getEndrLocalResources()+"/Ollama/conversasOllama/";
    private static final String MODELO = "CasanovaIA:latest";

    public static JsonObject lerConversa(String pChave) {
        return lerConversa(pChave, null);
    }

    public static JsonObject lerConversa(String pChave, String pPromptPersona) {
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
    }

    public static String carregarPersona(String pConfiguracaoPersona) {
        return pConfiguracaoPersona;
    }
}
