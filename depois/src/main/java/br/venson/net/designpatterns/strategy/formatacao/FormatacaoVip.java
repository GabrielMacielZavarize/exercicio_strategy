package br.venson.net.designpatterns.strategy.formatacao;

import br.venson.net.designpatterns.strategy.Pedido;

public class FormatacaoVip implements EstrategiaFormatacao {

    @Override
    public String cabecalho(Pedido pedido) {
        return "*** Pedido VIP de " + pedido.getCliente().getNome() + " ***";
    }
}
