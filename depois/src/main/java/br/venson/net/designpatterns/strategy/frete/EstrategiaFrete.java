package br.venson.net.designpatterns.strategy.frete;

import br.venson.net.designpatterns.strategy.Pedido;

/** Estratégia: família de algoritmos de cálculo de frete. */
@FunctionalInterface
public interface EstrategiaFrete {

    double calcular(Pedido pedido);
}
