package br.org.coletivoJava.integracoes.restIntollama.implementacao;

import br.org.coletivoJava.integracoes.restIntollama.api.InfoIntegracaoRestIntollamaModel;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllamaAgenteModel;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;
import jakarta.json.Json;
import jakarta.json.JsonObject;

@InfoIntegracaoRestIntollamaModel(tipo = FabApiRestOllamaAgenteModel.MODELO_CRIAR)
public class IntegracaoRestIntollamaModeloCriar extends AcaoApiIntegracaoAbstrato {

    private static final String NOME_MODELO = "tinyllama:1.1b";

    public IntegracaoRestIntollamaModeloCriar(
            final FabTipoAgenteClienteApi pTipoAgente,
            final ItfUsuario pUsuario,
            final java.lang.Object... pParametro) {
        super(FabApiRestOllamaAgenteModel.MODELO_CRIAR, pTipoAgente, pUsuario, pParametro);
    }

    @Override
    public String gerarCorpoRequisicao() {
        String nomeModelo = (String) getParametros()[0];
        String system = (String) getParametros()[1];
        JsonObject json = Json.createObjectBuilder()
                .add("model", nomeModelo)
                .add("from", NOME_MODELO)
                .add("system", system)
                .add("stream", false)
                .build();
        return json.toString();
    }
}