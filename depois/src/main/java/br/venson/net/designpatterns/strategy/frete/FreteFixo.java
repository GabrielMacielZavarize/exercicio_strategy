package br.venson.net.designpatterns.strategy.frete;

import br.venson.net.designpatterns.strategy.Pedido;

public class FreteFixo implements EstrategiaFrete {

    private final double valor;

    public FreteFixo(double valor) {
        this.valor = valor;
    }

    @Override
    public double calcular(Pedido pedido) {
        return valor;
    }
}
