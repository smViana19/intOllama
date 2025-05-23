package br.org.coletivoJava.integracoes.restIntolhamma.implementacao;

import br.org.coletivoJava.integracoes.restIntolhamma.api.InfoIntegracaoRestIntolhammaModel;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllhamaAgenteModel;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestIntolhammaModel(tipo = FabApiRestOllhamaAgenteModel.MODELO_ATUALIZAR)
public class IntegracaoRestIntolhammaModeloAtualizar
		extends
			AcaoApiIntegracaoAbstrato {

	public IntegracaoRestIntolhammaModeloAtualizar(
			final FabTipoAgenteClienteApi pTipoAgente,
			final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
		super(FabApiRestOllhamaAgenteModel.MODELO_ATUALIZAR, pTipoAgente,
				pUsuario, pParametro);
	}
}