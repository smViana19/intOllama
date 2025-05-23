package br.org.coletivoJava.integracoes.restIntollama.implementacao;

import br.org.coletivoJava.integracoes.restIntollama.api.InfoIntegracaoRestIntollamaModel;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllamaAgenteModel;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestIntollamaModel(tipo = FabApiRestOllamaAgenteModel.MODELO_ATUALIZAR)
public class IntegracaoRestIntollamaModeloAtualizar
		extends
			AcaoApiIntegracaoAbstrato {

	public IntegracaoRestIntollamaModeloAtualizar(
			final FabTipoAgenteClienteApi pTipoAgente,
			final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
		super(FabApiRestOllamaAgenteModel.MODELO_ATUALIZAR, pTipoAgente,
				pUsuario, pParametro);
	}
}