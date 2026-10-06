package br.venson.net.designpatterns.strategy.desconto;

import br.venson.net.designpatterns.strategy.Pedido;

public class DescontoComum implements EstrategiaDesconto {

    @Override
    public double calcular(Pedido pedido) {
        return pedido.getValor() * 0.0;
    }
}
