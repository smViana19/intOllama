package br.org.coletivoJava.integracoes.restIntollama.implementacao;

import br.org.coletivoJava.integracoes.restIntollama.api.InfoIntegracaoRestIntollamaChat;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOllamaChat;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabConfigOllama;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreDataHora;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.TokenDeAcessoExternoDinamico;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.gestaoToken.GestaoTokenChaveUnica;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.ItfTokenDeAcessoExterno;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;

import java.util.Date;

@InfoIntegracaoRestIntollamaChat(tipo = FabApiRestOllamaChat.CONVERSA_NOVA_SESSAO)
public class GestaoTokenRestIntollama extends GestaoTokenChaveUnica {

	@Override
	public ItfTokenDeAcessoExterno loadTokenArmazenado() {
		return null;
	}

	@Override
	public boolean validarToken() {
		return false;
	}

	public GestaoTokenRestIntollama(final FabTipoAgenteClienteApi pTipoAgente,
									final ItfUsuario pUsuario) {
		super(FabApiRestOllamaChat.class, pTipoAgente, pUsuario);
	}

	@Override
	public ItfTokenDeAcessoExterno gerarNovoToken() {
		setToken(new TokenDeAcessoExternoDinamico("semToken", UtilSBCoreDataHora.incrementaDias(new Date(), 360)));
		return getTokenCompleto();
	}
}