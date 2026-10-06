package br.venson.net.designpatterns.strategy.frete;

import br.venson.net.designpatterns.strategy.Pedido;

/**
 * Parte comum a todos os fretes por tipo de cliente (peso e região).
 * Cada subclasse informa apenas a sua taxa base.
 */
public abstract class FretePorTipo implements EstrategiaFrete {

    private static final double POR_KG = 3.0;
    private static final double ADICIONAL_NORTE = 30.0;

    protected abstract double freteBase();

    @Override
    public final double calcular(Pedido pedido) {
        double adicionalRegiao = "norte".equalsIgnoreCase(pedido.getRegiao()) ? ADICIONAL_NORTE : 0.0;
        return freteBase() + pedido.getPeso() * POR_KG + adicionalRegiao;
    }
}
