package br.venson.net.designpatterns.strategy.formatacao;

import br.venson.net.designpatterns.strategy.Pedido;

public class FormatacaoCorporativa implements EstrategiaFormatacao {

    @Override
    public String etiqueta(Pedido pedido) {
        return "Cliente corporativo (20% de desconto)";
    }
}
