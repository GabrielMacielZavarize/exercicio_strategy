package br.venson.net.designpatterns.strategy.desconto;

import br.venson.net.designpatterns.strategy.Pedido;

public class DescontoCorporativo implements EstrategiaDesconto {

    @Override
    public double calcular(Pedido pedido) {
        double percentual = pedido.getValor() >= 1000 ? 0.15 : 0.05;
        return pedido.getValor() * percentual;
    }
}
