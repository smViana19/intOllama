package br.org.coletivoJava.integracoes.restOllama;

import com.super_bits.modulosSB.SBCore.ConfigGeral.SBCore;
import br.org.coletivoJava.integracoes.ollama.ConfigCoreOllamaTestesRegraNegocio;
import org.junit.Test;
import testesFW.TesteJunit;

public class TesteConformidadeModel extends TesteJunit {

    @Test
    public void teste(){

        gerarCodigoModelProjeto();
    }

    @Override
    protected void configAmbienteDesevolvimento() {
        SBCore.configurar(new ConfigCoreOllamaTestesRegraNegocio(), SBCore.ESTADO_APP.DESENVOLVIMENTO);
    }
}
