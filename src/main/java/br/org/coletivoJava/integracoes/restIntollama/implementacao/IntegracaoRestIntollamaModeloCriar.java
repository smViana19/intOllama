package br.org.coletivoJava.integracoes.restIntollama.implementacao;

import br.org.coletivoJava.integracoes.restIntollama.api.InfoIntegracaoRestIntollamaModel;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllamaAgenteModel;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;
import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;

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
        Object[] parametros = getParametros();
        String nomeModelo = (String) parametros[0];
        String system = parametros.length > 1 && parametros[1] != null ? (String) parametros[1] : null;
        String template = parametros.length > 2 && parametros[2] != null ? (String) parametros[2] : null;
        Double temperature = parametros.length > 3 && parametros[3] != null ? (Double) parametros[3] : null;
        boolean stream = parametros.length > 4 && parametros[4] != null && (boolean) parametros[4];
        String quantize = parametros.length > 5 && parametros[5] != null ? (String) parametros[5] : null;

        JsonObjectBuilder json = Json.createObjectBuilder()
                .add("model", nomeModelo)
                .add("from", NOME_MODELO)
                .add("stream", stream);

        if (system != null) {
            json.add("system", system);
        }
        if (template != null) {
            json.add("template", template);
        }
        if (quantize != null) {
            json.add("quantize", quantize);
        }
        if (temperature != null) {
            json.add("temperature", temperature);
        }
        JsonObject jsonObject = json.build();
        System.out.println("Json: " + jsonObject.toString());


        return jsonObject.toString();
    }
}