package br.venson.net.designpatterns.strategy.frete;

import br.venson.net.designpatterns.strategy.Pedido;

/** Regra de campanha: frete zerado, independentemente de peso e região. */
public class FreteGratis implements EstrategiaFrete {

    @Override
    public double calcular(Pedido pedido) {
        return 0.0;
    }
}
