package br.org.coletivoJava.integracoes.restIntollama.implementacao;

import com.super_bits.modulosSB.SBCore.integracao.libRestClient.WS.conexaoWebServiceClient.RespostaWebServiceSimples;

public class UtilOlhamaTratamentoErro {
     public static void gerarRespostaTratamentoFino(RespostaWebServiceSimples pRespostaWSSemTratamento) throws Exception {
          throw new Exception("Erro ao tentar executar sua requisicao, tente novamente: " + pRespostaWSSemTratamento);
     }

}
