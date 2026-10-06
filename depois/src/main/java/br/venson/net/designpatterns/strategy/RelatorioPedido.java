package br.venson.net.designpatterns.strategy;

import br.venson.net.designpatterns.strategy.formatacao.EstrategiaFormatacao;

/**
 * Não conhece TipoCliente nem nenhuma regra concreta: recebe o contexto
 * (que só depende das interfaces de estratégia) e a estratégia de formatação.
 */
public class RelatorioPedido {

    private final CalculadoraPedido calculadora;
    private final EstrategiaFormatacao formatacao;

    public RelatorioPedido(CalculadoraPedido calculadora, EstrategiaFormatacao formatacao) {
        this.calculadora = calculadora;
        this.formatacao = formatacao;
    }

    public String formatar(Pedido pedido) {
        return String.format(
                "%s | valor: %.2f | desconto: %.2f | frete: %.2f | total: %.2f",
                formatacao.etiqueta(pedido),
                pedido.getValor(),
                calculadora.desconto(pedido),
                calculadora.frete(pedido),
                calculadora.total(pedido));
    }
}
