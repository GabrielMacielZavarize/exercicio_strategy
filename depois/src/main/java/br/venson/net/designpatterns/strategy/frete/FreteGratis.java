package br.venson.net.designpatterns.strategy.frete;

import br.venson.net.designpatterns.strategy.Pedido;

public class FreteGratis implements EstrategiaFrete {

    @Override
    public double calcular(Pedido pedido) {
        return 0.0;
    }
}
