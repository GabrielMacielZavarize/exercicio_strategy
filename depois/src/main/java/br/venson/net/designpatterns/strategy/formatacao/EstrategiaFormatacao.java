package br.venson.net.designpatterns.strategy.formatacao;

import br.venson.net.designpatterns.strategy.Pedido;

/** Estratégia: como o cliente é identificado no relatório. */
@FunctionalInterface
public interface EstrategiaFormatacao {

    String etiqueta(Pedido pedido);
}
