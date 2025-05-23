package br.org.coletivoJava.integracoes.restIntolhamma.implementacao;

import br.org.coletivoJava.integracoes.restIntolhamma.api.InfoIntegracaoRestIntolhammaChat;
import br.org.coletivoJava.integracoes.ollama.api.chat.FabApiRestOlhamaChat;
import com.super_bits.modulosSB.SBCore.UtilGeral.UtilSBCoreDataHora;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.implementacao.gestaoToken.GestaoTokenChaveUnica;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.ItfTokenDeAcessoExterno;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.FabTipoAgenteClienteApi;
import com.super_bits.modulosSB.SBCore.integracao.libRestClient.api.token.TokenDeAcessoExternoDinamico;
import com.super_bits.modulosSB.SBCore.modulos.objetos.registro.Interfaces.basico.ItfUsuario;
import java.util.Date;

@InfoIntegracaoRestIntolhammaChat(tipo = FabApiRestOlhamaChat.CONVERSA_NOVA_SESSAO)
public class GestaoTokenRestIntolhamma extends GestaoTokenChaveUnica {

    @Override
    public ItfTokenDeAcessoExterno loadTokenArmazenado() {
        return null;
    }

    @Override
    public boolean validarToken() {
        return false;
    }

    public GestaoTokenRestIntolhamma(final FabTipoAgenteClienteApi pTipoAgente,
            final ItfUsuario pUsuario) {
        super(FabApiRestOlhamaChat.class, pTipoAgente, pUsuario);
    }

    @Override
    public ItfTokenDeAcessoExterno gerarNovoToken() {
        setToken(new TokenDeAcessoExternoDinamico("semToken", UtilSBCoreDataHora.incrementaDias(new Date(), 360)));
        return getTokenCompleto();
    }

}
