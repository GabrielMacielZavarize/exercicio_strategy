package br.venson.net.designpatterns.strategy.desconto;

import br.venson.net.designpatterns.strategy.Pedido;

public class DescontoVip implements EstrategiaDesconto {

    @Override
    public double calcular(Pedido pedido) {
        return pedido.getValor() * 0.10;
    }
}
