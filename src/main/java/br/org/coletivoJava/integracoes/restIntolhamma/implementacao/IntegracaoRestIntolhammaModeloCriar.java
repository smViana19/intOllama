package br.org.coletivoJava.integracoes.restIntolhamma.implementacao;

import br.org.coletivoJava.integracoes.restIntolhamma.api.InfoIntegracaoRestIntolhammaModel;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllhamaAgenteModel;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.AcaoApiIntegracaoAbstrato;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

@InfoIntegracaoRestIntolhammaModel(tipo = FabApiRestOllhamaAgenteModel.MODELO_CRIAR)
public class IntegracaoRestIntolhammaModeloCriar
		extends
			AcaoApiIntegracaoAbstrato {

	public IntegracaoRestIntolhammaModeloCriar(
			final FabTipoAgenteClienteApi pTipoAgente,
			final ItfUsuario pUsuario, final java.lang.Object... pParametro) {
		super(FabApiRestOllhamaAgenteModel.MODELO_CRIAR, pTipoAgente, pUsuario,
				pParametro);
	}
}