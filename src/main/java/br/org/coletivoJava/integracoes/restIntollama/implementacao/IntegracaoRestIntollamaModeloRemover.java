package br.org.coletivoJava.integracoes.restIntollama.implementacao;

import br.org.coletivoJava.integracoes.restIntollama.api.InfoIntegracaoRestIntollamaModel;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllamaAgenteModel;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.RespostaWebServiceSimples;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;
import jakarta.json.Json;
import jakarta.json.JsonObject;

@InfoIntegracaoRestIntollamaModel(tipo = FabApiRestOllamaAgenteModel.MODELO_REMOVER)
public class IntegracaoRestIntollamaModeloRemover extends AcaoApiIntegracaoAbstrato {

    public IntegracaoRestIntollamaModeloRemover(final FabTipoAgenteClienteApi pTipoAgente, final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
        super(FabApiRestOllamaAgenteModel.MODELO_REMOVER, pTipoAgente,
                pUsuario, pParametro);

    }

    @Override
    public String gerarCorpoRequisicao() {
        String model = (String) getParametros()[0];
        JsonObject json = Json.createObjectBuilder().add("model", model).build();
        return json.toString();
    }
}