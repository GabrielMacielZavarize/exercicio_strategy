package br.venson.net.designpatterns.strategy.desconto;

import br.venson.net.designpatterns.strategy.Pedido;

/** Estratégia: família de algoritmos de desconto intercambiáveis. */
@FunctionalInterface
public interface EstrategiaDesconto {

    double calcular(Pedido pedido);
}
