package br.venson.net.designpatterns.strategy.formatacao;

import br.venson.net.designpatterns.strategy.Pedido;

/** Estratégia: como o cabeçalho do relatório é apresentado. */
@FunctionalInterface
public interface EstrategiaFormatacao {

    String cabecalho(Pedido pedido);
}
