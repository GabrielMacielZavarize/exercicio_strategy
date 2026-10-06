package br.venson.net.designpatterns.strategy.formatacao;

import br.venson.net.designpatterns.strategy.Pedido;

public class FormatacaoComum implements EstrategiaFormatacao {

    @Override
    public String cabecalho(Pedido pedido) {
        return "Pedido de " + pedido.getCliente().getNome();
    }
}
