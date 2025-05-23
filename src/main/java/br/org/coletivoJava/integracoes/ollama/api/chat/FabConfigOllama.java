/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.org.coletivoJava.integracoes.ollama.api.chat;

import com.super_bits.modulosSB.SBCore.ConfigGeral.arquivosConfiguracao.ItfFabConfigModulo;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.tipoModulos.integracaoOauth.FabPropriedadeModuloIntegracaoOauth;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.tipoModulos.integracaoOauth.InfoPropriedadeConfigRestIntegracao;

/**
 *
 * @author salvio
 */
public enum FabConfigOllama implements ItfFabConfigModulo {

    @InfoPropriedadeConfigRestIntegracao(tipoPropriedade = FabPropriedadeModuloIntegracaoOauth.CHAVE_PUBLICA)
    CHAVE_PUBLICA,
    @InfoPropriedadeConfigRestIntegracao(tipoPropriedade = FabPropriedadeModuloIntegracaoOauth.URL_SERVIDOR_API)
    URL_OLLAMA_SERVER_API,;
    public static final String NOME_INTEGRACAO = "intOlhamma";

    @Override
    public String getValorPadrao() {
        switch (this) {

            case CHAVE_PUBLICA:
                break;
            case URL_OLLAMA_SERVER_API:
                break;
            default:
                throw new AssertionError();
        }
        return "não definido";
    }
}
