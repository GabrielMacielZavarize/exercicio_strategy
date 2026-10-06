package br.venson.net.designpatterns.strategy;

import br.venson.net.designpatterns.strategy.desconto.EstrategiaDesconto;
import br.venson.net.designpatterns.strategy.frete.EstrategiaFrete;

import java.util.Objects;

/**
 * Contexto do Strategy: não decide nada, apenas delega para as estratégias
 * recebidas. As estratégias podem ser trocadas em tempo de execução.
 */
public class CalculadoraPedido {

    private EstrategiaDesconto estrategiaDesconto;
    private EstrategiaFrete estrategiaFrete;

    public CalculadoraPedido(EstrategiaDesconto estrategiaDesconto, EstrategiaFrete estrategiaFrete) {
        setEstrategiaDesconto(estrategiaDesconto);
        setEstrategiaFrete(estrategiaFrete);
    }

    public static CalculadoraPedido para(PerfilCliente perfil) {
        return new CalculadoraPedido(perfil.desconto(), perfil.frete());
    }

    public void setEstrategiaDesconto(EstrategiaDesconto estrategiaDesconto) {
        this.estrategiaDesconto = Objects.requireNonNull(estrategiaDesconto);
    }

    public void setEstrategiaFrete(EstrategiaFrete estrategiaFrete) {
        this.estrategiaFrete = Objects.requireNonNull(estrategiaFrete);
    }

    public double desconto(Pedido pedido) {
        return estrategiaDesconto.calcular(pedido);
    }

    public double frete(Pedido pedido) {
        return estrategiaFrete.calcular(pedido);
    }

    public double total(Pedido pedido) {
        return pedido.getValor() - desconto(pedido) + frete(pedido);
    }
}
