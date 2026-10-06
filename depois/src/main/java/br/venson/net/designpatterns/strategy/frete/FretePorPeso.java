package br.venson.net.designpatterns.strategy.frete;

import br.venson.net.designpatterns.strategy.Pedido;

public class FretePorPeso implements EstrategiaFrete {

    private static final double TAXA_BASE = 15.0;
    private static final double POR_KG = 2.0;

    @Override
    public double calcular(Pedido pedido) {
        return TAXA_BASE + pedido.getPesoKg() * POR_KG;
    }
}
