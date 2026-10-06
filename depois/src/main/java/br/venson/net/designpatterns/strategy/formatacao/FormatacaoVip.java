package br.venson.net.designpatterns.strategy.formatacao;

import br.venson.net.designpatterns.strategy.Pedido;

public class FormatacaoVip implements EstrategiaFormatacao {

    @Override
    public String etiqueta(Pedido pedido) {
        return "Cliente VIP (10% de desconto)";
    }
}
