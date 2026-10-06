package br.venson.net.designpatterns.strategy.desconto;

import br.venson.net.designpatterns.strategy.Pedido;

/** Regra temporária (ex.: Black Friday), aplicável a qualquer tipo de cliente. */
public class DescontoPromocional implements EstrategiaDesconto {

    private final double percentual;

    public DescontoPromocional(double percentual) {
        if (percentual < 0 || percentual > 100) {
            throw new IllegalArgumentException("Percentual deve estar entre 0 e 100");
        }
        this.percentual = percentual;
    }

    @Override
    public double calcular(Pedido pedido) {
        return pedido.getValor() * percentual / 100.0;
    }
}
