package br.venson.net.designpatterns.strategy.formatacao;

import br.venson.net.designpatterns.strategy.Pedido;

public class FormatacaoCorporativa implements EstrategiaFormatacao {

    @Override
    public String cabecalho(Pedido pedido) {
        return "[CORPORATIVO] " + pedido.getCliente().getNome().toUpperCase() + " - faturamento em 30 dias";
    }
}
